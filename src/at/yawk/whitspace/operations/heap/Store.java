package at.yawk.whitspace.operations.heap;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Store implements IOperation {

	@Override
	public void execute(VM vm, Program program) {
		vm.heapStore();
	}
	
}
