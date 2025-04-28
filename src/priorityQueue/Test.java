package priorityQueue;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Task firstTask = new Task("Autowäsche", EPrioritaet.LOW);
        Task secondTask = new Task("Einkaufen", EPrioritaet.NORMAL);
        Task thirdTask = new Task("Rechnung bezahlen'", EPrioritaet.HIGH);

        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

        firstTask.setTermin(LocalDateTime.of(2025, 5, 5, 10, 0, 0));
        secondTask.setTermin(LocalDateTime.of(2025, 5, 5, 10, 0, 0));
        thirdTask.setTermin(LocalDateTime.of(2025, 5, 15, 18, 0, 0));

        priorityQueue.offer(firstTask);
        priorityQueue.offer(secondTask);
        priorityQueue.offer(thirdTask);

        System.out.println(priorityQueue);


        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
