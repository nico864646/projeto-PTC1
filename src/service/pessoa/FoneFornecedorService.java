package service.pessoa;

import java.util.List;

import model.DAO.pessoa.FoneFornecedorDAO;
import model.bo.pessoa.FoneFornecedor;

public class FoneFornecedorService{

    public void salvar(FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.create(obj);
    }

    public List<FoneFornecedor> buscarPorFornecedor(int codigo) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        return foneFornecedor.readBySupplierID(codigo);
    }

    public FoneFornecedor buscarPorID(int codigo) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        return foneFornecedor.readByID(codigo);
    }

    public void atualizar(FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.update(obj);
    }

    public void deletar(FoneFornecedor obj) {
        FoneFornecedorDAO foneFornecedor = new FoneFornecedorDAO();
        foneFornecedor.delete(obj);
    }
}
