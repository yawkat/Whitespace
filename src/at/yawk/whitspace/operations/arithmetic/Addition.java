package at.yawk.whitspace.operations.arithmetic;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Addition implements IOperation {

	@Override
	public void execute(VM vm, Program program) {
		vm.addTop();
	}
	
}
