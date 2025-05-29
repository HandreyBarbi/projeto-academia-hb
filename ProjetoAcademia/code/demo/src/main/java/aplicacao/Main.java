package aplicacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dao.AlunoDAO;
import dao.TreinoDAO;
import model.Aluno;
import model.Treino;
import util.Conexao;

public class Main {

    /*
     * Esse ponto vocês começam a desenvolver o código de vocês.
     * Façam os métodos dentro da classe Main, que serão chamados para fazer o menu inicial, tela de alunos e tela de treinos.
     * Vocês podem criar outros métodos para organizar o código, mas não esqueçam de manter a lógica dentro da classe Main.
     * ASS: Gustavo
     */

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // Gustavo
        try (Connection connection = Conexao.createConnection()) {
            if (connection == null) {
                System.err.println("!!! Não foi possível conectar ao banco de dados !!!");
                return;
            }
            menuInicial(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Em baixo vocês começam a fazer os métodos para cada setor da CLI
     * Vai ser separado cada menu como um médoto diferente
     */

    public static void menuInicial(Connection connection) { // Handrey
        int choose;
        do {
            System.out.println(" |--------------------|");
            System.out.println(" |-- Menu Principal --|");
            System.out.println(" |--------------------|");
            System.out.println("Escolha uma das opções:");
            System.out.println(" [1] Alunos");
            System.out.println(" [2] Treinos");
            System.out.println(" [3] Sair");
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    menuAluno(connection);
                    break;
                case 2:
                    menuTreino(connection);
                    break;
                case 3:
                    System.out.println(">> Saindo...");
                    break;
                default:
                    System.out.println(">> Opção inválida!");
            }
        } while (choose != 3);
    }

    public static void menuAluno(Connection connection) { // Murilo
        /*
         *  Handrey -> Cadastrar um novo aluno (nome, CPF, data de nascimento, telefone, e-mail)
            Handrey -> Listar todos os alunos cadastrados.
            Handrey -> Editar informações de um aluno existente.
            Handrey --> Excluir um aluno do sistema.
            Handrey --> Buscar aluno por nome ou CPF.
            (Essa parte foi passada diretamente do Whatsapp e por isso sumiu os * das linhas)
         */
        int choose;
            System.out.println(" ---------------------");
            System.out.println(" ---- Menu Alunos ----");
            System.out.println(" ---------------------");
            System.out.println("Escolha uma das opções:");
            System.out.println(" [1] Cadastrar novo aluno");
            System.out.println(" [2] Listar alunos cadastrados");
            System.out.println(" [3] Editar informações de aluno");
            System.out.println(" [4] Excluir alunos");
            System.out.println(" [5] Buscar aluno");
            System.out.println(" [6] Voltar");
            choose = scanner.nextInt();
            scanner.nextLine();

            // Ao que aparenta terminado essa parte . Vou checar de novo quarta feira
            switch (choose) {
                case 1: // Cadastro
                    cadastrarAluno(connection);
                    break;
                case 2: // Listar
                    listarAluno(connection);
                    break;
                case 3: // Atualizar/editar
                    editarAluno(connection);
                    break;
                case 4: // Exluir
                    excluirAluno(connection); // Gustavo: Puxa pro método de excluir alunos que é implementado junto da DAO
                    break;
                case 5: // Buscar
                    buscarAluno(connection); // Eu (Gustavo) não tenho ideia de como isso funciona. Se alguém souber me explica
                    break; // Pra facilitar na funcionalidade eu decidi separar em duas partes. Provavelmente tem como simplificar
                case 6: // Voltar pro menu principal
                    System.out.println(">> Voltando ao menu principal...");
                    menuInicial(connection); // Eu não consegui entender ainda como funciona esse connection direito, tô fazendo o que o tutorial fala
                    break;
                default:
                    System.out.println(">> Digitou errado?");
            }
    }

    public static void menuTreino(Connection connection) { //Josy
        int choose;

        /*Cadastrar um treino para um aluno (tipo de treino, descrição, duração, data de início).
        Listar todos os treinos de um aluno específico.
        Editar informações de um treino.
        Excluir um treino.
         * Método para cadastrar um novo aluno.
         * Solicita os dados do aluno e insere no banco de dados.
         * (Mesma coisa do outro, os * foram pro caralho.)
         */
        do {
            System.out.println(" |---------------------|");
            System.out.println(" |------ Treinos ------|");
            System.out.println(" |---------------------|");
            System.out.println("Escolha uma das opções:");
            System.out.println(" [1] Cadastrar treino");
            System.out.println(" [2] Listar treinos");
            System.out.println(" [3] Atualizar informações cadastrais");
            System.out.println(" [4] Excluir treino");
            System.out.println(" [5] Voltar");
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    cadastrarTreino(connection);
                    break;
                case 2:
                    listarTreino(connection);
                    break;
                case 3:
                    atualizarTreino(connection);
                    break;
                case 4:
                    excluirTreino(connection);
                    break;
                case 5:
                    System.out.println(">> Voltando ao menu principal...");
                    menuInicial(connection);
                    break;
                default:
                    System.out.println(">> Função não implementada ainda.");
            }
        } while (choose != 5);
    }


