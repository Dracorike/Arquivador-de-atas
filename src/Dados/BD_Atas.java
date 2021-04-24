package Dados;

import Model.Atas;

import java.util.ArrayList;
import java.util.List;

public class BD_Atas {
    private List<Atas> listaDeAtas = new ArrayList();
    private int size = 0;

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public void create(Atas ata) {
        listaDeAtas.add(ata);
        System.out.println("Ata da reunião: " + ata.getNomeReuniao() + " Adicionado com sucesso!");
        size++;
    }

    public void read(){
        System.out.println("---------------------------------------------------------------------");
        for(int i = 0; i < listaDeAtas.size(); i++){
            System.out.println("Reunião: " + listaDeAtas.get(i).getNomeReuniao());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

    public void update(int _id){

    }

    public void delete(int _id){
        for(int i = 0; i < listaDeAtas.size(); i++){
            if(listaDeAtas.get(i).get_id() == _id){
                listaDeAtas.remove(i);
                break;
            }
        }
        System.out.println("Ata Removida!");
    }

    public void readRevisao(){
        System.out.println("---------------------------------------------------------------------");
        for(int i = 0; i < listaDeAtas.size(); i++){
            if(listaDeAtas.get(i).isRevisao())
                System.out.println("Ainda na revisão: " + listaDeAtas.get(i).getNomeReuniao());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

    public void revisoesPendentes(){
        System.out.println("=============================================");
        for(Atas ata: listaDeAtas){
            if(ata.isRevisao()){
                System.out.println("Ata: " + ata.getNomeReuniao());
            }
        }
        System.out.println("=============================================");
    }

    public void detalhes(){
        System.out.println("-----------------------------------------");
        for(Atas atas: listaDeAtas){
            System.out.println("" +
                    "Título: " + atas.getNomeReuniao() + "\n" +
                    "Setor: " + atas.getSetorOrg() +  "\n" +
                    "Inicio da Reunião: " + atas.inicioReuniao() + "\n" +
                    "Fim da Reunião: " + atas.fimReuniao() + "\n"+
                    " --------------- Pauta --------------- \n" +
                    atas.getPauta() + "\n" +
                    "---------------------------------------- \n" +
                    "-------------- Palavras Chave -------------- \n" +
                    atas.palavrasChaves() + "\n" +
                    "---------------------------------------- "
            );
            System.out.println("============= Participantes =============");
            atas.participantes();
            System.out.println("=========================================");
            System.out.println("Data de Emissão: " + atas.dataEmissao());
        }
        System.out.println("-----------------------------------------");

    }

}
