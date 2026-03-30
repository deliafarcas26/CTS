package program;

import implementare.Decoratiune;
import implementare.Magazin;
import implementare.MallExceptie;
import implementare.Podea;

import static implementare.MaterialDecorativ.STICLA;

public class Main {
    public static void main(String[] args) {
        Magazin m1 = Magazin.getBuilder("Sephora", 101, 2).build();
        System.out.println(m1);

        Podea p1 = new Podea("parchet laminat", 2);
        Podea p2 = new Podea("parchet", 1);

        Magazin m2 = Magazin.getBuilder("Cremma", 68, 1).setPodea(p1).build();
        System.out.println(m2);

        Decoratiune d1 = new Decoratiune(STICLA, "vaza");
        Magazin m3 = null;
        try {
            m3 = Magazin.getBuilder("ZARA", 140, 2).setPodea(p2).addDecoratiune(d1).build();
        } catch (MallExceptie e) {
            System.out.println(e.getMessage());
        }
        System.out.println(m3);
    }
}