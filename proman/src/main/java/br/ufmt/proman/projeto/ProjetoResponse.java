package br.ufmt.proman.projeto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjetoResponse {
    private int idProjeto;
    private String nomeProjeto;
    private String descricaoProjeto;
    private Date dataInicioProjeto;
    private Date dataConclusaoProjeto;
    private String statusProjeto;
    private String faseProjeto;

    public static ProjetoResponse from(Projeto entidade){
        ProjetoResponse response = new ProjetoResponse();
        response.setIdProjeto(entidade.getIdProjeto());
        response.setNomeProjeto(entidade.getNomeProjeto());
        response.setDescricaoProjeto(entidade.getDescricaoProjeto());
        response.setDataInicioProjeto(entidade.getDataInicioProjeto());
        response.setDataConclusaoProjeto(entidade.getDataConclusaoProjeto());
        response.setStatusProjeto(entidade.getStatusProjeto());
        response.setFaseProjeto(entidade.getFaseProjeto());
        return response;
    }
}
