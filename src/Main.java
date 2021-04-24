import Dados.BD_Atas;
import Dados.BD_FuncionariosCadastrados;
import Model.Atas;
import Model.Funcionario;
import Model.NaoFuncionario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BD_FuncionariosCadastrados bancoFuncionarios = new BD_FuncionariosCadastrados();
        BD_Atas bancoAtas = new BD_Atas();
        Scanner teclado = new Scanner(System.in);
        System.out.println("-------------------- Arquivador de atas --------------------");


        boolean loop = true;
        while (loop) {
            menu();
                int escolha = teclado.nextInt();
                teclado.nextLine();

            switch (escolha) {
                case 0:
                    System.out.println("Saindo...");
                    loop = false;
                    break;
                case 1:
                    System.out.println("Cadastrar Funcionário");

                    System.out.print("Nome: ");
                    String nomeFun = teclado.nextLine();

                    System.out.print("CPF: ");
                    String cpfFun = teclado.next();

                    System.out.print("Cargo: ");
                    String cargoFun = teclado.next();

                    bancoFuncionarios.create(cadastrarFuncionario(bancoFuncionarios.getId(),
                            nomeFun, cpfFun, cargoFun));
                    System.out.println("Funcionário cadastrado!");
                    break;
                case 2:
                    System.out.println("Funcionários");
                    bancoFuncionarios.read();
                    break;
                case 3:
                    System.out.println("Atas");
                    bancoAtas.detalhes();
                    break;
                case 4:
                    System.out.println("Iniciar Nova reunião");
                    System.out.print("Quantos membros terá nesta reunião? ");
                    int membroReun = teclado.nextInt();
                    teclado.nextLine();

                    if(membroReun < 2){
                        System.out.println("A reunião só poderá ser feita com mais de uma pessoa.");
                        break;
                    }
                    String nomeMembros[] = new String[membroReun];

                    Atas nova = new Atas();

                    for(int i = 0; i < membroReun; i++){
                        System.out.print("Nome do membro: ");
                        nomeMembros[i] = teclado.nextLine();
                    }
                    String membroNaoFun[] = membrosNaoFuncionarios(bancoFuncionarios, nomeMembros);
                        if (membroNaoFun.length > 0) {
                            System.out.println("Cadastrar membros não funcionários");
                            for (int i = 0; i < membroNaoFun.length; i++) {
                                System.out.println("Nome: " + membroNaoFun[i]);
                                System.out.print("Email: ");
                                String email = teclado.nextLine();
                                System.out.print("Empresa: ");
                                String empresa = teclado.nextLine();
                                NaoFuncionario naoFuncionario = new NaoFuncionario(membroNaoFun[i],
                                        email, empresa);
                                nova.getParticipantesNaoFuncionario().add(naoFuncionario);
                            }
                        }
                        for (int i = 0; i < nomeMembros.length; i++){
                            if(bancoFuncionarios.exists(nomeMembros[i])){
                                nova.getParticipantesFuncionario()
                                        .add(bancoFuncionarios.searchByName(nomeMembros[i]));
                            }
                        }



                    System.out.print("Título da Reunião: ");
                    String tituloReun = teclado.nextLine();
                    nova.setNomeReuniao(tituloReun);

                    System.out.print("Setor: ");
                    String setorReun = teclado.nextLine();
                    nova.setSetorOrg(setorReun);

                    System.out.println("Inicio da Reunião:");
                    System.out.print("Dia[aaaa-mm-dd]: ");
                    String dataInicio = teclado.nextLine();
                    System.out.print("Hora[hora:minuto]: ");
                    String horaInicio = teclado.nextLine();
                    LocalDateTime inicio = inicioReuniao(dataInicio, horaInicio);
                    nova.setInicioReuniao(inicio);

                    System.out.println("---------------- Pauta ----------------");
                    String pauta = teclado.nextLine();
                    nova.setPauta(pauta);

                    System.out.println("Digite 5 palavras chaves");
                    String[] palavrasChaves = new String[5];
                    for(int i = 0; i < palavrasChaves.length; i++){
                        System.out.print("Palavra [" + (i+1) + "]: ");
                        palavrasChaves[i] = teclado.next();
                    }
                    nova.setPalavrasChave(palavrasChaves);

                    teclado.nextLine();
                    System.out.println("Termino da Reunião");
                    System.out.print("Dia[aaaa-mm-dd]: ");
                    String dataFim = teclado.nextLine();
                    System.out.print("Hora[hora:minuto]: ");
                    String horaFim = teclado.nextLine();
                    LocalDateTime fim = inicioReuniao(dataFim, horaFim);
                    nova.setTerminoReuniao(fim);

                    System.out.print("Data de Emissão[aaaa-mm-dd]: ");
                    String emissao = teclado.next();
                    LocalDate dataEmissao = LocalDate.parse(emissao);
                    nova.setDataEmissao(dataEmissao);

                    System.out.print("Deseja que essa ata seja privada?[S/N]");
                    String privar = teclado.next();
                    if(privar.toLowerCase().equals("s")){
                        System.out.println("Ata Privada");
                        nova.setPublica(false);
                    }else{
                        System.out.println("Ata Publica");
                        nova.setPublica(true);
                    }

                    nova.setRevisao(true);

                    bancoAtas.create(nova);

                    System.out.println("Reunião concluída.");
                    break;
                case 5:
                    bancoAtas.revisoesPendentes();
                    break;

            }
        }
    }

    public static void menu(){
        System.out.println("" +
                "Escolha sua operação: \n" +
                "[0] sair do programa. \n" +
                "[1] Cadastrar Funcionário. \n" +
                "[2] Visualizar Funcionários. \n" +
                "[3] Visualizar Atas. \n" +
                "[4] Começar nova reunião. \n" +
                "[5] Revisões pendentes. \n");
        System.out.print("Opção: ");
    }

    public static Funcionario cadastrarFuncionario(int _id, String nome, String cpf, String cargo){
        Funcionario novo = new Funcionario();
        novo.set_id(_id);
        novo.setNomeFuncionario(nome);
        novo.setCPF(cpf);
        novo.setFuncao(cargo);
        return novo;
    }

    public static LocalDateTime inicioReuniao(String dataInicio, String horaInicio){
        LocalDateTime inicio = LocalDateTime.parse(dataInicio + "T" + horaInicio + ":00");
        return inicio;
    }

    public static String[] membrosNaoFuncionarios(BD_FuncionariosCadastrados banco, String[] membros){
        int contador = 0;
        for(int i = 0; i < membros.length; i++){
            if(!banco.exists(membros[i])){
                contador++;
            }
        }

        String[] naoFuncionario = new String[contador];
        contador = 0;

        for(int i = 0; i < membros.length; i++){
            if(!banco.exists(membros[i])){
                naoFuncionario[contador] = membros[i];
                contador++;
            }
        }
        return naoFuncionario;
    }
}
