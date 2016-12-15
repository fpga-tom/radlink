package org.rad.kernel.cpp.parallel;

import java.util.ArrayList;
import java.util.List;

import org.rad.kernel.Block;
import org.rad.kernel.cpp.AbstractTranslator;
import org.rad.kernel.cpp.CppOperation;

public class CppThreadTranslator extends AbstractTranslator {

	public static final String TEMPLATE = "/templates/rad_thread.cc.vm";

	private int threadCount = 1;

	public CppThreadTranslator(int threadCount) {
		super(TEMPLATE);
		this.threadCount = threadCount;
	}

	@Override
	public String translate(Block block) {
		int nodePerTile = (block.getCount() + threadCount - 1) / threadCount;
		List<Tile> tiles = new ArrayList<Tile>();

		int threadCounter = block.getCount();
		int tileCounter = 0;

		while (threadCounter - nodePerTile >= 0) {
			tiles.add(new Tile(block, tileCounter++, block.getCount(), nodePerTile));
			threadCounter -= nodePerTile;
		}

		if (threadCounter > 0) {
			tiles.add(new Tile(block, tileCounter++, block.getCount(), nodePerTile));
		}

		context.put("block", block);
		context.put("tiles", tiles);
		context.put("barrier", threadCount + 1);
		context.put("threadCount", threadCount);
		context.put("CppOperation", new CppOperation());
		return merge();
	}

}
