package at.yawk.whitspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VM {
	private List<StackElement>				stack	= new ArrayList<>();
	private Map<StackElement, StackElement>	heap	= new HashMap<>();
	
	public void push(final StackElement element) {
		stack.add(0, element);
	}
	
	public void duplicateTop() {
		stack.add(1, stack.get(0));
	}
	
	public void copyFrom(final int stackPosition) {
		stack.add(0, stack.get(stackPosition));
	}
	
	public void swapTop() {
		final StackElement top = stack.get(0);
		stack.set(0, stack.get(1));
		stack.set(1, top);
	}
	
	public void discardTop() {
		stack.remove(0);
	}
	
	public void slide(final int count) {
		for(int i = 0; i < count; i++)
			stack.remove(1);
	}
	
	public void addTop() {
		final StackElement se = stack.get(0).add(stack.get(1));
		stack.set(0, se);
		stack.set(1, se);
	}
	
	public void subTop() {
		final StackElement se = stack.get(0).sub(stack.get(1));
		stack.set(0, se);
		stack.set(1, se);
	}
	
	public void multiTop() {
		final StackElement se = stack.get(0).multi(stack.get(1));
		stack.set(0, se);
		stack.set(1, se);
	}
	
	public void divideTop() {
		final StackElement se = stack.get(0).divide(stack.get(1));
		stack.set(0, se);
		stack.set(1, se);
	}
	
	public void modTop() {
		final StackElement se = stack.get(0).mod(stack.get(1));
		stack.set(0, se);
		stack.set(1, se);
	}
	
	public void heapRetrieve() {
		stack.add(0, heap.get(stack.get(0)));
	}
	
	public void heapStore() {
		heap.put(stack.get(1), stack.get(0));
	}
	
	public void printTopChar() {
		System.out.write((int)stack.get(0).get());
	}
	
	public void printTopNum() {
		System.out.print((int)stack.get(0).get());
	}
	
	public void readChar() {
		try {
			stack.add(0, new StackElement(System.in.read()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void readNumber() {
		stack.add(0, new StackElement(new Scanner(System.in).nextLong()));
	}
	
	public StackElement getTop() {
		return stack.size() == 0 ? new StackElement(0) : stack.get(0);
	}
}
