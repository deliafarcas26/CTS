package implementare;

public class Podea {
    private String tip;
    private double duritate;

    public Podea(String tip, double duritate) {
        this.tip = tip;
        this.duritate = duritate;
    }

    public String getTip() {
        return tip;
    }

    public double getDuritate() {
        return duritate;
    }

    @Override
    public String toString() {
        return "Podea{" +
                "tip='" + tip + '\'' +
                ", duritate=" + duritate +
                '}';
    }
}
