package at.yawk.whitspace.operations.stack;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Discard implements IOperation {

	@Override
	public void execute(VM vm, Program program) {
		vm.discardTop();
	}
	
}
