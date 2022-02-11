package model.bo.endereco;


public class Cidade {
    private int idCidade;
    private String descricao;
    private String uf;
    
    public Cidade(){
        
    }

    public Cidade(int idCidade, String descricao, String uf) {
        this.idCidade = idCidade;
        this.descricao = descricao;
        this.uf = uf;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }
    
    
}
