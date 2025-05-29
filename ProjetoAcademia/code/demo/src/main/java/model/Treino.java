package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Treino {
    private int idtreino;
    private int aluno_id;
    private String tipo_treino;
    private String descricao;
    private int duracao_minutos;
    private Date data_inicio;

    public int getIdTreino() {
        return idtreino;
    }
    public void setIdTreino(int idtreino) {
        this.idtreino = idtreino;
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
      @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (data_inicio != null) ? sdf.format(data_inicio) : "N/A";

        return String.format(
            "\n Aluno ID: %d\n" +
            "   Aluno ID: %s\n" +
            "   Tipo do Treino: %s\n" +
            "   Descrição: %s\n" +
            "   Duração: %s\n" +
            "   Data de Início: %s\n",
            idtreino, aluno_id, tipo_treino, descricao, duracao_minutos, data_inicio
        );
    }
}
