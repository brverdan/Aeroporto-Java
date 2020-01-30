package assessment.oo;

public class Helicoptero extends Aeronave {
    private String tipo;

    public Helicoptero(String tipo, String prefixo, String modelo, String fabricante) {
        super(prefixo, modelo, fabricante);
        this.tipo = tipo;
    }
}
