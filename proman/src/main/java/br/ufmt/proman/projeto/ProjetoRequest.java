package br.ufmt.proman.projeto;

import java.util.Date;

public class ProjetoRequest {

    private String nomeProjeto;
    private String descricaoProjeto;
    private Date dataInicioProjeto;
    private Date dataConclusaoProjeto;
    private String statusProjeto;
    private String faseProjeto;

    public void setNomeProjeto(String nome){
        this.nomeProjeto = nome;
    }

    public String getNomeProjeto(){
        return nomeProjeto;
    }

    public void setDescricaoProjeto(String descricao){
        this.descricaoProjeto = descricao;
    }

    public String getDescricaoProjeto(){
        return descricaoProjeto;
    }

    public void setDataInicioProjeto(Date data){
        this.dataInicioProjeto = data;
    }

    public Date getDataInicioProjeto(){
        return dataInicioProjeto;
    }

    public void setDataConclusaoProjeto(Date data){
        this.dataConclusaoProjeto = data;
    }

    public Date getDataConclusaoProjeto(){
        return dataConclusaoProjeto;
    }


    public void setStatusProjeto(String status){
        this.nomeProjeto = status;
    }

    public String getStatusProjeto(){
        return statusProjeto;
    }

    public void setFaseProjeto(String fase){
        this.faseProjeto = fase;
    }

    public String getFaseProjeto(){
        return faseProjeto;
    }

}
