package collectionsAutos;

import java.util.*;

public class Test {
    public static void main(String... args) {
        VW vw = new VW("Golf", 1990);
        BMW bmw = new BMW("Z4", 2000);

        System.out.println("************** VW-ZWEI AUTOS");
        System.out.println(vw);
        System.out.println(bmw);

        VW vw1 = new VW("Golf", 1990);
        VW vw2 = new VW("Polo", 2010);
        VW vw3 = new VW("Grand California", 2025);

        System.out.println("************** VW-LINKEDLIST");
        List<VW> vwList = new LinkedList<>();

        vwList.add(vw1);
        vwList.add(vw2);
        vwList.add(vw3);

        vwList.sort((a, b) -> a.modell.compareTo(b.modell) == 0 ? a.baujahr - b.baujahr : a.modell.compareTo(b.modell));

        printCollection(vwList);

        System.out.println("************** VW-HASHSET");
        Set<VW> vwSet = new HashSet<>();

        vwSet.add(vw1);
        vwSet.add(vw2);
        vwSet.add(vw3);
        vwSet.add(new VW("Grand California", 2025));

        printCollection(vwSet);

        System.out.println("************** VW-TREESET");
        Set<VW> vwTreeSet = new TreeSet<>();

        vwTreeSet.add(vw1);
        vwTreeSet.add(vw2);
        vwTreeSet.add(vw3);
        vwTreeSet.add( new VW("Golf", 1990));

        printCollection(vwTreeSet);

        System.out.println("************** VW-PriorityQueue");
        Queue<VW> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(vw1);
        priorityQueue.offer(vw2);
        priorityQueue.offer(vw3);
        priorityQueue.offer(vw3);

        printCollection(priorityQueue);

        BMW bmw1 = new BMW("Z4", 2000);
        BMW bmw2 = new BMW("M5", 2018);

        List<BMW> list = new ArrayList<>();

        list.add(bmw1);
        list.add(bmw2);

        System.out.println("************** BMW-ARRAYLIST");
        printCollection(list);

        Set<BMW> bmwSet = new HashSet<>();

        bmwSet.add(bmw1);
        bmwSet.add(bmw2);

        System.out.println("************** BMW-HASHSET");
        printCollection(bmwSet);

        Set<BMW> bmwTreeSet = new TreeSet<>();

        bmwTreeSet.add(bmw1);
        bmwTreeSet.add(bmw2);

        System.out.println("************** BMW-TREESET");
        printCollection(bmwTreeSet);

        Deque<BMW> bmwDeque = new ArrayDeque<>();

        bmwDeque.offer(bmw1);
        bmwDeque.offer(bmw2);

        System.out.println("************** BMW-DEQUE");
        printCollection(bmwDeque);

        System.out.println("************** contains in HashSet bmw1 ?");
        System.out.println(bmwSet.contains(bmw1));
        bmw1.setBaujahr(2003);
        System.out.println(bmwSet.contains(bmw1));

        vwList.add(new VW("Polo", 1974));
        vwList.sort((a, b) -> a.modell.compareTo(b.modell) == 0 ? a.baujahr - b.baujahr : a.modell.compareTo(b.modell));
        System.out.println(Collections.binarySearch(vwList, new VW("Polo", 1974)));

        Collections.sort(vwList, (a, b) -> a.baujahr - b.baujahr);
        System.out.println("************** SORTED-VW-LIST");
        printCollection(vwList);

        Collections.sort(vwList, (a, b) -> b.baujahr - a.baujahr);
        System.out.println("************** SORTET-REVERSED-VW-LIST");
        printCollection(vwList);

        System.out.println(Collections.binarySearch(vwList, new VW("Polo", 1974), (a, b) -> b.baujahr - a.baujahr));
        System.out.println(Collections.binarySearch(vwList, new VW("Polo", 3300), (a, b) -> b.baujahr - a.baujahr));
    }

    static <T extends Auto> void printCollection(Collection<T> collection) {
        collection.forEach(System.out::println);
    }
}
