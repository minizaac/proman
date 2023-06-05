package br.ufmt.proman.equipe;

public class EquipeRequest {
    
    private String nomeEquipe;
    private String descricaoEquipe;

    public void setNomeEquipe(String nome){
        this.nomeEquipe = nome;
    }

    public String getNomeEquipe(){
        return nomeEquipe;
    }

    public void setDescricaoEquipe(String descricao){
        this.descricaoEquipe = descricao;
    }

    public String getDescricaoEquipe(){
        return descricaoEquipe;
    } 
}
