package to.ruszenie;

import java.util.List;

public class Krol extends Rycerz {
    private String imie;
    private String rod;

    public Krol(String imie, String rod, List<Lenno> lenna) {
        super(lenna);
        this.rod = rod;
        this.imie = imie;
    }

    @Override
    public void zlozHold(Rycerz senior, Lenno lenno) {
        throw new KrolNieSkladaHolduException();
    }
}
