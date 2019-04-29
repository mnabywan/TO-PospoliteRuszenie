package to.ruszenie;

public class LennoDlaRycerza extends Akcja {

    private Rycerz dlaKogo;

    public LennoDlaRycerza(Rycerz rycerz) {
        dlaKogo = rycerz;
    }

    @Override
    public void wykonaj() {
//        Lenno lenno;
//
//        /* Każdy rycerz dostaje 10 lenn */
//        for (int i = 0; i < 10; i++) {
//
//            /* po 50% szans że będzie to lenno miejskie bądź ziemiańskie */
//            if (new Random().nextDouble() < 0.5) {
//                lenno = new LennoMiejskie();
//            } else {
//                lenno = new LennoZiemianskie();
//            }
//            dlaKogo.przyjmijLenno(lenno);
//
//        }
    }
}
