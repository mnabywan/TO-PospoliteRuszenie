package to.ruszenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // stwórz króli
        Krol krolA = new Krol("Król Wielki", "Ród", zrobTrocheZiem(11));
        Krolestwo krolestwoA = new Krolestwo(krolA);
        Krol krolB = new Krol("Król Maksymalny", "Ród", zrobTrocheZiem(10));
        Krolestwo krolestwoB = new Krolestwo(krolB);

        // stwórz rycerzy
        Rycerz rycerzA1 = new Rycerz(zrobTrocheZiem(5));
        Rycerz rycerzA2 = new Rycerz(zrobTrocheZiem(2));
        Rycerz rycerzA3 = new Rycerz(zrobTrocheZiem(2));
        Rycerz rycerzA4 = new Rycerz(zrobTrocheZiem(2));

        Rycerz rycerzB1 = new Rycerz(zrobTrocheZiem(5));
        Rycerz rycerzB2 = new Rycerz(zrobTrocheZiem(3));
        Rycerz rycerzB3 = new Rycerz(zrobTrocheZiem(3));

        // zbuduj strukturę
        krolA.przekazLenno(rycerzA1, krolA.getLenna().get(0));
        rycerzA1.przekazLenno(rycerzA2, rycerzA1.getLenna().get(0));
        rycerzA1.przekazLenno(rycerzA3, rycerzA1.getLenna().get(0));
        rycerzA2.przekazLenno(rycerzA4, rycerzA2.getLenna().get(0));

        krolB.przekazLenno(rycerzB1, krolB.getLenna().get(0));
        rycerzB1.przekazLenno(rycerzB2, rycerzB1.getLenna().get(0));
        rycerzB1.przekazLenno(rycerzB3, rycerzB1.getLenna().get(0));

        // pokaż hierarchię
        System.out.println(krolA.show());
        System.out.println(krolB.show());



        /*
        System.out.println("RYCERZ1");
        System.out.println(rycerzA1.show());
        System.out.println("RYCERZ2");
        System.out.println(rycerzB3.show());
        */
        // walka

        System.out.println("WALCZACY RYCERZE");
        krolA.walcz(krolB);
        //rycerzA1.walcz(rycerzB3);

        // pokaż hierarchię
        System.out.println(krolA.show());
        System.out.println(krolB.show());
    }

    public static List<Lenno> zrobTrocheZiem(int length) {
        List<Lenno> lenna = new ArrayList<>();
        for (int i = 0; i < length; i++)
            lenna.add(new Random().nextDouble() < 0.5 ? new LennoMiejskie() : new LennoZiemianskie());
        return lenna;
    }
}
