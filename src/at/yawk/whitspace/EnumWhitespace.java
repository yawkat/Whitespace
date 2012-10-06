package at.yawk.whitspace;

public enum EnumWhitespace {
	SPACEBAR, TABULATOR, LINEFEED, NULL;
	
	public static EnumWhitespace parse(final char c) {
		switch(c) {
		case ' ':
			return SPACEBAR;
		case '\t':
			return TABULATOR;
		case '\n':
			return LINEFEED;
		default:
			return NULL;
		}
	}
}
