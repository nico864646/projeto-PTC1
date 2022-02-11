package model.bo.produto;

public class Cor {
    private int idCor;
    private String descricao;

    public Cor() {
    }

    public Cor(int idCor, String descricao) {
        this.idCor = idCor;
        this.descricao = descricao;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     @Override
    public String toString() {
        return this.getDescricao();  
    }
    
    
}
