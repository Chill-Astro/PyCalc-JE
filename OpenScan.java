import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/* v1.0
 * Assuming that sc is your OpenScan object,
 * sc.next() reads the next token from the input.
 * sc.nextInt() reads the next token as an integer.
 * sc.nextDouble() reads the next token as a double.
 * sc.nextLine() reads the next line of text.
 * sc.nextChar() reads the first character of the next token.
 * sc.nextBoolean() reads the next token as a boolean.
 * sc.nextShort() reads the next token as a short.
 * sc.nextByte() reads the next token as a byte.
 * sc.nextLong() reads the next token as a long.
 * sc.nextFloat() reads the next token as a float.
 * sc.nextStringList() reads all remaining tokens from the current line as Strings.
 * sc.nextIntArray(int count) reads multiple integers from the current line.
 * sc.nextLongArray(int count) reads multiple longs from the current line.
 * sc.nextDoubleArray(int count) reads multiple doubles from the current line.
 * sc.readAllInts() reads all integers from the input until the end of input.
 * sc.readAllDoubles() reads all doubles from the input until the end of input.
 * sc.readAllLongs() reads all longs from the input until the end of input.
 * sc.readAllStrings() reads all strings from the input until the end of input.
 * sc.skipLines(int linesToSkip) skips a specified number of lines from the input.
 * sc.hasNext() checks if there is another token available.
 * sc.close() closes the underlying BufferedReader.
 */

public class OpenScan implements AutoCloseable {

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private String line;

