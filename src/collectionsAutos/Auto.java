package collectionsAutos;

class Auto implements Comparable<Auto>  {
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

    @Override
    public int compareTo(Auto auto) {
        return this.modell.compareTo(auto.modell) == 0 ? this.baujahr - auto.baujahr : this.modell.compareTo(auto.modell);
    }
}
