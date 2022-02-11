package service.pessoa;

import java.util.List;

import model.DAO.pessoa.FoneFornecedorDAO;
import model.bo.pessoa.FoneFornecedor;

public class FoneFornecedorService{

    public void salvar(FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.create(obj);
    }

    public List<FoneFornecedor> buscar(int codigo) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        return foneFornecedor.read(codigo);
    }

    // public FoneFornecedor buscar(String descricao) {
    //     FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
    //     return foneFornecedor.read(descricao);
    // }

    public void atualizar(String novoContato, FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.update(novoContato, obj);
    }

    public void deletar(FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.delete(obj);
    }
}
