package dequeMirror;

import java.util.Deque;
import java.util.ArrayDeque;

class Mirror {
    Deque<Character> deque = new ArrayDeque<>();

    void addDivider() {
        if (isEmpty()) {
            this.deque.add('|');
        }
    }

    void add(Character ch) {
        this.addDivider();

        this.deque.offer(ch);
        this.deque.push(ch);
    }

    boolean isEmpty() {
        return this.deque.isEmpty();
    }

    void remove() {
        this.deque.pollFirst();
        this.deque.pollLast();
        if(this.deque.size() <= 1) {
            this.deque.clear();
        }

    }

    @Override
    public String toString() {
        StringBuilder dequeString = new StringBuilder();

        for (Character ch : this.deque) {
            dequeString.append(ch);
        }

        return dequeString.toString();
    }

}
