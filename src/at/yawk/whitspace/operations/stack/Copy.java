package at.yawk.whitspace.operations.stack;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Copy implements IOperation {
	private final int	element;

	public Copy(final int element) {
		this.element = element;
	}

	@Override
	public void execute(VM vm, Program program) {
		vm.copyFrom(element);
	}
}
