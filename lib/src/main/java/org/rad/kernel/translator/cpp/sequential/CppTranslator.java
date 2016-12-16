package org.rad.kernel.translator.cpp.sequential;

import org.rad.kernel.Block;
import org.rad.kernel.translator.Translator;

public class CppTranslator implements Translator {
	public String translate(Block block) {
		/*
		 * StringBuilder b = new StringBuilder(); b.append(include() + "\n");
		 * b.append(tmpvessel(block) + "\n"); b.append(vessel(block) + "\n");
		 * b.append(messenger(block) + "\n"); b.append(initMessenger(block) +
		 * "\n"); b.append(mycgemv() + "\n"); b.append(step(block) + "\n");
		 * 
		 * return b.toString();
		 */
		return null;

	}

	/*
	 * public String include() { return "#include<vector>\n" +
	 * "#include<boost/tuple/tuple.hpp>\n" + "#include<complex>\n" +
	 * "#include<string.h>\n"; }
	 * 
	 * public String vessel(Block b) { return "std::complex<float> vessel[" +
	 * b.getCount() + "] = {0, };"; }
	 * 
	 * public String tmpvessel(Block b) { return
	 * "std::complex<float> tmpvessel[" + b.getCount() + "] = {0, };"; }
	 * 
	 * public String messenger(Block block) { return
	 * "std::vector<boost::tuple<int, int, float> > messenger;"; }
	 * 
	 * public String initMessenger(Block block) { StringBuilder b = new
	 * StringBuilder(); b.append("void initMessenger() {\n"); for (Matrix m :
	 * block.getMatrix()) { for (Tuple t : m.getMatrix()) { b.append("\t" +
	 * translateTuple(t) + "\n"); } } b.append("}\n"); return b.toString(); }
	 * 
	 * public String mycgemv() { return "void mycgemv() {\n" +
	 * "\tmemset(tmpvessel, 0, sizeof(tmpvessel));\n" +
	 * "\tfor(std::vector<boost::tuple<int,int, float> >::iterator i = messenger.begin(); i != messenger.end(); i++) {\n"
	 * + "\t\tboost::tuple<int,int, float> p = *i;\n" +
	 * "\t\ttmpvessel[boost::get<1>(p)] += vessel[boost::get<0>(p)] * boost::get<2>(p);\n"
	 * + "\t}\n" + "\tmemcpy(vessel, tmpvessel, sizeof(vessel));\n" + "}"; }
	 * 
	 * public String translateTuple(Tuple t) { return
	 * "messenger.push_back(boost::make_tuple(" + t.getI() + ", " + t.getJ() +
	 * ", " + String.format("%.20f", t.getV()) + "));"; }
	 * 
	 * public String translateOperation(UnaryOperation op) { return "vessel[" +
	 * op.dst + "] = " + CppOperation.get(op.getOp()) + "(vessel[" + op.dst +
	 * "]);"; }
	 * 
	 * public String translateOperation(BinaryOperation op) { return "vessel[" +
	 * op.dst + "] = " + "(vessel[" + op.src + "])" +
	 * CppOperation.get(op.getOp()) + "(vessel[" + op.dst + "]);"; }
	 * 
	 * public String result(Block block) { return "return real(vessel[" +
	 * (block.getOutput(0)) + "]);"; }
	 * 
	 * public String step(Block block) { StringBuilder b = new StringBuilder();
	 * b.append("float step(std::complex<float> in) {" + "\n");
	 * b.append("\tvessel[" + block.getInput(0) + "] = in;" + "\n");
	 * b.append("\tmycgemv();" + "\n"); for (Matrix m : block.getMatrix()) { for
	 * (Operation op : m.getOp()) { if (op instanceof UnaryOperation) {
	 * b.append("\t" + translateOperation((UnaryOperation) op) + "\n"); } else
	 * if (op instanceof BinaryOperation) { b.append("\t" +
	 * translateOperation((BinaryOperation) op) + "\n"); } } } b.append("\t" +
	 * result(block) + "\n"); b.append("}" + "\n"); return b.toString(); }
	 */
}