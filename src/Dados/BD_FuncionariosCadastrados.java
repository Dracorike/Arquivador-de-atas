package Dados;

import Model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class BD_FuncionariosCadastrados {
    private List<Funcionario> listaFuncionarios= new ArrayList();
    private int id = 0;

    public void create(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
        id++;
    }

    public void read(){
        System.out.println("---------------------------------------------------------------------");
        for(int i = 0; i < listaFuncionarios.size(); i++){
            System.out.println("Funcionário: " + listaFuncionarios.get(i).getNomeFuncionario());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

    public boolean exists(String nome){
        boolean retorno = false;
        for(Funcionario funcionario: listaFuncionarios){
            if(funcionario.getNomeFuncionario().equals(nome)){
                retorno = true;
                break;
            }
        }

        return retorno;
    }

    public Funcionario searchByName(String nome){
        Funcionario finded = new Funcionario();
        for(Funcionario funcionario: listaFuncionarios){
            if(funcionario.getNomeFuncionario() == nome){
                finded = funcionario;
            }
        }
        return finded;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
