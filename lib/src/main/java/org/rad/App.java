package org.rad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FileUtils;
import org.rad.kernel.Waveform;
import org.rad.kernel.graph.BlockBuilder;
import org.rad.kernel.parser.jgraphx.JGraphxParser;
import org.rad.kernel.translator.TranslatorEnum;

public class App {

	public static void main(String[] argv) throws FileNotFoundException, JAXBException {

		Waveform w = new Waveform(TranslatorEnum.CppParallel.getTranslator());
		w.add(BlockBuilder.build(JGraphxParser.parseXml("jgraphx.xml")));
		System.out.println(w.generate());
	}

	public static void compileModel(TranslatorEnum t, String xml, File output) throws JAXBException, IOException {
		Waveform w = new Waveform(t.getTranslator());
		w.add(BlockBuilder.build(JGraphxParser.parseString(xml)));
		FileUtils.writeStringToFile(output, w.generate());

	}
}