package org.rad.kernel.cpp;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.rad.kernel.Translator;

public abstract class AbstractTranslator implements Translator {

	private String template;
	protected VelocityContext context;
	private VelocityEngine ve;

	protected AbstractTranslator(String template) {
		this.template = template;

		ve = new VelocityEngine();
		ve.init();

		context = new VelocityContext();

	}

	protected String merge() {
		StringWriter out = new StringWriter();
		Template t = ve.getTemplate(template);
		t.merge(context, out);

		return out.toString();
	}

}
