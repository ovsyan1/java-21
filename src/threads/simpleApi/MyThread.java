package threads.simpleApi;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    public static void main(String... args) throws InterruptedException {
        Thread thread1 = new MyThread("My first thread");
//        a1(thread1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("out");
            }
        };
        Thread thread2 = new Thread(runnable);
//        a2(thread2);

        List<Thread> list = new ArrayList<>();
        for(int i = 1; i <= 37; i++) {
            list.add(new Thread());
        }

        for(Thread t : list) {
            t.start();
            System.out.println(t.threadId());
        }

        List<Thread> list2 = new ArrayList<>();

        Random r = new Random();
        Runnable runnable2 = () -> {
            System.out.println((char)(r.nextInt(26) + 'a'));
        };

        for(int i = 1; i <= 26; i++) {
            list2.add(new Thread(runnable2));
        }

        for(Thread t : list2) {
            t.start();
        }
    }

    static void a2(Thread thread) throws InterruptedException {
        while (true) {
            thread.run();
            System.out.println(thread.getName());
            System.out.println(thread.threadId());
            thread.sleep(1000);
        }
    }

    static void a1(Thread thread) throws InterruptedException {
        while (true) {
            thread.run();
            System.out.println(thread.getName());
            System.out.println(thread.threadId());
            thread.sleep(1000);
        }
    }
}
