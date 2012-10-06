package at.yawk.whitspace.operations.stack;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;
import at.yawk.whitspace.operations.IOperation;

public class Slide implements IOperation {

	private final int	count;

	@Override
	public void execute(VM vm, Program program) {
		vm.slide(count);
	}
	
	public Slide(final int count) {
		this.count = count;
	}
}
