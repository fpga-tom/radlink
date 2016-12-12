package org.rad.kernel.parser.jgraphx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.rad.kernel.graph.Edge;
import org.rad.kernel.graph.Graph;
import org.rad.kernel.graph.Vertex;
import org.rad.kernel.parser.IParser;

public class JGraphxParser implements IParser {

	public static Graph parseXml(String file) throws JAXBException, FileNotFoundException {
		JGraphxParser p = new JGraphxParser();
		return p.parse((new FileInputStream(new File(file))));
	}

	public static Graph parseString(String s) throws JAXBException, FileNotFoundException {
		JGraphxParser p = new JGraphxParser();
		return p.parse(new StringBufferInputStream(s));
	}

	public Graph parse(InputStream s) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MxGraphModel.class);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		MxGraphModel model = (MxGraphModel) unmarshaller.unmarshal(s);

		HashMap<Integer, Integer> forwardMapping = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> reverseMapping = new HashMap<Integer, Integer>();
		Graph result = new Graph();

		Graph g = result;

		int vid = 0;
		for (MxCell c : model.getRoot().getMxCell()) {
			if (!c.isEdge()) {
				if (c.getCellValue() != null) {
					CellValue cv = c.getCellValue();
					if (cv.getCellValueTypeEnum() != null) {
						CellValueTypeEnum e = cv.getCellValueTypeEnum();
						String typeName = e.getTypeName();
						if ("bool".equals(typeName)) {
							g.setBinary(true);
						}
					}
				}
				String name = c.getCellValue() == null ? "" : c.getCellValue().getName();
				Vertex v = new Vertex(vid++, name);
				forwardMapping.put(c.getId(), v.getId());
				reverseMapping.put(v.getId(), c.getId());
				g.getVertex().add(v);
			}
		}

		for (MxCell c : model.getRoot().getMxCell()) {
			if (c.isEdge()) {
				int src = forwardMapping.get(c.getSource());
				int dst = forwardMapping.get(c.getTarget());
				double value = 1.0;
				if (!"".equals(c.getValue()))
					value = Double.parseDouble(c.getValue());

				Edge v = new Edge(src, dst, value);
				g.getEdge().add(v);
			}
		}

		return result;
	}

}
