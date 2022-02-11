package model.DAO.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.produto.CaractProd;
import model.bo.produto.Cor;
import model.bo.produto.Produto;
import service.produto.CorService;
import service.produto.ProdutoService;

public class CaractProdDAO implements InterfaceDAO<CaractProd> {
    @Override
    public void create(CaractProd caracteristicaproduto) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO caracteristicaproduto (produto_idProduto, cor_idCor, "+
                     "tamanhoProduto, cdgBarraProduto, qtdEstoqueProduto) " +
                     "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, caracteristicaproduto.getProduto().getIdProduto());
            prepState.setInt(2, caracteristicaproduto.getCor().getIdCor());
            prepState.setString(3, caracteristicaproduto.getTamanhoProduto());
            prepState.setString(4, caracteristicaproduto.getBarraProduto());
            prepState.setFloat(5, caracteristicaproduto.getQtdEstoque());
    
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<CaractProd> read() {
        String sql = "SELECT idCaractProd, produto_idProduto, cor_idCor, " +
                     "tamanhoProduto, cdgBarraProduto, qtdEstoqueProduto " +
                     "FROM caracteristicaproduto";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<CaractProd> caractProdutos = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                CaractProd caractProduto = new CaractProd();
                Produto produto = new Produto();
                ProdutoService pService = new ProdutoService();
                Cor cor = new Cor();
                CorService cService = new CorService();

                caractProduto.setIdCaracteristicaProduto(result.getInt("idCaractProd"));
                caractProduto.setTamanhoProduto(result.getString("tamanhoProduto"));
                caractProduto.setBarraProduto(result.getString("cdgBarraProduto"));
                caractProduto.setQtdEstoque(result.getFloat("qtdEstoqueProduto"));

                produto = pService.buscar(result.getInt("produto_idProduto"));
                caractProduto.setProduto(produto);

                cor = cService.buscar(result.getInt("cor_idCor"));
                caractProduto.setCor(cor);

                caractProdutos.add(caractProduto);
            }
            return caractProdutos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public CaractProd read(int codigo) {
        String sql = "SELECT idCaractProd, produto_idProduto, cor_idCor, " +
                     "tamanhoProduto, cdgBarraProduto, qtdEstoqueProduto " +
                     "FROM caracteristicaproduto " + 
                     "WHERE caracteristicaproduto.idCaractProd = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            CaractProd caractProduto = new CaractProd();
            Produto produto = new Produto();
            ProdutoService pService = new ProdutoService();
            Cor cor = new Cor();
            CorService cService = new CorService();

            while (result.next()) {
                caractProduto.setIdCaracteristicaProduto(result.getInt("idCaractProd"));
                caractProduto.setTamanhoProduto(result.getString("tamanhoProduto"));
                caractProduto.setBarraProduto(result.getString("cdgBarraProduto"));
                caractProduto.setQtdEstoque(result.getFloat("qtdEstoqueProduto"));

                produto = pService.buscar(result.getInt("produto_idProduto"));
                caractProduto.setProduto(produto);

                cor = cService.buscar(result.getInt("cor_idCor"));
                caractProduto.setCor(cor);
            }
            return caractProduto;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public CaractProd read(String descricao) {
        String sql = "SELECT idCaractProd, produto_idProduto, cor_idCor, " +
                     "tamanhoProduto, cdgBarraProduto, qtdEstoqueProduto " +
                     "FROM caracteristicaproduto " +
                     "WHERE caracteristicaproduto.idCaractProd = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            CaractProd caractProduto = new CaractProd();
            Produto produto = new Produto();
            ProdutoService pService = new ProdutoService();
            Cor cor = new Cor();
            CorService cService = new CorService();

            while (result.next()) {
                caractProduto.setIdCaracteristicaProduto(result.getInt("idCaractProd"));
                caractProduto.setTamanhoProduto(result.getString("tamanhoProduto"));
                caractProduto.setBarraProduto(result.getString("cdgBarraProduto"));
                caractProduto.setQtdEstoque(result.getFloat("qtdEstoqueProduto"));

                produto = pService.buscar(result.getInt("produto_idProduto"));
                caractProduto.setProduto(produto);

                cor = cService.buscar(result.getInt("cor_idCor"));
                caractProduto.setCor(cor);
            }
            return caractProduto;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(CaractProd caracteristicaproduto) {
        String sql = "UPDATE caracteristicaproduto SET produto_idProduto = ?, cor_idCor = ?, " +
                     "tamanhoProduto = ?, cdgBarraProduto = ?, qtdEstoqueProduto = ? " +
                     "WHERE caracteristicaproduto.idCaractProd = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, caracteristicaproduto.getProduto().getIdProduto());
            prepState.setInt(2, caracteristicaproduto.getCor().getIdCor());
            prepState.setString(3, caracteristicaproduto.getTamanhoProduto());
            prepState.setString(4, caracteristicaproduto.getBarraProduto());
            prepState.setFloat(5, caracteristicaproduto.getQtdEstoque());
            prepState.setInt(6, caracteristicaproduto.getIdCaracteristicaProduto());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(CaractProd caracteristicaproduto) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM caracteristicaproduto WHERE idCaractProd = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, caracteristicaproduto.getIdCaracteristicaProduto());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}