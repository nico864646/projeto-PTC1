package model.DAO.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.produto.TipoProduto;

public class TipoProdutoDAO implements InterfaceDAO<TipoProduto> {
    @Override
    public void create(TipoProduto obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO tipoproduto (descricaoTipoProd) VALUES (?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<TipoProduto> read() {
        String sql = "SELECT idTipoProduto, descricaoTipoProd FROM tipoproduto";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<TipoProduto> tipoprodutoes = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                TipoProduto tipoproduto = new TipoProduto();
                tipoproduto.setIdTipoProduto(result.getInt("idTipoProduto"));
                tipoproduto.setDescricao(result.getString("descricaoTipoProd"));
                tipoprodutoes.add(tipoproduto);
            }

            return tipoprodutoes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public TipoProduto read(int codigo) {
        String sql = "SELECT idTipoProduto, descricaoTipoProd FROM tipoproduto WHERE tipoproduto.idTipoProduto = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            TipoProduto tipoproduto = new TipoProduto();

            while (result.next()) {
                tipoproduto.setIdTipoProduto(result.getInt("idTipoProduto"));
                tipoproduto.setDescricao(result.getString("descricaoTipoProd"));
            }

            return tipoproduto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public TipoProduto read(String descricao) {
        String sql = "SELECT idTipoProduto, descricaoTipoProd FROM tipoproduto WHERE tipoproduto.descricaoTipoProd = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            TipoProduto tipoproduto = new TipoProduto();

            while (result.next()) {
                tipoproduto.setIdTipoProduto(result.getInt("idTipoProduto"));
                tipoproduto.setDescricao(result.getString("descricaoTipoProd"));
            }

            return tipoproduto;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(TipoProduto obj) {
        String sql = "UPDATE tipoproduto SET descricaoTipoProd = ? WHERE tipoproduto.idTipoProduto = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getIdTipoProduto());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(TipoProduto obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM tipoproduto WHERE idTipoProduto = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdTipoProduto());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}