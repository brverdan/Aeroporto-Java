package assessment.oo;

import java.util.ArrayList;

public class Voo {
    private int numVoo, numVagas, numVagasDisponiveis;
    private String dataPartida, horaPartida, horaChegada; 
    private Aeronave aeronave;
    private Aeroporto aeroporto1, aeroporto2;

    public Voo(int numVoo, int numVagas, String dataPartida, String horaPartida, String horaChegada, Aeronave aeronave, Aeroporto aeroporto1, Aeroporto aeroporto2) {
        this.numVoo = numVoo;
        this.numVagas = numVagas;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.aeronave = aeronave;
        this.aeroporto1 = aeroporto1;
        this.aeroporto2 = aeroporto2;
    }
    
    public Voo() {
    }

    public int getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(int numVoo) {
        this.numVoo = numVoo;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Aeroporto getAeroporto1() {
        return aeroporto1;
    }

    public void setAeroporto1(Aeroporto aeroporto1) {
        this.aeroporto1 = aeroporto1;
    }

    public Aeroporto getAeroporto2() {
        return aeroporto2;
    }

    public void setAeroporto2(Aeroporto aeroporto2) {
        this.aeroporto2 = aeroporto2;
    }
    
    @Override
    public String toString() {
        return ("Número voo: " + numVoo + "\n Número vagas disponíveis: " + numVagas + "\n Data de partida: " +  dataPartida + "\n Hora de partida: " +
                horaPartida+ "\n Hora de chegada: " + horaChegada + "\n Aeronave: " + aeronave
                + "\n Aeroporto de partida: " + aeroporto1 + "\n Aeroporto de chegada: " + aeroporto2);
    }
    
    public void incluirListaVoos(ArrayList<Voo> voos, Voo v) {
        if (voos.isEmpty()) {
            voos.add(new Voo(v.numVoo, v.numVagas, v.dataPartida, v.horaPartida, v.horaChegada, v.aeronave, v.aeroporto1, v.aeroporto2));
            return;
        }
        if (v.aeronave.getClass() == Aviao.class) {
            for (int i = 0; i < voos.size(); i++) {
                if (v.dataPartida.equals(voos.get(i).getDataPartida())) {
                    System.out.println("Erro: Voo de avião no mesmo dia!");
                    return;
                }
            }
            voos.add(new Voo(v.numVoo, v.numVagas, v.dataPartida, v.horaPartida, v.horaChegada, v.aeronave, v.aeroporto1, v.aeroporto2));
        }
        else {
            voos.add(new Voo(v.numVoo, v.numVagas, v.dataPartida, v.horaPartida, v.horaChegada, v.aeronave, v.aeroporto1, v.aeroporto2));
        }
    }
    
    public void excluir(ArrayList<Voo> voos, int numVoo) {

        if (voos.isEmpty()) {
            System.out.println("Não existe voos!");
            return;
        }    
        int pos = pesquisaVoo(voos, numVoo);
        if (pos == -1) {
            System.out.println("Não existe voos!");
            return;
        }
        voos.remove(pos);
    }
    
    public void alterar(ArrayList<Voo> voos, int numVoo, int numVagas, String dataPartida, String horaPartida, String horaChegada, Aeronave aeronave, Aeroporto aeroporto1, Aeroporto aeroporto2) {
        
        if (voos.isEmpty()) {
            System.out.println("Não existe voos!");
            return;
        }  
        int pos = pesquisaVoo(voos, numVoo);
        if (pos == -1) {
            System.out.println("Erro: Voo não encontrado");
            return;
        }
        voos.get(pos).setNumVagas(numVagas);
        voos.get(pos).setDataPartida(dataPartida);
        voos.get(pos).setHoraChegada(horaChegada);
        voos.get(pos).setHoraPartida(horaPartida);
        voos.get(pos).setAeronave(aeronave);
        voos.get(pos).setAeroporto1(aeroporto1);
        voos.get(pos).setAeroporto2(aeroporto2);
    }
    
    public void verificarVagasDisponiveis(ArrayList<Voo> voos, ArrayList<Aeronave> aeronaves, Voo v) {
        Aviao a = (Aviao) v.aeronave;
        
        if (voos.isEmpty()) {
            System.out.println("Não existe voos!");
            return;
        }
        for (int i = 0; i < aeronaves.size(); i++) {
            if (aeronaves.get(i).getPrefixo().equals(v.aeronave.getPrefixo())) {
                if (v.aeronave.getClass() == Aviao.class) {
                    v.numVagas = v.numVagas - a.getNumAssentos();
                    voos.get(i).setNumVagas(v.numVagas);
                    if (v.numVagas < 0) {
                        System.out.println("Erro: Excedeu o número de vagas!");
                        return;
                    }
                }
            }
        }
    }
    
    public void listar(ArrayList<Voo> voos, int numVoo) {
        int pos = -1;
        
        if (voos.isEmpty()) {
            System.out.println("Não existe voos!");
            return;
        }
        pos = pesquisaVoo(voos , numVoo);
        if ((pos != -1) && (voos.get(pos).numVagas > 0)) {
            System.out.println(voos.get(pos).toString());
        }
    }
    
    public int pesquisaVoo(ArrayList<Voo> voos, int numVoo) {
        int pos = -1;
        
        for (int i = 0; i < voos.size(); i++) {
            if (voos.get(i).getNumVoo() == numVoo){
                pos = i;
                break;
            }
        }
        return pos;
    }
}
