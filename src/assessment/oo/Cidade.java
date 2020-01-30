package assessment.oo;

import java.util.ArrayList;

public class Cidade {
    ArrayList<Cidade> fronteiraCidade = new ArrayList<>();
    private String nomeCidade;
    private double dimensao;

    public Cidade(String nomeCidade, double dimensao) {
        this.nomeCidade = nomeCidade;
        this.dimensao = dimensao;
    }
    
    public Cidade() {
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }
    
    @Override
    public String toString() {
        return nomeCidade;
    }
    
    public void incluirListaCidade(ArrayList<Cidade> cidades, Cidade c) {
        cidades.add(new Cidade(c.nomeCidade, c.dimensao));
    }
    
    public boolean equals (Cidade outra) {
        boolean pos = false;

        if ((dimensao == outra.dimensao) && (nomeCidade.equals(outra.nomeCidade))) {
            pos = true;
        }
        return pos;
    }
    
    public void adicionarCidadesFronteira(Cidade c) {
        if (fronteiraCidade.size() < 40) {
            fronteiraCidade.add(new Cidade(c.nomeCidade, c.dimensao));
        }
        else {
            System.out.println("Apenas 40 fronteiras");
        }
    }
    
    public boolean Fronteira(Cidade c) {
        boolean fronteira = false;

        for (int i = 0; i < fronteiraCidade.size(); i++) {
            if (fronteiraCidade.get(i).equals(c)) {
                fronteira = true;
            }
        }
        return fronteira;
    }
    
    public void vizinhoComum (Cidade outra) {
        ArrayList<Cidade> vizinho = new ArrayList<>();
        
        for (int i = 0; i < fronteiraCidade.size(); i++) {
            for (int j = 0; j < outra.fronteiraCidade.size(); j++) {
                if (fronteiraCidade.get(i).equals(outra.fronteiraCidade.get(j))) {
                vizinho.add(fronteiraCidade.get(i));
                }
            }   
        }
        System.out.println(vizinho);
    }
}
