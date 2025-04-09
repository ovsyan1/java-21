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

  Stockwerk getStockwerk(int stockwerkNr) throws IndexOutOfBoundsException, Exception {
    if(stockwerkNr < 0) {
      throw new Exception("Stockwerk nummer muss positiv sein.");
    }

    try {
      return this.floors.get(stockwerkNr == 0 ? stockwerkNr : stockwerkNr - 1);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Gebäude hat nicht so viel Stockwerke 'getStockwerk'");
    }
  }

  Raum getRaum(int stockwerkNr, int raumNr) throws IndexOutOfBoundsException, Exception {
    if(raumNr < 0) {
      throw new Exception("Raum nummer muss positive sein.");
    }

    try {
      return this.getStockwerk(stockwerkNr).rooms.get(raumNr == 0 ? raumNr : raumNr - 1);
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
      return "Stockwerk nummer " + (this.floorNumber == 0 ? this.floorNumber : this.floorNumber + 1);
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
      return "Raum " + (this.floorNumber == 0 ? this.floorNumber : this.floorNumber + 1) + "." +(this.roomNumber == 0 ? this.roomNumber : this.roomNumber + 1) + " / " + Gebaeude.this.streetName + " " + Gebaeude.this.houseNumber;
    }
  }
}