    /**
     * Constructs a new OpenScan object that reads from System.in.
     */
    public OpenScan() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Reads the next token from the input.
     *
     * @return The next token as a String.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                line = reader.readLine();
                if (line == null) {
                    throw new NoSuchElementException("End of input reached");
                }
                tokenizer = new StringTokenizer(line);
            } catch (IOException e) {
                throw new RuntimeException("Error reading from input", e);
            }
        }
        return tokenizer.nextToken();
    }

    /**
     * Reads the next line of text from the input.
     *
     * @return The line read as a String, or null if the end of the stream is reached.
     * @throws RuntimeException if an I/O error occurs.
     */
    public String nextLine() {
        try {
            tokenizer = null; // clear tokenizer for next line
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading line from input", e);
        }
    }

    /**
     * Reads the next token as an integer.
     *
     * @return The integer value read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws NumberFormatException  if the next token is not a valid integer.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public int nextInt() {
        return Integer.parseInt(next());
    }

    /**
     * Reads the next token as a long.
     *
     * @return The long value read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws NumberFormatException  if the next token is not a valid long.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public long nextLong() {
        return Long.parseLong(next());
    }

    /**
     * Reads the next token as a double.
     *
     * @return The double value read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws NumberFormatException  if the next token is not a valid double.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public double nextDouble() {
        return Double.parseDouble(next());
    }

    /**
     * Reads the next token as a float.
     *
     * @return The float value read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws NumberFormatException  if the next token is not a valid float.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public float nextFloat() {
        return Float.parseFloat(next());
    }

    /**
     * Reads the next token as a boolean.
     *
     * @return The boolean value read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws RuntimeException      if an I/O error occurs.
     */
    public boolean nextBoolean() {
        return Boolean.parseBoolean(next());
    }

    /**
     * Reads the first character of the next token.
     *
     * @return The first character read.
     * @throws NoSuchElementException if there are no more tokens.
     * @throws RuntimeException      if the next token is an empty string.
     */
    public char nextChar() {
        String token = next();
        if (token.isEmpty()) {
            throw new RuntimeException("Empty token encountered while expecting a character");
        }
        return token.charAt(0);
    }

    /**
     * Checks if there is another token available.
     *
     * @return true if another token is available, false otherwise.
     */
    public boolean hasNext() {
        if (tokenizer != null && tokenizer.hasMoreTokens()) {
            return true;
        }
        try {
             line = reader.readLine();
             if (line == null) {
                return false;
             }
             tokenizer = new StringTokenizer(line);
             return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException("Error checking for next token", e);
        }
    }

    /**
    * Reads the next token as a short.
    * @return The short value read.
    * @throws NoSuchElementException if there are no more tokens.
    * @throws NumberFormatException  if the next token is not a valid short.
    * @throws RuntimeException      if an I/O error occurs.
    */
    public short nextShort() {
        return Short.parseShort(next());
    }
    /**
    * Reads the next token as a byte.
    * @return The byte value read.
    * @throws NoSuchElementException if there are no more tokens.
    * @throws NumberFormatException  if the next token is not a valid byte.
    * @throws RuntimeException      if an I/O error occurs.
    */
    public byte nextByte() {
        return Byte.parseByte(next());
    }

     /**
     * Reads multiple integers from the current line.
     * @param count The number of integers to read.
     * @return An array of integers.
     * @throws NoSuchElementException if there are not enough tokens on the current line.
     * @throws NumberFormatException if any of the tokens are not valid integers.
     */
    public int[] nextIntArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    
    /**
     * Reads multiple longs from the current line.
     * @param count The number of longs to read.
     * @return An array of longs.
     * @throws NoSuchElementException if there are not enough tokens on the current line.
     * @throws NumberFormatException if any of the tokens are not valid longs.
     */
    public long[] nextLongArray(int count) {
        long[] array = new long[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    /**
     * Reads multiple doubles from the current line.
     * @param count The number of doubles to read.
     * @return An array of doubles.
     * @throws NoSuchElementException if there are not enough tokens on the current line.
     * @throws NumberFormatException if any of the tokens are not valid doubles.
     */
    public double[] nextDoubleArray(int count) {
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = nextDouble();
        }
        return array;
    }
    
    /**
     * Reads all remaining tokens from the current line as Strings.
     * @return A List of String tokens.
     */
    public List<String> nextStringList() {
        List<String> list = new ArrayList<>();
        while (tokenizer != null && tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    /**
     * Skips a specified number of lines from the input.
     * @param linesToSkip The number of lines to skip.
     * @throws RuntimeException if an I/O error occurs.
     */
    public void skipLines(int linesToSkip) {
        try {
            for (int i = 0; i < linesToSkip; i++) {
                if (reader.readLine() == null) {
                    // End of input reached before skipping all lines
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error skipping lines in input", e);
        }
    }
     /**
     * Reads all integers from the input until the end of input.
     * @return A list containing all integers read.
     * @throws NumberFormatException if any of the tokens are not valid integers.
     */
    public List<Integer> readAllInts() {
        List<Integer> numbers = new ArrayList<>();
        while (hasNext()) {
            numbers.add(nextInt());
        }
        return numbers;
    }

    /**
     * Reads all doubles from the input until the end of input.
     * @return A list containing all doubles read.
     * @throws NumberFormatException if any of the tokens are not valid doubles.
     */
    public List<Double> readAllDoubles() {
        List<Double> numbers = new ArrayList<>();
        while (hasNext()) {
            numbers.add(nextDouble());
        }
        return numbers;
    }

    /**
     * Reads all longs from the input until the end of input.
     * @return A list containing all longs read.
     * @throws NumberFormatException if any of the tokens are not valid longs.
     */
    public List<Long> readAllLongs() {
        List<Long> numbers = new ArrayList<>();
        while (hasNext()) {
            numbers.add(nextLong());
        }
        return numbers;
    }

    /**
     * Reads all strings from the input until the end of input.
     * @return A list containing all strings read.
     */
    public List<String> readAllStrings() {
        List<String> strings = new ArrayList<>();
        while (hasNext()) {
            strings.add(next());
        }
        return strings;
    }

    /**
     * Closes the underlying BufferedReader.
     * This should be called when the OpenScan object is no longer needed,
     * preferably using a try-with-resources statement.
     */
    @Override
    public void close() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Warning: Error closing input reader: " + e.getMessage());
        }
    }
}