package gebaeude;

import java.util.ArrayList;
import java.util.List;

public class Gebaeude {
  private final List<Stockwerk> floors = new ArrayList<>();
  private final String streetName;
  private final int houseNumber;

  Gebaeude(String streetName, int houseNumber, int countOfFloors, int countOfRooms) throws Exception {
    this.streetName = streetName;
    this.houseNumber = houseNumber;

    if (countOfFloors <= 0) {
      throw new Exception("Gebäude muss mindestens ein Stockwerk haben.");
    }

    for (int i = 0; i < countOfFloors; i++) {
      this.floors.add(new Stockwerk(i, countOfRooms));
    }
  }

  Stockwerk getStockwerk(int stockwerkNr) {
    try {
      return this.floors.get(stockwerkNr);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Gebäude hat nicht so viel Stockwerke");
    }
  }

  Raum getRaum(int stockwerkNr, int raumNr) {
    try {
      return this.getStockwerk(stockwerkNr).rooms.get(raumNr);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Gebäude hat nicht so viel Stockwerke");
    }
  }

  class Stockwerk {
    private final int floorNumber;
    private final List<Raum> rooms = new ArrayList<>();

    Stockwerk(int floorNumber, int numberOfRooms) throws Exception {
      this.floorNumber = floorNumber;

      if (numberOfRooms <= 0) {
        throw new Exception("Das Stockwerk muss mindestens einen Raum haben. ");
      }

      for (int i = 0; i < numberOfRooms; i++) {
        this.rooms.add(new Raum(floorNumber, i));
      }
    }

    @Override
    public String toString() {
      return "Stockwerk nummer " + this.floorNumber;
    }
  }

  class Raum {
    private final int floorNumber;
    private final int roomNumber;

    Raum(int floorNumber, int roomNumber) {
      this.floorNumber = floorNumber;
      this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
      return "Raum " + this.floorNumber + "." + this.roomNumber + " / " + Gebaeude.this.streetName + " " + Gebaeude.this.houseNumber;
    }
  }
}
