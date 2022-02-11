package service.endereco;

import java.util.List;

import model.bo.endereco.Bairro;
import model.DAO.endereco.BairroDAO;
import service.InterfaceService;

public class BairroService implements InterfaceService<Bairro> {

    @Override
    public void salvar(Bairro obj) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.create(obj);
    }

    @Override
    public List<Bairro> buscar() {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.read();
    }

    @Override
    public Bairro buscar(int codigo) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.read(codigo);
    }

    @Override
    public Bairro buscar(String descricao) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.read(descricao);
    }

    @Override
    public void atualizar(Bairro obj) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.update(obj);
    }

    @Override
    public void deletar(Bairro obj) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.delete(obj);
    }
}