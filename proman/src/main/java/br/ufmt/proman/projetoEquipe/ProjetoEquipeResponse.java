package br.ufmt.proman.projetoEquipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjetoEquipeResponse {
    private int idProjetoEquipe;
    private String relatorioProjetoEquipe;

    public static ProjetoEquipeResponse from(ProjetoEquipe entidade){
        ProjetoEquipeResponse response = new ProjetoEquipeResponse();
        response.setIdProjetoEquipe(entidade.getIdProjetoEquipe());
        response.setRelatorioProjetoEquipe(entidade.getRelatorioProjetoEquipe());
        return response;
    }
}
