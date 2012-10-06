package at.yawk.whitspace.operations.io;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class PrintChar implements IOperation {

	@Override
	public void execute(VM vm, Program program) {
		vm.printTopChar();
	}
	
}
