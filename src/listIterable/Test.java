package listIterable;

public class Test {
  public static void main(String... args) {
    MyList myList = new MyList();

    myList.add("Hallo1");
    myList.add("Hallo2");
    myList.add("Hallo3");
    myList.add("Hallo4");
    myList.add("Hallo5");
    myList.add("Hallo6");
    myList.add("Hallo7");
    myList.add("Hallo8");
    myList.add("Hallo9");
    myList.add("Hallo10");
    // myList.add("Hallo11"); // es ist zu viele Elemente

    System.out.println(myList.size());
    System.out.println(myList.get(9));

    for(String s : myList) {
      System.out.println(s);
    }
  }
}
