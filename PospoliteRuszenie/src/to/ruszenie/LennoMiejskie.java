package to.ruszenie;

import java.util.Random;

public class LennoMiejskie extends Lenno {
    public LennoMiejskie() {
        this.zamoznosc = (new Random().nextDouble() + 1) * 20; //od 20 do 40
    }

    @Override
    public boolean podzielne() {
        return false;
    }

    @Override
    public Lenno podziel() {
        throw new IllegalArgumentException();   //nie można podzielić lenna miejskiego
    }
}
