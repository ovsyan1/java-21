package mapBesitzerFahrzeuge;

class Fahrzeug {
    private String modell;
    private String hersteller;

    Fahrzeug(String modell, String hersteller) {
        this.modell = modell;
        this.hersteller = hersteller;
    }

    @Override
    public String toString() {
        return "Modell: " + this.modell + " Hersteller: " + this.hersteller;
    }
}
