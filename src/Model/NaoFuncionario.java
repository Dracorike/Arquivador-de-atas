package Model;

public class NaoFuncionario {
    private String nome;
    private String email;
    private String empresa;

    public NaoFuncionario(String nome, String email, String empresa){
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
