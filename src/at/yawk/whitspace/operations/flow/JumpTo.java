package at.yawk.whitspace.operations.flow;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.SubroutineLabel;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class JumpTo implements IOperation {

	private final SubroutineLabel	label;

	public JumpTo(final SubroutineLabel label) {
		this.label = label;
	}
	
	@Override
	public void execute(VM vm, Program program) {
		program.index = program.getLabelIndex(label);
	}
	
}
