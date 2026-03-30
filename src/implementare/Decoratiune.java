package implementare;

public class Decoratiune {
    private MaterialDecorativ material;
    private String denumire;

    public Decoratiune(MaterialDecorativ material, String denumire) {
        this.material = material;
        this.denumire = denumire;
    }

    public MaterialDecorativ getMaterial() {
        return material;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public String toString() {
        return "Decoratiune{" +
                "material=" + material +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}
