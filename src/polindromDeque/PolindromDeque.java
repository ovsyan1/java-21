package polindromDeque;

import java.util.Deque;
import java.util.ArrayDeque;

public class PolindromDeque {
    public static void main(String[] args) {
        Character[] arr = {'a', 'n', 'n', 'a'};

        boolean erg = isPalindrome(arr);
        System.out.println(erg); // true

        arr = new Character[]{'r', 'o', 't', 'o', 'r'};
        erg = isPalindrome(arr);
        System.out.println(erg); // true

        arr = new Character[]{'m', 'o', 't', 'o', 'r'};
        erg = isPalindrome(arr);
        System.out.println(erg); // false

//        System.out.println(isPolindrome("blaalb")); // true
    }

    static boolean isPalindrome(Character[] arr) {
        Deque<Character> deque = new ArrayDeque<>();

        for (Character ch : arr) {
            deque.offer(ch);
        }

        boolean result = true;

        while (result && deque.size() > 1) {
            result = deque.pollFirst().compareTo(deque.pollLast()) == 0;
        }


        return result;
    }

//    static boolean isPolindrome(String str) {
//        Deque<Character> deque = new ArrayDeque<>();
//
//        for (Character ch : str.toLowerCase().toCharArray()) {
//            deque.offer(ch);
//        }
//
//        boolean result = true;
//
//        while (result && deque.size() > 1) {
//            result = deque.pollFirst().compareTo(deque.pollLast()) == 0;
//        }
//
//
//        return result;
//    }

}
