package model;

import java.sql.Date;

public class Treino {
    private int id;
    private int aluno_id;
    private String tipo_treino;
    private String descricao;
    private int duracao_minutos;
    private Date data_inicio;

    public int getIdTreino() {
        return id;
    }
    public void setIdTreino(int id) {
        this.id = id;
    }
    public int getIdAluno() {
        return aluno_id;
    }
    public void setIdAluno(int idAluno) {
        this.aluno_id = idAluno;
    }
    public String getTipoTreino() {
        return tipo_treino;
    }
    public void setTipoTreino(String tipoTreino) {
        this.tipo_treino = tipoTreino;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getDuracaoMinutos() {
        return duracao_minutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracao_minutos = duracaoMinutos;
    }
    public Date getDataInicio() {
        return data_inicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.data_inicio = dataInicio;
    }
    //AA
@Override
public String toString() {
    return 
           "ID do Treino = " + id +
           "\nID do Aluno = " + aluno_id +
           "\nTipo do Treino = " + tipo_treino +
           "\nDescrição = " + descricao +
           "\nDuração em Minutos = " + duracao_minutos +
           "\nData de Início = " + data_inicio +"\n";
}

}
