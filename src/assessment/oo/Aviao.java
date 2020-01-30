package assessment.oo;

public class Aviao extends Aeronave {
    private String nomeEmpresa;
    private int numAssentos;

    public Aviao(String nomeEmpresa, int numAssentos, String prefixo, String modelo, String fabricante) {
        super(prefixo, modelo, fabricante);
        this.nomeEmpresa = nomeEmpresa;
        this.numAssentos = numAssentos;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }
    
    public void imprimir() {
        System.out.println(nomeEmpresa + numAssentos + prefixo + modelo + fabricante);
    }
}
