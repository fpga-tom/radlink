package org.rad.kernel.cpp;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.rad.kernel.Block;
import org.rad.kernel.Translator;

public class CppStaticTranslator implements Translator {

	public static final String TEMPLATE = "/templates/rad.cc.vm";

	public String translate(Block block) {

		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template t = ve.getTemplate(TEMPLATE);

		VelocityContext context = new VelocityContext();

		context.put("block", block);
		context.put("CppOperation", new CppOperation());
		StringWriter out = new StringWriter();
		t.merge(context, out);

		return out.toString();

	}

}
