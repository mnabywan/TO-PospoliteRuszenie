package to.ruszenie;

import java.util.Random;

public class LennoZiemianskie extends Lenno {

    public LennoZiemianskie() {
        this.zamoznosc = (new Random().nextDouble() + 1) * 10; //od 10 do 20
    }

    @Override
    public boolean podzielne() {
        return true;
    }

    @Override
    public Lenno podziel() {
        LennoZiemianskie poPodziale = new LennoZiemianskie();
        poPodziale.zamoznosc = this.zamoznosc / 2;

        this.zamoznosc /= 2;
        return poPodziale;
    }
}
