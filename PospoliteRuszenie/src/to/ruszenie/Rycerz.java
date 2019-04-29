package to.ruszenie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rycerz {
    protected List<Lenno> lenna;
    protected List<Rycerz> wasale;
    protected Rycerz senior;
    protected Wojsko wojsko;

    public Rycerz(List<Lenno> lenna) {
        this.lenna = lenna;
        this.wasale = new ArrayList<>();
        this.senior = null;
    }

    public int obliczIloscWojska(){
        return (int)(this.getZamoznosc()*10);
                //(this.lenna.stream().mapToDouble(Lenno::getZamoznosc).sum())* 10;
    }


    public List<Lenno> getLenna() {
        return lenna;
    }

    public void przekazLenno(Rycerz wasal, Lenno lenno) {
        if (this.wasale.size() >= 7) throw new ZaDuzoWasaliException();
        if (lenna.remove(lenno)) {
            wasal.zlozHold(this, lenno);
            this.wasale.add(wasal);
        } else throw new BrakLennaException();
    }


    public void wezDobroOdPrzeciwnika(Rycerz przeciwnik){
        double randomDouble = Math.random();
        int rozmiar = przeciwnik.lenna.size();
        randomDouble = randomDouble * (rozmiar) + 1;
        int randomInt = (int) randomDouble;

        Lenno lennoDoPrzekazania = przeciwnik.lenna.remove(randomInt-1);
        this.lenna.add(lennoDoPrzekazania);
        int liczbaWojska = obliczIloscWojska();
        this.wojsko.setLiczebnosc(liczbaWojska);


        int liczbaWojskaPrzeciwnika = przeciwnik.obliczIloscWojska();
        System.out.println("Nowe wojsko przeciwnika");
        System.out.println(liczbaWojskaPrzeciwnika);
        System.out.println();
        przeciwnik.wojsko.setLiczebnosc(liczbaWojskaPrzeciwnika);

    }


    public void walcz(Rycerz przeciwnik) {
        int liczbaWojska = obliczIloscWojska(); //wojsko proporcjonalne do zamoznosci
        this.wojsko = new Wojsko(liczbaWojska);

        int liczbaWojskaPrzeciwnika = obliczIloscWojska(); //wojsko proporcjonalne do zamoznosci
        przeciwnik.wojsko = new Wojsko(liczbaWojskaPrzeciwnika);


        if (this.wojsko.getLiczebnosc() > przeciwnik.wojsko.getLiczebnosc())//this.getZamoznosc() > przeciwnik.getZamoznosc())
            this.pokonaj(przeciwnik);

        else
            przeciwnik.pokonaj(this);
    }

    // TODO: dodać logikę -  DODANE
    public void pokonaj(Rycerz przeciwnik) {
        if(!przeciwnik.wasale.isEmpty()){ ///wybieram losowego wasala przeciwnika jeśli go ma
            int rozmiar = wasale.size();
            double randomDouble = Math.random();
            randomDouble = randomDouble * (rozmiar) + 1;
            int randomInt = (int) randomDouble;

            Rycerz usuniety = przeciwnik.wasale.remove(randomInt-1);
            this.wasale.add(usuniety);
        }

        else {
            this.wezDobroOdPrzeciwnika(przeciwnik); //jeśli nie ma wasala
        }

        System.out.print("Wygrałem\n");
    }

    public double getZamoznosc() {
        return this.lenna.stream().mapToDouble(Lenno::getZamoznosc).sum()
                + this.wasale.stream().mapToDouble(Rycerz::getZamoznosc).sum();
    }

    protected void zlozHold(Rycerz senior, Lenno lenno) {
        if (this.senior != null) throw new WasalZaprzysiezonyException();
        this.senior = senior;
        this.lenna.add(lenno);
    }

    @Override
    public String toString() {
        return super.toString() + ": Mój budżet to  " + getZamoznosc() + " Moje wojsko to " +  this.obliczIloscWojska();
    }

    public String show() {
        return show("");
    }

    public String show(String prefix) {
        return prefix
                + this.toString()
                + "\n"
                + this.wasale.stream().map(wasal -> wasal.show(prefix + "  ")).collect(Collectors.joining(""));
    }

}
