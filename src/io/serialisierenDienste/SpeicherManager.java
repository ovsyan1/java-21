package io.serialisierenDienste;

import java.io.*;

class SpeicherManager extends Dienst implements Serializable {
  private final int size;
  transient Defragmentierung defrag;

  SpeicherManager(int size, Defragmentierung defrag) {
    super("Sanierung");
    this.size = size;
    this.defrag = defrag;
  }

  @Override
  public String toString() {
    return "Manager. Size: " + this.size + ". Defrag-Dienst: " + this.defrag;
  }

  @Serial
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();

    oos.writeUTF(this.name);
    oos.writeInt(this.defrag.zeitabstand);
    oos.writeUTF(this.defrag.laufwerk);
  }

  @Serial
  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();

    this.name = ois.readUTF();
    this.defrag = new Defragmentierung(ois.readInt(), ois.readUTF());
  }
}
