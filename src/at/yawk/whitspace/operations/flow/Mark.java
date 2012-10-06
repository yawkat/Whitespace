package at.yawk.whitspace.operations.flow;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.SubroutineLabel;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Mark implements IOperation {
	
	public final SubroutineLabel	label;
	
	public Mark(final SubroutineLabel label) {
		this.label = label;
	}
	
	@Override
	public void execute(VM vm, Program program) {
		
	}
	
}
