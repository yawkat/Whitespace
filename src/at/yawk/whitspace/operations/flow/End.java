package at.yawk.whitspace.operations.flow;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class End implements IOperation {

	@Override
	public void execute(VM vm, Program program) {
		program.stop();
	}
	
}
