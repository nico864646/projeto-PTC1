package service.pessoa;

import java.util.List;

import model.bo.pessoa.Fornecedor;
import model.DAO.pessoa.FornecedorDAO;
import service.InterfaceService;

public class FornecedorService implements InterfaceService<Fornecedor> {

    @Override
    public void salvar(Fornecedor obj) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(obj);
    }

    @Override
    public List<Fornecedor> buscar() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.read();
    }

    @Override
    public Fornecedor buscar(int codigo) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.read(codigo);
    }

    @Override
    public Fornecedor buscar(String descricao) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.read(descricao);
    }

    @Override
    public void atualizar(Fornecedor obj) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(obj);
    }

    @Override
    public void deletar(Fornecedor obj) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(obj);
    }
}