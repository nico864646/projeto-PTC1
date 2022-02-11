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

public class MarcaDAO implements InterfaceDAO<Marca> {
    @Override
    public void create(Marca obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO marca (descricaoMarca) VALUES (?)";

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
    public List<Marca> read() {
        String sql = "SELECT idMarca, descricaoMarca FROM marca";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Marca> marcaes = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                Marca marca = new Marca();
                marca.setIdMarca(result.getInt("idMarca"));
                marca.setDescricao(result.getString("descricaoMarca"));
                marcaes.add(marca);
            }

            return marcaes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Marca read(int codigo) {
        String sql = "SELECT idMarca, descricaoMarca FROM marca WHERE marca.idMarca = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            Marca marca = new Marca();

            while (result.next()) {
                marca.setIdMarca(result.getInt("idMarca"));
                marca.setDescricao(result.getString("descricaoMarca"));
            }

            return marca;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Marca read(String descricao) {
        String sql = "SELECT idMarca, descricaoMarca FROM marca WHERE marca.descricaoMarca = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            Marca marca = new Marca();

            while (result.next()) {
                marca.setIdMarca(result.getInt("idMarca"));
                marca.setDescricao(result.getString("descricaoMarca"));
            }

            return marca;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Marca obj) {
        String sql = "UPDATE marca SET descricaoMarca = ? WHERE marca.idMarca = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getIdMarca());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Marca obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM marca WHERE idMarca = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdMarca());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}