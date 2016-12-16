package org.rad.kernel.translator;

import org.rad.kernel.translator.cpp.parallel.CppThreadTranslator;
import org.rad.kernel.translator.cpp.sequential.CppStaticTranslator;

public enum TranslatorEnum {

	CppSequential(new CppStaticTranslator(), "sequential"), CppParallel(new CppThreadTranslator(), "parallel");

	private Translator translator;
	private String description;

	public Translator getTranslator() {
		return translator;
	}

	private TranslatorEnum(Translator translator, String description) {
		this.translator = translator;
		this.description = description;
	}

}
