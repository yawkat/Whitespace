package at.yawk.whitspace;

public class StackElement {
	private final long	value;
	
	public StackElement(final long value) {
		this.value = value;
	}
	
	public StackElement add(final StackElement se) {
		return new StackElement(this.value + se.value);
	}
	
	public StackElement sub(final StackElement se) {
		return new StackElement(this.value - se.value);
	}
	
	public StackElement multi(final StackElement se) {
		return new StackElement(this.value * se.value);
	}
	
	public StackElement divide(final StackElement se) {
		return new StackElement(this.value / se.value);
	}
	
	public StackElement mod(final StackElement se) {
		return new StackElement(this.value % se.value);
	}
	
	@Override
	public boolean equals(final Object o) {
		return o instanceof StackElement && ((StackElement)o).value == this.value;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(value).hashCode();
	}
	
	public long get() {
		return value;
	}
}
