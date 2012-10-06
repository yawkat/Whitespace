package at.yawk.whitspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.yawk.whitspace.operations.IOperation;
import at.yawk.whitspace.operations.flow.EndSubroutine;
import at.yawk.whitspace.operations.flow.Mark;

public final class Program implements Runnable {
	private final List<IOperation> operations;
	private final Map<SubroutineLabel, Integer> labels = new HashMap<SubroutineLabel, Integer>();
	private boolean running = true;
	public int index = 0;
	
	public Program(final List<IOperation> operations) {
		this.operations = new ArrayList<>(operations);
	}

	public void executeFrom(final int line, VM vm) {
		index = line;
		while(running) {
			final IOperation io = operations.get(index);
			if(io instanceof EndSubroutine) {
				break;
			} else {
				io.execute(vm, this);
				index++;
			}
		}
	}
	
	public final boolean continueRunning() {
		return running;
	}
	
	public final void stop() {
		running = false;
	}

	@Override
	public void run() {
		for(int i = 0; i < operations.size(); i++)
			if(operations.get(i) instanceof Mark)
				labels.put(((Mark)operations.get(i)).label, i);
		executeFrom(0, new VM());
	}
	
	public int getLabelIndex(final SubroutineLabel sl) {
		return labels.get(sl);
	}
}
