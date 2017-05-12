import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class Problem5 {
	static long intialCount[][];
	static long frequency[][];
	static int len;
	
	public static void main(String[] args) throws IOException {
		InputReader in=new InputReader(System.in);
		OutputWriter out=new OutputWriter(System.out);
		String str = in.next();
		char carr[] = str.toCharArray();
		len = carr.length;
		intialCount = new long[13][len + 1];
		frequency = new long[5][len + 1];
		int cn;
		for (int i = 0; i < len; i++) {
			cn = getCodes(carr[i]);
			frequency[cn][i + 1] = frequency[cn][i] + 1;
			for (int j = 1; j <= 4; j++) {
				if (j != cn) {
					frequency[j][i + 1] = frequency[j][i];
				}
			}

			int a = 0, b = 0, c = 0;
			if (i >= 1) {
				if (cn == 1) {
					intialCount[7][i + 1] = intialCount[7][i]
							+ frequency[2][i + 1];
					intialCount[8][i + 1] = intialCount[8][i]
							+ frequency[3][i + 1];
					intialCount[9][i + 1] = intialCount[9][i]
							+ frequency[4][i + 1];
					a = 7;
					b = 8;
					c = 9;
				}
				if (cn == 2) {
					intialCount[1][i + 1] = intialCount[1][i]
							+ frequency[1][i + 1];
					intialCount[10][i + 1] = intialCount[10][i]
							+ frequency[3][i + 1];
					intialCount[11][i + 1] = intialCount[11][i]
							+ frequency[4][i + 1];
					a = 1;
					b = 10;
					c = 11;
				}
				if (cn == 3) {
					intialCount[2][i + 1] = intialCount[2][i]
							+ frequency[1][i + 1];
					intialCount[4][i + 1] = intialCount[4][i]
							+ frequency[2][i + 1];
					intialCount[12][i + 1] = intialCount[12][i]
							+ frequency[4][i + 1];
					a = 2;
					b = 4;
					c = 12;
				}
				if (cn == 4) {
					intialCount[3][i + 1] = intialCount[3][i]
							+ frequency[1][i + 1];
					intialCount[5][i + 1] = intialCount[5][i]
							+ frequency[2][i + 1];
					intialCount[6][i + 1] = intialCount[6][i]
							+ frequency[3][i + 1];
					a = 3;
					b = 5;
					c = 6;
				}
			}
			for (int j = 1; j <= 12; j++) {
				if (j != a && j != b && j != c) {
					intialCount[j][i + 1] = intialCount[j][i];
				}
			}
		}
		int m = in.nextInt();
		for (int i = 1; i <= m; i++) {
			String c=in.next();
			String c1 = in.next();

			cn = getFinalCodes(c+c1);
			int L = in.nextInt();
			int R = in.nextInt();
			if (L == 1) {
				out.printLine(intialCount[cn][R]);
				continue;
			} else {
				out.printLine(numberOfString(L, R, cn, c.charAt(0), c1.charAt(0)));
				
			}
		}
		out.flush();
	}

	static long numberOfString(int L, int R, int cn, char c, char c1) {
		int cf = getCodes(c);
		int cf1 = getCodes(c1);
		long t = frequency[cf1][R] - frequency[cf1][L - 1];
		t = t * frequency[cf][L - 1];
		long temp = intialCount[cn][R] - t - intialCount[cn][L - 1];
		return temp;
	}

	static int getCodes(char c) {
		switch (c) {
		case 'c':
			return 1;
		case 'h':
			return 2;
		case 'e':
			return 3;
		case 'f':
			return 4;
		}
		return -1;
	}

	static int getFinalCodes(String cstr) {
		switch (cstr) {
		case "ch":
			return 1;
		case "ce":
			return 2;
		case "cf":
			return 3;
		case "he":
			return 4;
		case "hf":
			return 5;
		case "ef":
			return 6;
		case "hc":
			return 7;
		case "ec":
			return 8;
		case "fc":
			return 9;
		case "eh":
			return 10;
		case "fh":
			return 11;
		case "fe":
			return 12;
		}
		return -1;
	}

}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c & 15;
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String next() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

}
class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

	}


