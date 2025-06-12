/* OpenScan v1.1

 - Assuming sc is the object, the following methods are available:

   * sc.next() -> Reads the next token as String
   * sc.nextLine() -> Reads the next line as String
   * sc.nextInt() -> Reads the next token as int
   * sc.nextLong() -> Reads the next token as long
   * sc.nextDouble() -> Reads the next token as double
   * sc.nextFloat() -> Reads the next token as float
   * sc.nextBoolean() -> Reads the next token as boolean
   * sc.nextShort() -> Reads the next token as short
   * sc.nextByte() -> Reads the next token as byte
   * sc.nextChar() -> Reads the first character of the next token
   * sc.hasNext() -> Checks if another token is available
   * sc.nextIntArray(n) -> Reads n integers into an int[]
   * sc.nextLongArray(n) -> Reads n longs into a long[]
   * sc.nextDoubleArray(n) -> Reads n doubles into a double[]
   * sc.nextStringArray(n) -> Reads n tokens into a String[]
   * sc.nextIntMatrix(r, c) -> Reads r x c integers into int[][]
   * sc.nextDoubleMatrix(r, c) -> Reads r x c doubles into double[][]
   * sc.nextStringList() -> Reads all remaining tokens in the current line as List<String>
   * sc.nextStringListLine() -> Reads all tokens from the current/new line as List<String>
   * sc.skipLines(n) -> Skips n lines
   * sc.readAllLines() -> Reads all lines as List<String>
   * sc.readUntil(delim) -> Reads tokens until delim is found (not included)
   * sc.peek() -> Peeks at the next token without consuming it
   * sc.readAllInts() -> Reads all remaining tokens as List<Integer>
   * sc.readAllDoubles() -> Reads all remaining tokens as List<Double>
   * sc.readAllLongs() -> Reads all remaining tokens as List<Long>
   * sc.readAllStrings() -> Reads all remaining tokens as List<String>
   * sc.close() -> Closes the input reader

 - Static Methods :
   * OpenScan.fromFile(path) -> Creates OpenScan from file
   * OpenScan.fromString(str) -> Creates OpenScan from string
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OpenScan implements AutoCloseable {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private String line;

    /**
     * Constructs a new OpenScan object that reads from System.in.
     */
    public OpenScan() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Ensures the tokenizer has more tokens, reading a new line if necessary.
     * @throws NoSuchElementException if end of input is reached.
     */
    private void ensureTokenizer() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                line = reader.readLine();
                if (line == null) throw new NoSuchElementException("End of input reached");
                tokenizer = new StringTokenizer(line);
            } catch (IOException e) {
                throw new RuntimeException("Error reading from input", e);
            }
        }
    }

    /**
     * Reads the next token from the input.
     * @return The next token as a String.
     */
    public String next() {
        ensureTokenizer();
        return tokenizer.nextToken();
    }

    /**
     * Reads the next line of text from the input.
     * @return The line read as a String, or null if the end of the stream is reached.
     */
    public String nextLine() {
        try {
            tokenizer = null;
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading line from input", e);
        }
    }

    public int nextInt() { return Integer.parseInt(next()); }
    public long nextLong() { return Long.parseLong(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public float nextFloat() { return Float.parseFloat(next()); }
    public boolean nextBoolean() { return Boolean.parseBoolean(next()); }
    public short nextShort() { return Short.parseShort(next()); }
    public byte nextByte() { return Byte.parseByte(next()); }
    // Reads the first character of the next token. @return The first character read.
    public char nextChar() {
        String token = next();
        if (token.isEmpty()) throw new RuntimeException("Empty token encountered while expecting a character");
        return token.charAt(0);
    }

    /* Checks if there is another token available. Return true if another token is available, false otherwise.
     */
    public boolean hasNext() {
        if (tokenizer != null && tokenizer.hasMoreTokens()) return true;
        try {
            line = reader.readLine();
            if (line == null) return false;
            tokenizer = new StringTokenizer(line);
            return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException("Error checking for next token", e);
        }
    }
    // Reads multiple integers from the input.
    public int[] nextIntArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) array[i] = nextInt();
        return array;
    }
    // Reads multiple longs from the input. 
    public long[] nextLongArray(int count) {
        long[] array = new long[count];
        for (int i = 0; i < count; i++) array[i] = nextLong();
        return array;
    }
    // Reads multiple doubles from the input.
    public double[] nextDoubleArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i < count; i++) array[i] = nextDouble();
        return array;
    }
    // Reads an array of Strings of given length.
    public String[] nextStringArray(int count) {
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) arr[i] = next();
        return arr;
    }

    // Reads a 2D int array (matrix) of size rows x cols.
    public int[][] nextIntMatrix(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = nextInt();
        return mat;
    }
    // Reads a 2D double array (matrix) of size rows x cols.
    public double[][] nextDoubleMatrix(int rows, int cols) {
        double[][] mat = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = nextDouble();
        return mat;
    }
    // Reads all remaining tokens from the current line as Strings.
    public List<String> nextStringList() {
        List<String> list = new ArrayList<>();
        while (tokenizer != null && tokenizer.hasMoreTokens()) list.add(tokenizer.nextToken());
        return list;
    }
    // Reads all tokens from the current line as Strings, reading a new line if needed.
    public List<String> nextStringListLine() {
        List<String> list = new ArrayList<>();
        if (tokenizer == null || !tokenizer.hasMoreTokens()) ensureTokenizer();
        while (tokenizer != null && tokenizer.hasMoreTokens()) list.add(tokenizer.nextToken());
        return list;
    }
    // Skips a specified number of lines from the input.
    public void skipLines(int linesToSkip) {
        try {
            for (int i = 0; i < linesToSkip; i++) if (reader.readLine() == null) return;
        } catch (IOException e) {
            throw new RuntimeException("Error skipping lines in input", e);
        }
    }
    // Reads all lines from input as a List of Strings.
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        String l;
        try {
            while ((l = reader.readLine()) != null) lines.add(l);
        } catch (IOException e) {
            throw new RuntimeException("Error reading all lines", e);
        }
        return lines;
    }
    /** Reads tokens until a given delimiter is found (delimiter is not included). */
    public List<String> readUntil(String delimiter) {
        List<String> tokens = new ArrayList<>();
        while (hasNext()) {
            String t = next();
            if (t.equals(delimiter)) break;
            tokens.add(t);
        }
        return tokens;
    }
    /** Peeks at the next token without consuming it. Returns null if no token. */
    public String peek() {
        if (tokenizer != null && tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tokenizer = new StringTokenizer(token + " " + tokenizerToString(tokenizer));
            return token;
        } else if (hasNext()) {
            String token = tokenizer.nextToken();
            tokenizer = new StringTokenizer(token + " " + tokenizerToString(tokenizer));
            return token;
        }
        return null;
    }
    // Helper to convert tokenizer to string (remaining tokens).
    private String tokenizerToString(StringTokenizer t) {
        StringBuilder sb = new StringBuilder();
        while (t != null && t.hasMoreTokens()) sb.append(t.nextToken()).append(" ");
        return sb.toString().trim();
    }

    // Reads all integers from the input until the end of input.
    public List<Integer> readAllInts() {
        List<Integer> numbers = new ArrayList<>();
        while (hasNext()) numbers.add(nextInt());
        return numbers;
    }
    // Reads all doubles from the input until the end of input.
    public List<Double> readAllDoubles() {
        List<Double> numbers = new ArrayList<>();
        while (hasNext()) numbers.add(nextDouble());
        return numbers;
    }
    // Reads all longs from the input until the end of input.
    public List<Long> readAllLongs() {
        List<Long> numbers = new ArrayList<>();
        while (hasNext()) numbers.add(nextLong());
        return numbers;
    }
    // Reads all strings from the input until the end of input.
    public List<String> readAllStrings() {
        List<String> strings = new ArrayList<>();
        while (hasNext()) strings.add(next());
        return strings;
    }    
    // Static factory: create OpenScan from a file path.
    public static OpenScan fromFile(String filePath) throws IOException {
        OpenScan sc = new OpenScan();
        sc.reader.close();
        sc.tokenizer = null;
        sc.line = null;
        java.io.FileReader fileReader = new java.io.FileReader(filePath);
        sc.reader = new BufferedReader(fileReader);
        // FileReader will be closed when sc.reader is closed
        return sc;
    }
    // Static factory: create OpenScan from a String input.
    public static OpenScan fromString(String input) {
        OpenScan sc = new OpenScan();
        try { sc.reader.close(); } catch (IOException ignored) {}
        sc.tokenizer = null;
        sc.line = null;
        sc.reader = new BufferedReader(new java.io.StringReader(input));
        return sc;
    }
    // Closes the underlying BufferedReader. This should be called when the OpenScan object is no longer needed.
    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Warning: Error closing input reader: " + e.getMessage());
        }
    }
}