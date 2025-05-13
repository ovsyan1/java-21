package collectWarenkorb;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

record Produkt(String name, int preis) {}

record Bestellung(String produktName, int anzahl) {}

public class CollectWarenKorb {
    public static void main(String... args) {
        List<Produkt> products = new ArrayList<>();
        products.add(new Produkt("Brot", 129));
        products.add(new Produkt("Wurst", 230));
        products.add(new Produkt("Milch", 99));
        products.add(new Produkt("Milch", 99));

        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Produkt> acc = (target, next) -> target.add(next.preis());
        BiConsumer<List<Integer>, List<Integer>> cmb = List::addAll;

        int gesamtPreis = products.stream().parallel().collect(supplier, acc, cmb).stream().mapToInt(x -> x).sum();
        System.out.println(gesamtPreis);

        List<Bestellung> bestellungen = new ArrayList<>();
        bestellungen.add(new Bestellung("Öl", 1));
        bestellungen.add(new Bestellung("Brot", 3));
        bestellungen.add(new Bestellung("Wurst", 1));
        bestellungen.add(new Bestellung("Milch", 2));


        List<Produkt> warenkorb = buildWarenkorb(bestellungen);
        System.out.println(warenkorb);
    }

    static List<Produkt> buildWarenkorb(List<Bestellung> bestellungen) {
        Map<String, Integer> produkts = new HashMap<>(Map.of(
                "Brot", 129,
                "Wurst", 230,
                "Milch", 99));


        return bestellungen.stream().collect(
                ArrayList::new,
                (a, b) -> {
                    for (int i = 0; i < b.anzahl(); i++) {
                        a.add(new Produkt(b.produktName(), produkts.getOrDefault(b.produktName(), 222)));
                    }
                },
                ArrayList::addAll);
    }
}
