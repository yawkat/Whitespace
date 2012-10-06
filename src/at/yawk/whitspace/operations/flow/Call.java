package at.yawk.whitspace.operations.flow;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.SubroutineLabel;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Call implements IOperation {

	private final SubroutineLabel	label;

	public Call(final SubroutineLabel label) {
		this.label = label;
	}
	
	@Override
	public void execute(VM vm, Program program) {
		final int indexbef = program.index;
		program.executeFrom(program.getLabelIndex(label), vm);
		program.index = indexbef;
	}
	
}
