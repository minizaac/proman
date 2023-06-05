package br.ufmt.proman.stakeholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StakeholderResponse {
    private int idStakeholder;
    private String nomeStakeholder;

    public static StakeholderResponse from(Stakeholder entidade){
        StakeholderResponse response = new StakeholderResponse();
        response.setIdStakeholder(entidade.getIdStakeholder());
        response.setNomeStakeholder(entidade.getNomeStakeholder());
        return response;
    }
}
