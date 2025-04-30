package collectionsAutos;

public class VW extends Auto {
    VW(String modell, int baujahr) {
        super(modell, baujahr);
    }

    @Override
    public int hashCode() {
        return baujahr;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof VW) {
            return ((VW)o).baujahr - this.baujahr == 0;
        }
        return false;
    }
}
