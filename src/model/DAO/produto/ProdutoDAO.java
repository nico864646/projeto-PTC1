package model.DAO.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.produto.Marca;
import model.bo.produto.Produto;
import model.bo.produto.Tamanho;
import model.bo.produto.TipoProduto;
import service.produto.MarcaService;
import service.produto.TamanhoService;
import service.produto.TipoProdutoService;

public class ProdutoDAO implements InterfaceDAO<Produto> {
    @Override
    public void create(Produto produto) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO produto (descricaoProduto, valProduto, "+
                     "marca_idMarca, tamanho_idTamanho, tipoProduto_idTipoProd) " +
                     "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, produto.getDescricao());
            prepState.setFloat(2, produto.getValProduto());
            prepState.setInt(3, produto.getMarca().getIdMarca());
            prepState.setInt(4, produto.getTamanho().getIdTamanho());
            prepState.setInt(5, produto.getTipoProduto().getIdTipoProduto());
    
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Produto> read() {
        String sql = "SELECT idProduto, descricaoProduto, valProduto, " +
                     "marca_idMarca, tamanho_idTamanho, tipoProduto_idTipoProd " +
                     "FROM produto";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            
            while (result.next()) {
                Produto produto = new Produto();
                Marca marca = new Marca();
                MarcaService mService = new MarcaService();
                TipoProduto tipoProduto = new TipoProduto();
                TipoProdutoService tipoPService = new TipoProdutoService();
                Tamanho tamanho = new Tamanho();
                TamanhoService tamService = new TamanhoService();

                produto.setIdProduto(result.getInt("idProduto"));
                produto.setDescricao(result.getString("descricaoProduto"));
                produto.setValProduto(result.getFloat("valProduto"));

                marca = mService.buscar(result.getInt("marca_idMarca"));
                produto.setMarca(marca);

                tamanho = tamService.buscar(result.getInt("tamanho_idTamanho"));
                produto.setTamanho(tamanho);

                tipoProduto = tipoPService.buscar(result.getInt("tipoProduto_idTipoProd"));
                produto.setTipoProduto(tipoProduto);

                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Produto read(int codigo) {
        String sql = "SELECT idProduto, descricaoProduto, valProduto, " +
                     "marca_idMarca, tamanho_idTamanho, tipoProduto_idTipoProd " +
                     "FROM produto WHERE produto.idProduto = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            Produto produto = new Produto();
            Marca marca = new Marca();
            MarcaService mService = new MarcaService();
            TipoProduto tipoProduto = new TipoProduto();
            TipoProdutoService tipoPService = new TipoProdutoService();
            Tamanho tamanho = new Tamanho();
            TamanhoService tamService = new TamanhoService();

            while (result.next()) {
                produto.setIdProduto(result.getInt("idProduto"));
                produto.setDescricao(result.getString("descricaoProduto"));
                produto.setValProduto(result.getFloat("valProduto"));

                marca = mService.buscar(result.getInt("marca_idMarca"));
                produto.setMarca(marca);

                tamanho = tamService.buscar(result.getInt("tamanho_idTamanho"));
                produto.setTamanho(tamanho);

                tipoProduto = tipoPService.buscar(result.getInt("tipoProduto_idTipoProd"));
                produto.setTipoProduto(tipoProduto);
            }
            return produto;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Produto read(String descricao) {
        String sql = "SELECT idProduto, descricaoProduto, valProduto, " +
                     "marca_idMarca, tamanho_idTamanho, tipoProduto_idTipoProd " +
                     "FROM produto WHERE produto.descricaoProduto = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            Produto produto = new Produto();
            Marca marca = new Marca();
            MarcaService mService = new MarcaService();
            TipoProduto tipoProduto = new TipoProduto();
            TipoProdutoService tipoPService = new TipoProdutoService();
            Tamanho tamanho = new Tamanho();
            TamanhoService tamService = new TamanhoService();

            while (result.next()) {
                produto.setIdProduto(result.getInt("idProduto"));
                produto.setDescricao(result.getString("descricaoProduto"));
                produto.setValProduto(result.getFloat("valProduto"));

                marca = mService.buscar(result.getInt("marca_idMarca"));
                produto.setMarca(marca);

                tamanho = tamService.buscar(result.getInt("tamanho_idTamanho"));
                produto.setTamanho(tamanho);

                tipoProduto = tipoPService.buscar(result.getInt("tipoProduto_idTipoProd"));
                produto.setTipoProduto(tipoProduto);
            }
            return produto;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Produto produto) {
        String sql = "UPDATE produto SET descricaoProduto = ?, valProduto = ?, " +
                     "marca_idMarca = ?, tamanho_idTamanho = ?, tipoProduto_idTipoProd = ? " +
                     "WHERE produto.idProduto = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, produto.getDescricao());
            prepState.setFloat(2, produto.getValProduto());
            prepState.setInt(3, produto.getMarca().getIdMarca());
            prepState.setInt(4, produto.getTamanho().getIdTamanho());
            prepState.setInt(5, produto.getTipoProduto().getIdTipoProduto());
            prepState.setInt(6, produto.getIdProduto());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Produto produto) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM produto WHERE idProduto = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, produto.getIdProduto());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}