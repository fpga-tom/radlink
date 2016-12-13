package org.rad.kernel.cpp.sequential;

import org.rad.kernel.Block;
import org.rad.kernel.cpp.AbstractTranslator;
import org.rad.kernel.cpp.CppOperation;

public class CppStaticTranslator extends AbstractTranslator {

	public static final String TEMPLATE = "/templates/rad.cc.vm";

	public CppStaticTranslator() {
		super(TEMPLATE);
	}

	public String translate(Block block) {

		context.put("block", block);
		context.put("CppOperation", new CppOperation());

		return merge();

	}

}
