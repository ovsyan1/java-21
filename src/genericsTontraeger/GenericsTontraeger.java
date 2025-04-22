package genericsTontraeger;

interface Tontraeger {
}

class Schallplatte implements Tontraeger {
}

class Tonband implements Tontraeger {
}

class CD implements Tontraeger {
}

class Abspielgeraet<T extends Schallplatte, V extends CD> {
    void abspielen(T t) {
    }

    void abspielen(V v) {
    }
}

public class GenericsTontraeger {
    public static void main(String[] args) {
        Abspielgeraet<Schallplatte, CD> ref = new Abspielgeraet<>();

        ref.abspielen(new Schallplatte());
        //ref.abspielen(new Tonband()); // cf
        ref.abspielen(new CD());
    }
}
