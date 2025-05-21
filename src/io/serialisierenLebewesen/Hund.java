package io.serialisierenLebewesen;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.io.ObjectInputStream;

class Hund extends Lebewesen implements Serializable {
  String name;
  transient Mensch besitzer;

  Hund(int alter, String name, Mensch besitzer) {
    super(alter);
    this.name = name;
    this.besitzer = besitzer;
  }

  @Override
  public String toString() {
    return "Hund: " + name + ", Alter: " + alter + ". Besitzer: " + besitzer;
  }

  @Serial
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();

    oos.writeInt(this.alter);
    oos.writeUTF(this.name);
    oos.writeUTF(this.besitzer.vorname);
    oos.writeUTF(this.besitzer.nahcname);
  }

  @Serial
  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();

    this.alter = ois.readInt();
    this.name = ois.readUTF();

    this.besitzer = new Mensch(ois.readUTF(), ois.readUTF());
  }
}
