package assessment.oo;

import java.util.ArrayList;

public class Aeronave {
    protected String prefixo, modelo, fabricante;

    public Aeronave(String prefixo, String modelo, String fabricante) {
        this.prefixo = prefixo;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }
    
    public Aeronave() {
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    @Override
    public String toString() {
        return prefixo;
    }
    
    public void incluirListaAeronaves(ArrayList<Aeronave> aeronaves, Aeronave a) {
        aeronaves.add(new Aeronave(a.prefixo, a.modelo, a.fabricante));
    }
}
