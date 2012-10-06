package at.yawk.whitspace.operations.stack;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.StackElement;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Push implements IOperation {
	private final StackElement	element;

	public Push(final StackElement element) {
		this.element = element;
	}
	
	@Override
	public void execute(VM vm, Program program) {
		vm.push(element);
	}
	
}
