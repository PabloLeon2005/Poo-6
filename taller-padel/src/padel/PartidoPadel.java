package padel;

import java.io.Serializable;

public class PartidoPadel implements Serializable {

    private String pareja1;
    private String pareja2;
    private int setsPareja1;
    private int setsPareja2;

    public PartidoPadel(String pareja1, String pareja2, int setsPareja1, int setsPareja2) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.setsPareja1 = setsPareja1;
        this.setsPareja2 = setsPareja2;
    }

    public String getPareja1() { return pareja1; }
    public String getPareja2() { return pareja2; }
    public int getSetsPareja1() { return setsPareja1; }
    public int getSetsPareja2() { return setsPareja2; }

    public String toString() {
        return pareja1 + " vs " + pareja2 + " | " + setsPareja1 + " - " + setsPareja2;
    }
}
