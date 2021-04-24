package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Atas {
    private int _id;
    private boolean publica;
    private String nomeReuniao;
    private LocalDate dataEmissao;
    private LocalDateTime inicioReuniao;
    private LocalDateTime terminoReuniao;
    private String pauta;
    private String setorOrg;
    private boolean revisao;
    private String[] palavrasChave;
    private List<Funcionario> participantesFuncionario = new ArrayList<>();
    private List<NaoFuncionario> participantesNaoFuncionario = new ArrayList<>();

    public Atas(){

    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }
    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public List<Funcionario> getParticipantesFuncionario() {
        return participantesFuncionario;
    }
    public void setParticipantesFuncionario(List<Funcionario> participantesFuncionario) {
        this.participantesFuncionario = participantesFuncionario;
    }

    public List<NaoFuncionario> getParticipantesNaoFuncionario() {
        return participantesNaoFuncionario;
    }
    public void setParticipantesNaoFuncionario(List<NaoFuncionario> participantesNaoFuncionario) {
        this.participantesNaoFuncionario = participantesNaoFuncionario;
    }

    public boolean isPublica() {
        return publica;
    }
    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public boolean isRevisao() {
        return revisao;
    }
    public void setRevisao(boolean revisao) {
        this.revisao = revisao;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }
    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDateTime getInicioReuniao() {
        return inicioReuniao;
    }
    public void setInicioReuniao(LocalDateTime inicioReuniao) {
        this.inicioReuniao = inicioReuniao;
    }

    public LocalDateTime getTerminoReuniao() {
        return terminoReuniao;
    }
    public void setTerminoReuniao(LocalDateTime terminoReuniao) {
        this.terminoReuniao = terminoReuniao;
    }

    public String getPauta() {
        return pauta;
    }
    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getSetorOrg() {
        return setorOrg;
    }
    public void setSetorOrg(String setorOrg) {
        this.setorOrg = setorOrg;
    }

    public String getNomeReuniao() {
        return nomeReuniao;
    }
    public void setNomeReuniao(String nomeReuniao) {
        this.nomeReuniao = nomeReuniao;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String inicioReuniao(){
        LocalDateTime inicio = this.inicioReuniao;
        return inicio.getDayOfMonth() + "/" + inicio.getMonthValue()
        + "/" + inicio.getYear() + " - " + inicio.getHour() + ":" + inicio.getMinute();
    }

    public String fimReuniao(){
        LocalDateTime fim = this.terminoReuniao;
        return fim.getDayOfMonth() + "/" + fim.getMonthValue()
                + "/" + fim.getYear() + " - " + fim.getHour() + ":" + fim.getMinute();
    }

    public String palavrasChaves(){
        String[] palavras = new String[5];
        palavras = this.palavrasChave;
        return palavras[0] + "\n" + palavras[1] + "\n" + palavras[2] + "\n" +
                palavras[3] + "\n" + palavras[4];
    }

    public void participantes(){
        System.out.println("Funcionarios:");
        for (Funcionario funcionario: participantesFuncionario){
            System.out.println(funcionario.getNomeFuncionario());
        }
        System.out.println();
        System.out.println("Não funcionarios: ");
        for(NaoFuncionario naoFuncionario: participantesNaoFuncionario){
            System.out.println(naoFuncionario.getNome());
        }
        System.out.println();
    }

    public String dataEmissao(){
        LocalDate data = this.dataEmissao;
        return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
    }
}
