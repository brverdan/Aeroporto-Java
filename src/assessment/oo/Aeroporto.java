package assessment.oo;

import java.util.ArrayList;

public class Aeroporto {
    ArrayList<Aeronave> aeronavesPousadas = new ArrayList<>();
    ArrayList<Aeroporto> aeroportoPartida = new ArrayList<>();
    ArrayList<Aeroporto> aeroportoChegada = new ArrayList<>();
    ArrayList<Voo> voo = new ArrayList<>();
    private final int LIMITE = 100;
    private String nomeAeroporto, codigoAeroporto, classificacaoAeroporto;
    private Cidade nomeCidade;
    
    public Aeroporto(String nomeAeroporto, String codigoAeroporto, String classificacaoAeroporto, Cidade nomeCidade) {
        this.nomeAeroporto = nomeAeroporto;
        this.codigoAeroporto = codigoAeroporto;
        this.classificacaoAeroporto = classificacaoAeroporto;
        this.nomeCidade = nomeCidade;
    }
    
    public Aeroporto() {
    }

    public String getCodigoAeroporto() {
        return codigoAeroporto;
    }

    public void setCodigoAeroporto(String codigoAeroporto) {
        this.codigoAeroporto = codigoAeroporto;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public Cidade getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(Cidade nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getClassificacaoAeroporto() {
        return classificacaoAeroporto;
    }

    public void setClassificacaoAeroporto(String classificacaoAeroporto) {
        this.classificacaoAeroporto = classificacaoAeroporto;
    }
    
    @Override
    public String toString() {
        return (codigoAeroporto + ": Aeroporto " + classificacaoAeroporto + " " + nomeAeroporto +", " + nomeCidade);
    }
    
    public void incluirListaAeroportos(ArrayList<Aeroporto> aeroportos, Aeroporto ae) {
        aeroportos.add(new Aeroporto(ae.nomeAeroporto, ae.codigoAeroporto, ae.classificacaoAeroporto, ae.nomeCidade));
    }
    
    public void incluirAeroportoChegada(Aeroporto aeroporto) {
        if (aeroportoChegada.size() < LIMITE) {
            aeroportoChegada.add(new Aeroporto(aeroporto.nomeAeroporto, aeroporto.codigoAeroporto, aeroporto.classificacaoAeroporto, aeroporto.nomeCidade));
        }
    }
    
    public void incluirAeroportoPartida(Aeroporto aeroporto) {
        if (aeroportoPartida.size() < LIMITE) {
            aeroportoPartida.add(new Aeroporto(aeroporto.nomeAeroporto, aeroporto.codigoAeroporto, aeroporto.classificacaoAeroporto, aeroporto.nomeCidade));
        }
    }
    
    public void aeC() {
        System.out.println(aeroportoChegada);
    }
    
    public boolean equals(Aeroporto aeroporto) {
        boolean igual = false;
        
        if (codigoAeroporto.equals(aeroporto.codigoAeroporto)) {
            igual = true;
        }
        return igual;
    }
    
    public void patioAeroporto(Aeronave a) {
        if (aeronavesPousadas.size() < 100) {
            aeronavesPousadas.add(new Aeronave(a.prefixo, a.modelo, a.fabricante));
        }
        else {
            System.out.println("Erro: Limite de aeroaves em solo!");
        }
    }
    
    public boolean aeronavePousada(String a) {
        boolean estacionada = false;
        int pos = -1;
        
        for (int i = 0; i < aeronavesPousadas.size(); i++) { 
            if (aeronavesPousadas.get(i).getPrefixo().equals(a)) {
                pos = i;
                estacionada = true;
            }
        }
        return estacionada;
    }
    
    public boolean possuiRota(Aeroporto a) {
        boolean possui = false;
        
        for (int i = 0; i < aeroportoChegada.size(); i++) {
            if (aeroportoChegada.get(i).equals(a)) {
                possui = true;
            }
            else  {
                for (int j = 0; j < a.aeroportoPartida.size(); j++) {
                    if (a.aeroportoPartida.get(j).equals(aeroportoChegada.get(i))) {
                            possui = true;
                    }
                }
            }
        }
        return possui;
    }
    
    public String nomeAeroporto(String codigoAeroporto) {
        if (codigoAeroporto.equals(codigoAeroporto)) {
        }
        return nomeAeroporto;
    }
    
    public void consulta(ArrayList<Voo> voos, Cidade cidadeOrigem, Cidade cidadeDestino) {
        for (int i = 0; i < voos.size(); i++) { 
            if ((voos.get(i).getAeroporto1().getNomeCidade().equals(cidadeOrigem)) && 
               (voos.get(i).getAeroporto2().getNomeCidade().equals(cidadeDestino))) {
                System.out.println("Número do voo: " + voos.get(i).getNumVoo() + " - Data: " + voos.get(i).getDataPartida());
            }
        }
    }
}
