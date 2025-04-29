package collectionsAutos;

abstract class Auto {
    protected int baujahr;
    protected String modell;

    Auto(String modell, int baujahr) {
        this.modell = modell;
        this.baujahr = baujahr;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ". Modell: " + this.modell + ", Baujahr " + this.baujahr;
    }
}
