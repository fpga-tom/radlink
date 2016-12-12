package org.rad.kernel;

public class Waveform {

	Block masterBlock;
	private Translator translator;

	public Waveform(Translator translator) {
		this.translator = translator;
	}

	public String generate() {
		masterBlock.setMatrix(masterBlock.generate());
		return translator.translate(masterBlock);
	}

	public Waveform add(Block b) {
		masterBlock = b;
		return this;
	}
}
