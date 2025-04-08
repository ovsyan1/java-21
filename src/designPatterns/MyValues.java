package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class MyValues {
    private final List<Integer> list;

    public MyValues(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getValues() {
        return new ArrayList<>(list);
    }

    public List<Integer> addToEachValue(Integer val) {
        List<Integer> response = new ArrayList<>();

        for (int i : this.list) {
            response.add(i + val);
        }

        return response;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();

        for (int i = 0; i < this.list.size(); i++) {
            response.append(this.list.get(i));
            if (i != this.list.size() - 1) {
                response.append(", ");
            }
        }

        return "[" + response + "]";
    }

}
