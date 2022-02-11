package service.endereco;

import java.util.List;

import model.bo.endereco.Cidade;
import model.DAO.endereco.CidadeDAO;
import service.InterfaceService;

public class CidadeService implements InterfaceService<Cidade> {

    @Override
    public void salvar(Cidade obj) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(obj);
    }

    @Override
    public List<Cidade> buscar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.read();
    }

    @Override
    public Cidade buscar(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.read(codigo);
    }

    @Override
    public Cidade buscar(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.read(descricao);
    }

    @Override
    public void atualizar(Cidade obj) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(obj);
    }

    @Override
    public void deletar(Cidade obj) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(obj);
    }
}