package Model;

public class Funcionario {
    private int _id;
    private String nomeFuncionario;
    private String CPF;
    private String funcao;

    public Funcionario(){

    }

    public Funcionario(int _id, String nome, String cpf, String funcao){
        this._id = _id;
        this.nomeFuncionario = nome;
        this.CPF = cpf;
        this.funcao = funcao;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
