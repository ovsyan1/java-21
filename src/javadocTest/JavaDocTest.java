package javadocTest;

/**
 * Class JavaDocTest created special for familiarization with "How create documentation via javadoc command"
 *
 * @author Kyrylo Ovsiannik
 * @version 1.0.0
 */

public class JavaDocTest {
    /**
     * Instance variable, just for naming this class
     */

    private String name;


    /**
     * adds two primitive numbers коммент на русском
     *
     * @param a is first number
     * @param b is second number
     * @return sum of a + b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * substracts first param from second
     *
     * @param a is first param
     * @param b is second param
     * @return result after substraction
     */

    public int substract(int a, int b) {
        return a - b;
    }
}