    public static void cadastrarAluno(Connection connection) {
        Aluno aluno = criarNovoAluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        try {
            alunoDAO.cadastrar(connection, aluno);
            System.out.println(">> Aluno cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println(">> Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public static void listarAluno(Connection connection) {
    AlunoDAO alunoDAO = new AlunoDAO();
    try {
        var alunos = alunoDAO.listar(connection);
        if (alunos.isEmpty()) {
            System.out.println(">> Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    } catch (SQLException e) {
        System.err.println(">> Erro ao listar alunos: " + e.getMessage());
    }
}

    public static void editarAluno(Connection connection) {
    Scanner scanner = Main.scanner; // Usa o scanner já existente
    AlunoDAO alunoDAO = new AlunoDAO();

    System.out.print(" Digite o ID do aluno que deseja editar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Aluno aluno = new Aluno();
    aluno.setId(id);

    System.out.print(" Novo nome: ");
    aluno.setNome(scanner.nextLine());

    System.out.print(" Novo CPF: ");
    aluno.setCpf(scanner.nextLine());

    System.out.print(" Novo telefone: ");
    aluno.setTelefone(scanner.nextLine());

    System.out.print(" Novo email: ");
    aluno.setEmail(scanner.nextLine());

    System.out.print(" Nova data de nascimento (yyyy-MM-dd): ");
    try {
        String dataStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data = sdf.parse(dataStr);
        // Converte para java.sql.Date antes de setar
        aluno.setDataNascimento(new java.sql.Date(data.getTime()));
    } catch (Exception e) {
        System.err.println(">> Erro ao processar a data de nascimento: " + e.getMessage());
    }

    try {
        alunoDAO.atualizarAluno(connection, aluno);
        System.out.println(">> Aluno atualizado com sucesso!");
    } catch (SQLException e) {
        System.err.println(">> Erro ao atualizar aluno: " + e.getMessage());
    }
}

public static void excluirAluno(Connection connection) {
    System.out.print(" Digite o ID do aluno que deseja excluir: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    AlunoDAO alunoDAO = new AlunoDAO();
    Aluno aluno = new Aluno();
    aluno.setId(id);

    try {
        alunoDAO.excluirAluno(connection, aluno);
        System.out.println(">> Aluno excluído com sucesso!");
    } catch (SQLException e) {
        System.err.println(">> Erro ao excluir aluno: " + e.getMessage());
    }
}


    public static Aluno criarNovoAluno() {
        Aluno aluno = new Aluno();

        System.out.print(" Nome: ");
        aluno.setNome(scanner.nextLine());

        System.out.print(" CPF: ");
        aluno.setCpf(scanner.nextLine());

        System.out.print(" Telefone: ");
        aluno.setTelefone(scanner.nextLine());

        System.out.print(" Email: ");
        aluno.setEmail(scanner.nextLine());

        System.out.print(" Data de nascimento (yyyy-MM-dd): ");
        try {
            String dataStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date data = sdf.parse(dataStr);
            aluno.setDataNascimento(new java.sql.Date(data.getTime()));
        } catch (Exception e) {
            System.err.println(">> Erro ao processar a data de nascimento: " + e.getMessage());
        }
        return aluno;
    }


    public static void cadastrarTreino(Connection connection) {
        Treino treino = new Treino();
        System.out.print(" ID do Aluno: ");
        treino.setIdAluno(Integer.parseInt(scanner.nextLine()));
        System.out.print(" Tipo de treino: ");
        treino.setTipoTreino(scanner.nextLine());
        System.out.print(" Descrição: ");
        treino.setDescricao(scanner.nextLine());
        System.out.print(" Duração em minutos: ");
        treino.setDuracaoMinutos(Integer.parseInt(scanner.nextLine()));
        System.out.print(" Data de início (yyyy-MM-dd): ");
        try {
            String dataStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date data = sdf.parse(dataStr);
            treino.setDataInicio(new Date(data.getTime()));
        } catch (Exception e) {
            System.err.println(">> Erro ao processar a data de início: " + e.getMessage());
        }

        try {
            TreinoDAO treinoDAO = new TreinoDAO(connection);
            treinoDAO.inserir(treino);
            System.out.println(">> Treino cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println(">> Erro ao cadastrar treino: " + e.getMessage());
        }
    }
    //excluir treino
    public static void excluirTreino(Connection connection) {
    System.out.print(" Digite o ID do treino que deseja excluir: ");
    int idtreino = scanner.nextInt();
    scanner.nextLine();

    TreinoDAO treinoDAO = new TreinoDAO(connection);
    Treino treino = new Treino();
    treino.setIdTreino(idtreino);

    try{
        treinoDAO.deletar(idtreino); 
        System.out.println(">> Treino excluído com sucesso!");
    }catch (Exception e) {
        e.printStackTrace();
        System.err.println(">> Erro ao excluir treino: " + e.getMessage());
    }
}
//listar treino (feito por Handrey)
    public static void listarTreino(Connection connection) {
    TreinoDAO treinoDAO = new TreinoDAO(connection);
    try {
        List<Treino> treinos = treinoDAO.listarTodos();
        if (treinos.isEmpty()) {
            System.out.println(" Nenhum treino cadastrado.");
        } else {
            for (Treino treino : treinos) {
                System.out.println(treino);
            }
        }
    } catch (SQLException e) {
        System.err.println(">> Erro ao listar treinos: " + e.getMessage());
    }
}
//fim listar treino (feito por Handrey) opção 2

//atualizar infos cadastrais (feito por Handrey) opção 3
public static void atualizarTreino(Connection connection) {
    Treino treino = new Treino();
    System.out.print(" Digite o ID do treino que deseja atualizar: ");
    treino.setIdTreino(scanner.nextInt());
    scanner.nextLine();

    System.out.print(" Novo ID do aluno: ");
    treino.setIdAluno(scanner.nextInt());
    scanner.nextLine();

    System.out.print(" Novo tipo de treino: ");
    treino.setTipoTreino(scanner.nextLine());

    System.out.print(" Nova descrição: ");
    treino.setDescricao(scanner.nextLine());

    System.out.print(" Nova duração em minutos: ");
    treino.setDuracaoMinutos(scanner.nextInt());
    scanner.nextLine();

    System.out.print(" Nova data de início (yyyy-MM-dd): ");
    try {
        String dataStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data = sdf.parse(dataStr);
        treino.setDataInicio(new java.sql.Date(data.getTime()));
    } catch (Exception e) {
        System.err.println(">> Erro ao processar a data de início: " + e.getMessage());
    }

    try {
        TreinoDAO dao = new TreinoDAO(connection);
        dao.atualizar(treino);
        System.out.println(">> Treino atualizado com sucesso!");
    } catch (SQLException e) {
        System.err.println(">> Erro ao atualizar treino: " + e.getMessage());
    }
}
//fim atualizar infos cadastrais (feito por Handrey)

    public static void buscarAluno(Connection connection) {
    AlunoDAO alunoDAO = new AlunoDAO();
    System.out.println("Buscar por:");
    System.out.println(" [1] ID");
    System.out.println(" [2] Nome");
    int opcao = scanner.nextInt();
    scanner.nextLine();

    try {
        if (opcao == 1) {
            System.out.print("Digite o ID do aluno: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Aluno aluno = alunoDAO.buscarPorId(connection, id);
            if (aluno != null) {
                System.out.println(aluno);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else if (opcao == 2) {
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();
            var alunos = alunoDAO.buscarPorNome(connection, nome);
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno encontrado com esse nome.");
            } else {
                for (Aluno aluno : alunos) {
                    System.out.println(aluno);
                }
            }
        } else {
            System.out.println("Opção inválida.");
        }
    } catch (Exception e) {
        System.err.println("Erro ao buscar aluno: " + e.getMessage());
    }
}
}
