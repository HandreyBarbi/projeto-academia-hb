package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {

    // 1. Campos de aluno o
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String email;

    public Aluno() {}
    public Aluno(String nome, String cpf, Date dataNascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }
    //Construtor
    public Aluno(Integer id, String nome, String cpf, Date dataNascimento, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }
    // Geters e Setters (clica luzinha)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (dataNascimento != null) ? sdf.format(dataNascimento) : "N/A";

        return String.format(
            "\n Aluno ID: %d\n" +
            "   Nome: %s\n" +
            "   CPF: %s\n" +
            "   Nascimento: %s\n" +
            "   Telefone: %s\n" +
            "   Email: %s\n",
            id, nome, cpf, dataFormatada, telefone, email
        );
    }
}