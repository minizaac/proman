package br.ufmt.proman.projetoStakeholder;

public class ProjetoStakeholderRequest {
    
    private String funcaoProjetoStakeholder;
    private String influenciaProjetoStakeholder;
    private String interesseProjetoStakeholder;

    public void funcaoProjetoStakeholder(String funcao){
        this.funcaoProjetoStakeholder = funcao;
    }

    public String getFuncaoProjetoStakeholder(){
        return funcaoProjetoStakeholder;
    }

    public void influenciaProjetoStakeholder(String influencia){
        this.influenciaProjetoStakeholder = influencia;
    }

    public String getInfluenciaProjetoStakeholder(){
        return influenciaProjetoStakeholder;
    }

    public void setInteresseProjetoStakeholder(String interesse){
        this.interesseProjetoStakeholder = interesse;
    }

    public String getInteresseProjetoStakeholder(){
        return interesseProjetoStakeholder;
    }
}
