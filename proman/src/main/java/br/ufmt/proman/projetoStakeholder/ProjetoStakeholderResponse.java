package br.ufmt.proman.projetoStakeholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProjetoStakeholderResponse {
    private int idProjetoStakeholder;
    private String funcaoProjetoStakeholder;
    private String influenciaProjetoStakeholder;
    private String interesseProjetoStakeholder;

    public static ProjetoStakeholderResponse from(ProjetoStakeholder entidade){
        ProjetoStakeholderResponse response = new ProjetoStakeholderResponse();
        response.setIdProjetoStakeholder(entidade.getIdProjetoStakeholder());
        response.setFuncaoProjetoStakeholder(entidade.getFuncaoProjetoStakeholder());
        response.setInfluenciaProjetoStakeholder(entidade.getInfluenciaProjetoStakeholder());
        response.setInteresseProjetoStakeholder(entidade.getInteresseProjetoStakeholder());
        return response;
    }
}
