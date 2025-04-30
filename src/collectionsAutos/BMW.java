package collectionsAutos;

class BMW extends Auto {
    BMW(String modell, int baujahr) {
        super(modell, baujahr);
    }

    void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    @Override
    public int hashCode() {
        return this.baujahr;
    }
}
