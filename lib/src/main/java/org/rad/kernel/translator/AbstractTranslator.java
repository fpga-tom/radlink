package org.rad.kernel.translator;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

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
