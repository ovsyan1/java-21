package mapPlzOrt;

import java.util.Map;

abstract class MyScanner {
    protected final Map<String, String> postalCodes;

    MyScanner(Map<String, String> postalCodes) {
        this.postalCodes = postalCodes;
    }
}
