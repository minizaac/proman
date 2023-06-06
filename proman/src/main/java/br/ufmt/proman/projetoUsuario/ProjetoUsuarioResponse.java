package br.ufmt.proman.projetoUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjetoUsuarioResponse {
    private int idProjetousuario;
    private String relatorioProjetoUsuario;

    public static ProjetoUsuarioResponse from(ProjetoUsuario entidade){
        ProjetoUsuarioResponse response = new ProjetoUsuarioResponse();
        response.setIdProjetousuario(entidade.getIdProjetousuario());
        response.setRelatorioProjetoUsuario(entidade.getRelatorioProjetoUsuario());
        return response;
    }
}
