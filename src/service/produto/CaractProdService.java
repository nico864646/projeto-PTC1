package service.produto;

import java.util.List;

import model.DAO.produto.CaractProdDAO;
import model.bo.produto.CaractProd;
import service.InterfaceService;

public class CaractProdService implements InterfaceService<CaractProd> {

    @Override
    public void salvar(CaractProd obj) {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        produtoDAO.create(obj);
    }

    @Override
    public List<CaractProd> buscar() {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        return produtoDAO.read();
    }

    @Override
    public CaractProd buscar(int codigo) {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        return produtoDAO.read(codigo);
    }

    @Override
    public CaractProd buscar(String descricao) {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        return produtoDAO.read(descricao);
    }

    @Override
    public void atualizar(CaractProd obj) {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        produtoDAO.update(obj);
    }

    @Override
    public void deletar(CaractProd obj) {
        CaractProdDAO produtoDAO = new CaractProdDAO();
        produtoDAO.delete(obj);
    }
}
