package org.rad.kernel.parser.jgraphx;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MxGraphModel.class);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		MxGraphModel model = (MxGraphModel) unmarshaller.unmarshal(new File("jgraphx.xml"));

	}

}
