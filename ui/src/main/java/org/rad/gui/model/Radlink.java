package org.rad.gui.model;

import org.rad.kernel.translator.TranslatorEnum;

public class Radlink {

	private TranslatorEnum translator;

	private int threadCount;

	private String outputFile;

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public TranslatorEnum getTranslator() {
		return translator;
	}

	public void setTranslator(TranslatorEnum translator) {
		this.translator = translator;
	}

}
