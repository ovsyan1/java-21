package javadocTest;

/**
 * Class Person was created, because we need ...
 */

public final class Person {
    /**
     * method onCLick, special
     *
     */
    public void onClick() {
        System.out.println("Clicked");
    }

    /**
     * should be used for pre request to db
     *
     * @param key is first param
     * @param value is second param
     * @return employee
     */

    public String preRequest(int key, String value, String department) {
        System.out.println("key " + key);
        System.out.println("value " + value);
        System.out.println("department " + department);

        return "Vasaaz";
    }
}
