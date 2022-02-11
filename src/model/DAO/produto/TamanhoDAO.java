package model.DAO.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.produto.Tamanho;

public class TamanhoDAO implements InterfaceDAO<Tamanho> {
    @Override
    public void create(Tamanho obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO tamanho (descricaoTamanho) VALUES (?)";

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
    public List<Tamanho> read() {
        String sql = "SELECT idTamanho, descricaoTamanho FROM tamanho";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Tamanho> tamanhoes = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                Tamanho tamanho = new Tamanho();
                tamanho.setIdTamanho(result.getInt("idTamanho"));
                tamanho.setDescricao(result.getString("descricaoTamanho"));
                tamanhoes.add(tamanho);
            }

            return tamanhoes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Tamanho read(int codigo) {
        String sql = "SELECT idTamanho, descricaoTamanho FROM tamanho WHERE tamanho.idTamanho = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            Tamanho tamanho = new Tamanho();

            while (result.next()) {
                tamanho.setIdTamanho(result.getInt("idTamanho"));
                tamanho.setDescricao(result.getString("descricaoTamanho"));
            }

            return tamanho;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Tamanho read(String descricao) {
        String sql = "SELECT idTamanho, descricaoTamanho FROM tamanho WHERE tamanho.descricaoTamanho = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            Tamanho tamanho = new Tamanho();

            while (result.next()) {
                tamanho.setIdTamanho(result.getInt("idTamanho"));
                tamanho.setDescricao(result.getString("descricaoTamanho"));
            }

            return tamanho;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Tamanho obj) {
        String sql = "UPDATE tamanho SET descricaoTamanho = ? WHERE tamanho.idTamanho = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getIdTamanho());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Tamanho obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM tamanho WHERE idTamanho = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdTamanho());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}