package at.yawk.whitspace;

public class Whitespace {
	public static void main(final String[] args) {
		final Program pr = new Compiler().parseProgram("Ask the user how\tmany  \t   \nfibonacci\tnumbers\nthey want from the sequence \t\t \t\t\t\t\nand\tprint\nthat many one number per line.\t\t\t \t\t\t\n\t\n     \t     \n\t\n     \t\t \t\t \t\n\t\n     \t\t    \t\n\t\n     \t\t \t\t\t \n\t\n     \t\t\t\t  \t\n\t\n     \t\t\t\t\t\t\n\t\n     \t     \n\t\n     \t \n\t\n\t\t    \n   \t\n \n \t\n \t   \t \t \n\t\n  \n  \t\n \n    \t\n \n\t\t\t \t      \t\n\t\t\t \n\t \n \t\n \t   \t \t \n\t\n     \t \n\t\t\t   \t\n\t  \t \n    \t \n \n\t\t\t \n\t\t\t \n\n \n\t\n\n  \t \n\n\n");
		System.out.println("START");
		pr.run();
		System.out.println("END");
	}
}
