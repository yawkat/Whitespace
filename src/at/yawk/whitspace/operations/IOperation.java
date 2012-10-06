package at.yawk.whitspace.operations;

import at.yawk.whitspace.Program;
import at.yawk.whitspace.VM;

public interface IOperation {
	public void execute(final VM vm, final Program program);
}
