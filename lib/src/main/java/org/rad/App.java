package org.rad;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import org.rad.kernel.Waveform;
import org.rad.kernel.cpp.parallel.CppThreadTranslator;
import org.rad.kernel.graph.BlockBuilder;
import org.rad.kernel.parser.jgraphx.JGraphxParser;

public class App {

	public static void main(String[] argv) throws FileNotFoundException, JAXBException {

		Waveform w = new Waveform(new CppThreadTranslator(4));
		// w.add(new FMReceiver());
		w.add(BlockBuilder.build(JGraphxParser.parseXml("jgraphx.xml")));
		System.out.println(w.generate());
	}
}