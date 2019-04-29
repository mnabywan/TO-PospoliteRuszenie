package to.ruszenie;

public abstract class Lenno {
    protected double zamoznosc;

    public abstract boolean podzielne();

    public abstract Lenno podziel();

    public double getZamoznosc() {
        return zamoznosc;
    }
}
