package implementare;

import java.util.ArrayList;
import java.util.List;

import static implementare.MaterialDecorativ.LEMN;
import static implementare.MaterialDecorativ.STICLA;

public class Magazin {
    private String denumire;
    private float suprafata;
    private int nrIntrari;
    private Podea podea;
    private List<Decoratiune> decoratiuni;

    private Magazin(String denumire, float suprafata, int nrIntrari, Podea podea, List<Decoratiune> decoratiuni) {
        this.denumire = denumire;
        this.suprafata = suprafata;
        this.nrIntrari = nrIntrari;
        this.podea = podea;
        this.decoratiuni = decoratiuni;
    }

   public static MagazinBuilder getBuilder(String denumire, float suprafata, int nrIntrari){
        return new MagazinBuilder(denumire,suprafata,nrIntrari);
    }

    public double calculGradIncendiu(Magazin m){
        double grad=0; //
        double duritateMaterial=0;
        for(Decoratiune d : m.decoratiuni){
            switch(d.getMaterial()){
                case LEMN: duritateMaterial += 5; break;
                case STICLA: duritateMaterial += 3; break;
                case METAL: duritateMaterial += 1; break;
                case PLASTIC: duritateMaterial += 2; break;
                default: duritateMaterial += 0; break;
            }
        }
        grad = ( m.podea.getDuritate() + duritateMaterial)/100 ;
        return grad;
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "denumire='" + denumire + '\'' +
                ", suprafata=" + suprafata +
                ", nrIntrari=" + nrIntrari +
                ", podea=" + podea +
                ", decoratiuni=" + decoratiuni +
                '}';
    }

    public static class MagazinBuilder implements IBuilder{
        private String denumire;
        private float suprafata;
        private int nrIntrari;
        private Podea podea;
        private List<Decoratiune> decoratiuni;

        //zona obligatorie
        public MagazinBuilder(String denumire, float suprafata, int nrIntrari) {
            this.denumire = denumire;
            this.suprafata = suprafata;
            this.nrIntrari = nrIntrari;
        }



        public MagazinBuilder setPodea(Podea podea) {
            this.podea = podea;
            return this;
        }

        public MagazinBuilder addDecoratiune(Decoratiune decoratiune) {
            if(this.decoratiuni == null) {
                this.decoratiuni=new ArrayList<>();
            }
            if(podea.getDuritate() < 2 && decoratiune.getMaterial() == STICLA ) {
                throw new MallExceptie("Podeaua nu este destul de dura pentru a adauga o decoratiune de tip sticla!");
            }
            this.decoratiuni.add(decoratiune);
            return this;
        }

        @Override
        public Magazin build() {
           int minimIntrari = (int) Math.ceil(suprafata/100);
            if(nrIntrari < minimIntrari) {
                throw new MallExceptie("Trebuie minim " + minimIntrari +" intrari pentru " + suprafata + " mp!");
            }

            if(this.podea==null){
                this.podea=new Podea("podea standard", 1.25);
            }

            Magazin rezultat = new Magazin(denumire,suprafata,nrIntrari,podea,decoratiuni);
            this.podea=null;
            this.decoratiuni=null;
            return rezultat;
        }
    }
}
