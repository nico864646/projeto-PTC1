package service.produto;

import java.util.List;

import model.DAO.produto.MarcaDAO;
import model.bo.produto.Marca;
import service.InterfaceService;

public class MarcaService implements InterfaceService<Marca> {

    @Override
    public void salvar(Marca obj) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.create(obj);
    }

    @Override
    public List<Marca> buscar() {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.read();
    }

    @Override
    public Marca buscar(int codigo) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.read(codigo);
    }

    @Override
    public Marca buscar(String descricao) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.read(descricao);
    }

    @Override
    public void atualizar(Marca obj) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.update(obj);
    }

    @Override
    public void deletar(Marca obj) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.delete(obj);
    }
}