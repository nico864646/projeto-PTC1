package model.DAO.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.bo.pessoa.FoneFornecedor;
import model.bo.pessoa.Fornecedor;
import service.pessoa.FornecedorService;

public class FoneFornecedorDAO {

    public void create(FoneFornecedor obj) {
        String sqlExecutar = "INSERT INTO fonefornecedor (foneFornecedor, fornecedor_idfornecedor) " +
                             "VALUES (?, ?)";
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getFornecedor().getIdFornecedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    public List<FoneFornecedor> read(int codigo) {
        String sqlExecutar = "SELECT foneFornecedor, fornecedor_idfornecedor " + 
                             "FROM fonefornecedor " +
                             "WHERE fornecedor_idfornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<FoneFornecedor> fones = new ArrayList<>();
        
        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            while (result.next()) {
                FoneFornecedor foneFornecedor = new FoneFornecedor();
                Fornecedor fornecedor = new Fornecedor();
                FornecedorService fService = new FornecedorService();

                foneFornecedor.setDescricao(result.getString("foneFornecedor"));
                
                fornecedor = fService.buscar(result.getInt("fornecedor_idfornecedor"));
                foneFornecedor.setFornecedor(fornecedor);

                fones.add(foneFornecedor);
            }
            return fones;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }


    // public FoneFornecedor read(String descricao) {
    //     String sql =  "SELECT foneFornecedor, fornecedor_idfornecedor FROM fonefornecedor " +
    //                   "WHERE fonefornecedor.foneFornecedor = ?";

    //     Connection connection = ConnectionFactory.getConnection();
    //     PreparedStatement prepState = null;
    //     ResultSet result = null;

    //     FoneFornecedor foneFornecedor = new FoneFornecedor();
    //     Fornecedor fornecedor = new Fornecedor();
    //     FornecedorService fService = new FornecedorService();
    //     try {
    //         prepState = connection.prepareStatement(sql);
    //         prepState.setString(1, descricao);
    //         result = prepState.executeQuery();

    //         while (result.next()) {
    //             foneFornecedor.setDescricao(result.getString("foneFornecedor"));
                
    //             fornecedor = fService.buscar(result.getInt("fornecedor_idfornecedor"));
    //             foneFornecedor.setFornecedor(fornecedor);
    //         }
    //         return foneFornecedor;

    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //         return null;
    //     } finally {
    //         ConnectionFactory.closeConnection(connection, prepState, result);
    //     }
    // }

    public void update(String oldNumber, FoneFornecedor obj) {
        String sql = "UPDATE fonefornecedor SET foneFornecedor = ? fornecedor_idfornecedor = ?  " + 
                     "WHERE fonefornecedor.foneFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getFornecedor().getIdFornecedor());
            prepState.setString(3, oldNumber);
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    public void delete(FoneFornecedor obj) {
        String sql = "DELETE FROM fonefornecedor WHERE foneFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
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
}
