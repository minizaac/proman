package br.ufmt.proman.equipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EquipeResponse {
    private int idEquipe;
    private String nomeEquipe;
    private String descricaoEquipe;

    public static EquipeResponse from(Equipe entidade){
        EquipeResponse response = new EquipeResponse();
        response.setIdEquipe(entidade.getIdEquipe());
        response.setNomeEquipe(entidade.getNomeEquipe());
        response.setDescricaoEquipe(entidade.getDescricaoEquipe());
        return response;
    }
}

