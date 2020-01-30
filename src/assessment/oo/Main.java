package assessment.oo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        ArrayList<Cidade> cidades = new ArrayList<>();
        ArrayList<Voo> voos = new ArrayList<>();
        ArrayList<Aeronave> aeronaves = new ArrayList<>();
        
        Aeronave a = new Aeronave();
        Aeronave a1 = new Aviao("AVIANCA", 60, "AV-0" , "BOING", "Casas Pedro");
        Aeronave a2 = new Aviao("GOL", 80, "GL-65" , "NICARAGUA", "Casas bahia");
        Aeronave a3 = new Helicoptero("Táxi aéreo", "TX-85", "minhoca", "Magazine luiza");
        
        a.incluirListaAeronaves(aeronaves, a1);
        a.incluirListaAeronaves(aeronaves, a2);
        a.incluirListaAeronaves(aeronaves, a3);
        
        Cidade c = new Cidade();
        Cidade c1 = new Cidade("Rio de Janeiro", 1255);
        Cidade c2 = new Cidade("São Paulo", 1521);
        Cidade c3 = new Cidade("Amazonas", 11401);
        Cidade c4 = new Cidade("Palmas", 2219);
        Cidade c5 = new Cidade("Tampa", 453.8);
        
        c.incluirListaCidade(cidades, c1);
        c.incluirListaCidade(cidades, c2);
        c.incluirListaCidade(cidades, c3);
        c.incluirListaCidade(cidades, c4);
        c.incluirListaCidade(cidades, c5);
        
        Aeroporto ae = new Aeroporto();
        Aeroporto ae1 = new Aeroporto("Galeão", "GIG", "Internacional", c1);
        Aeroporto ae2 = new Aeroporto("Santos Dumont", "SDU", "Nacional", c1);
        Aeroporto ae3 = new Aeroporto("Congonhas", "CGH", "Internacional", c2);
        
        ae.incluirListaAeroportos(aeroportos, ae1);
        ae.incluirListaAeroportos(aeroportos, ae2);
        ae.incluirListaAeroportos(aeroportos, ae3);
        
        Voo v = new Voo();
        Voo v1 = new Voo(123, 70, "25/05/19", "13:30", "14:50", a1, ae1, ae2);
        Voo v2 = new Voo(321, 90, "26/05/19", "17:30", "18:50", a2, ae1, ae2);
        Voo v3 = new Voo(456, 98, "25/05/19", "17:30", "18:50", a3, ae1, ae3);
        
        v.incluirListaVoos(voos, v1);
        v.incluirListaVoos(voos, v2);
        v.incluirListaVoos(voos, v3);
        
        c1.adicionarCidadesFronteira(c2);
        c1.adicionarCidadesFronteira(c3);
        c1.adicionarCidadesFronteira(c4);
        c1.adicionarCidadesFronteira(c5);
        
        c2.adicionarCidadesFronteira(c1);
        c2.adicionarCidadesFronteira(c3);
        c2.adicionarCidadesFronteira(c4);
        c2.adicionarCidadesFronteira(c5);
        
        c3.adicionarCidadesFronteira(c1);
        c3.adicionarCidadesFronteira(c2);
        c3.adicionarCidadesFronteira(c5);
        
        c4.adicionarCidadesFronteira(c1);
        c4.adicionarCidadesFronteira(c5);
        
        c5.adicionarCidadesFronteira(c2);
        
        c2.vizinhoComum(c3);
        c1.vizinhoComum(c2);
        
        //CHEGADA
        ae1.incluirAeroportoChegada(ae3);
        
        ae2.incluirAeroportoChegada(ae3);
        
        ae3.incluirAeroportoChegada(ae2);
        
        //PARTIDA
        ae1.incluirAeroportoPartida(ae3);
        
        ae2.incluirAeroportoPartida(ae1);
        
        ae3.incluirAeroportoPartida(ae2);
        
        ae1.patioAeroporto(a1);
        ae1.patioAeroporto(a2);
        ae2.patioAeroporto(a3);
        ae1.aeC();
        System.out.println(ae1.getCodigoAeroporto().equals(ae1.getCodigoAeroporto()));
        System.out.println(ae1.aeronavePousada("AV-0"));
        System.out.println(ae1.aeronavePousada("GL-65"));
        System.out.println(ae2.aeronavePousada("TX-85"));
        System.out.println("");
        System.out.println(ae2.possuiRota(ae1));
        System.out.println("");
        ae.consulta(voos, c1, c1);
        
        System.out.println("");
        ae.consulta(voos, c1, c2);
        
        System.out.println("");
        v.verificarVagasDisponiveis(voos, aeronaves, v1);
        v.listar(voos, 123);
        System.out.println("");
        v.verificarVagasDisponiveis(voos, aeronaves, v2);
        v.listar(voos, 321);
        System.out.println("");
        v.alterar(voos, 123, 20, "13/09/15", "15:45", "18:80", a2, ae1, ae3);
        v.verificarVagasDisponiveis(voos, aeronaves, v1);
        v.listar(voos, 123);
        System.out.println("");
        v.excluir(voos, 123);
        v.listar(voos, 123);
        
        System.out.println(ae1. nomeAeroporto("GIG"));
        System.out.println("");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
