package at.yawk.whitspace;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import at.yawk.whitspace.operations.IOperation;
import at.yawk.whitspace.operations.arithmetic.Addition;
import at.yawk.whitspace.operations.arithmetic.Division;
import at.yawk.whitspace.operations.arithmetic.Modulo;
import at.yawk.whitspace.operations.arithmetic.Multiplication;
import at.yawk.whitspace.operations.arithmetic.Subtraction;
import at.yawk.whitspace.operations.flow.Call;
import at.yawk.whitspace.operations.flow.End;
import at.yawk.whitspace.operations.flow.EndSubroutine;
import at.yawk.whitspace.operations.flow.JumpTo;
import at.yawk.whitspace.operations.flow.JumpToIfNegative;
import at.yawk.whitspace.operations.flow.JumpToIfZero;
import at.yawk.whitspace.operations.flow.Mark;
import at.yawk.whitspace.operations.heap.Retrieve;
import at.yawk.whitspace.operations.heap.Store;
import at.yawk.whitspace.operations.io.PrintChar;
import at.yawk.whitspace.operations.io.PrintNum;
import at.yawk.whitspace.operations.io.ReadChar;
import at.yawk.whitspace.operations.io.ReadNum;
import at.yawk.whitspace.operations.stack.Copy;
import at.yawk.whitspace.operations.stack.Discard;
import at.yawk.whitspace.operations.stack.Duplicate;
import at.yawk.whitspace.operations.stack.Push;
import at.yawk.whitspace.operations.stack.Slide;
import at.yawk.whitspace.operations.stack.Swap;

public class Compiler {
	public Program parseProgram(final String input) {
		final String exInput = input.replaceAll("[^ \t\n]", "");
		return parseProgram(new Enumeration<EnumWhitespace>() {
			private int	index	= 0;
			
			@Override
			public EnumWhitespace nextElement() {
				if(index < exInput.length())
					return EnumWhitespace.parse(exInput.charAt(index++));
				else
					return EnumWhitespace.NULL;
			}
			
			@Override
			public boolean hasMoreElements() {
				return index < exInput.length();
			}
		});
	}
	
	public Program parseProgram(final Enumeration<EnumWhitespace> stream) {
		final List<IOperation> l = new ArrayList<>();
		while(stream.hasMoreElements()) {
			EnumWhitespace w = stream.nextElement();
			switch(w) {
			case SPACEBAR: // STACK
				w = stream.nextElement();
				switch(w) {
				case SPACEBAR:
					l.add(new Push(new StackElement(parseNumber(stream))));
					break;
				case TABULATOR:
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						l.add(new Copy((int)parseNumber(stream)));
						break;
					case LINEFEED:
						l.add(new Slide((int)parseNumber(stream)));
						break;
					}
					break;
				case LINEFEED:
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						l.add(new Duplicate());
						break;
					case TABULATOR:
						l.add(new Swap());
						break;
					case LINEFEED:
						l.add(new Discard());
						break;
					}
					break;
				}
				break;
			case TABULATOR:
				w = stream.nextElement();
				switch(w) {
				case SPACEBAR: // ARITHMETIC
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						w = stream.nextElement();
						switch(w) {
						case SPACEBAR:
							l.add(new Addition());
							break;
						case TABULATOR:
							l.add(new Subtraction());
							break;
						case LINEFEED:
							l.add(new Multiplication());
							break;
						}
						break;
					case TABULATOR:
						w = stream.nextElement();
						switch(w) {
						case SPACEBAR:
							l.add(new Division());
							break;
						case TABULATOR:
							l.add(new Modulo());
							break;
						}
						break;
					case LINEFEED:
						
						break;
					}
					break;
				case TABULATOR: // HEAP
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						l.add(new Store());
						break;
					case TABULATOR:
						l.add(new Retrieve());
						break;
					}
					break;
				case LINEFEED:
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						w = stream.nextElement();
						switch(w) {
						case SPACEBAR:
							l.add(new PrintChar());
							break;
						case TABULATOR:
							l.add(new PrintNum());
							break;
						}
						break;
					case TABULATOR:
						w = stream.nextElement();
						switch(w) {
						case SPACEBAR:
							l.add(new ReadChar());
							break;
						case TABULATOR:
							l.add(new ReadNum());
							break;
						}
						break;
					}
					break;
				}
				break;
			case LINEFEED: // FLOW
				w = stream.nextElement();
				switch(w) {
				case SPACEBAR:
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						l.add(new Mark(new SubroutineLabel(parseNumber(stream))));
						break;
					case TABULATOR:
						l.add(new Call(new SubroutineLabel(parseNumber(stream))));
						break;
					case LINEFEED:
						l.add(new JumpTo(new SubroutineLabel(parseNumber(stream))));
						break;
					}
					break;
				case TABULATOR:
					w = stream.nextElement();
					switch(w) {
					case SPACEBAR:
						l.add(new JumpToIfZero(new SubroutineLabel(parseNumber(stream))));
						break;
					case TABULATOR:
						l.add(new JumpToIfNegative(new SubroutineLabel(parseNumber(stream))));
						break;
					case LINEFEED:
						l.add(new EndSubroutine());
						break;
					}
					break;
				case LINEFEED:
					if(stream.nextElement() == EnumWhitespace.LINEFEED)
						l.add(new End());
					break;
				}
				break;
			}
		}
		return new Program(l);
	}
	
	private long parseNumber(final Enumeration<EnumWhitespace> stream) {
		long l = 0;
		boolean negative = stream.nextElement() == EnumWhitespace.TABULATOR;
		EnumWhitespace w;
		while((w = stream.nextElement()) != EnumWhitespace.LINEFEED)
			l = (l << 1) | (w == EnumWhitespace.TABULATOR ? 1 : 0);
		return l;
	}
}
