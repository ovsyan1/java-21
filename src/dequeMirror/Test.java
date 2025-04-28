package dequeMirror;

public class Test {
    public static void main(String[] args) {
        Mirror m = new Mirror();

        for (char ch = 'a'; ch < 'g'; ch++) {
            m.add(ch);
            System.out.println(m);
        }

        System.out.println("******************");

        while( !m.isEmpty() ) {
            System.out.println(m);
            m.remove();
        }
    }
}
