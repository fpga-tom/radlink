package org.rad.kernel.parser;

import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.rad.kernel.graph.Graph;

public interface IParser {

	public Graph parse(InputStream i) throws JAXBException;

}
