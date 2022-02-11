package model.bo.pessoa;

public class FoneFornecedor{
    private int idFone;
    private String descricao;
    private Fornecedor fornecedor;
    
    public FoneFornecedor(){
        
    }

    public FoneFornecedor(int idFone, String descricao, Fornecedor fornecedor) {
        this.idFone = idFone;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    public int getIdFone() {
        return idFone;
    }

    public void setIdFone(int idFone) {
        this.idFone = idFone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "FoneFornecedor{" + ", descricao=" + descricao + ", fornecedor=" + fornecedor + '}';
    }
} 
    