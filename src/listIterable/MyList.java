package listIterable;

import java.util.Iterator;


public class MyList implements Iterable<String> {
  private String[] values = new String[10];
  private int size = 0;

  void add(String s) throws ExceptionInInitializerError {
    if(this.size < this.values.length) {
      values[size++] = s;
    } else {
      throw new ExceptionInInitializerError("MyList ist voll");
    }

  }

  int size() {
    return this.size;
  }

  String get(int index) {
    if(index < 0 || index >= this.size) {
      throw new IllegalArgumentException("Not right index");
    }
    return this.values[index];
  }

  @Override
  public Iterator<String> iterator() {
    return new Iterator<>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < size && values[index] != null;
      }

      @Override
      public String next() {
        return values[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}
