package at.yawk.whitspace.operations.flow;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.SubroutineLabel;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class JumpToIfZero implements IOperation {

	private final SubroutineLabel	label;

	public JumpToIfZero(final SubroutineLabel label) {
		this.label = label;
	}
	
	@Override
	public void execute(VM vm, Program program) {
		if(vm.getTop().get() == 0)
			program.index = program.getLabelIndex(label);
	}
	
}
