package model.DAO.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.endereco.Cep;
import model.bo.pessoa.Vendedor;
import service.endereco.CepService;

public class VendedorDAO implements InterfaceDAO<Vendedor> {

    @Override
    public void create(Vendedor obj) {
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        String sql = 
                "INSERT INTO vendedor (nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, " +
                "percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idCep) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getNome());
            prepState.setString(2, obj.getCpf());
            prepState.setString(3, obj.getEmail());
            prepState.setString(4, obj.getFone());
            prepState.setFloat(5, obj.getPercentComissaoVenda());
            prepState.setFloat(6, obj.getPercentComissaoRecebto());
            prepState.setString(7, obj.getComplementoEnd());
            prepState.setInt(8, obj.getEnderecoCep().getIdCep());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Vendedor> read() {
        String sql = 
                "SELECT idVendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor," +
                "percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idCep " +
                "FROM vendedor";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Vendedor> vendedores = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                Vendedor vendedor = new Vendedor();
                Cep cep = new Cep();
                CepService cepService = new CepService();

                vendedor.setIdVendedor(result.getInt("idVendedor"));
                vendedor.setNome(result.getString("nomeVendedor"));
                vendedor.setCpf(result.getString("cpfVendedor"));
                vendedor.setEmail(result.getString("emailVendedor"));
                vendedor.setFone(result.getString("foneVendedor"));
                vendedor.setPercentComissaoVenda(result.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(result.getFloat("percentComissaoRecebto"));
                vendedor.setComplementoEnd(result.getString("compleEnderecoVendedor"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                vendedor.setEnderecoCep(cep);

                vendedores.add(vendedor);
            }
            return vendedores;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Vendedor read(int codigo) {
        String sql = 
                "SELECT idVendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, " +
                "percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idCep "+
                "FROM vendedor " +
                "WHERE vendedor.idVendedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            Vendedor vendedor = new Vendedor();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                vendedor.setIdVendedor(result.getInt("idVendedor"));
                vendedor.setNome(result.getString("nomeVendedor"));
                vendedor.setCpf(result.getString("cpfVendedor"));
                vendedor.setEmail(result.getString("emailVendedor"));
                vendedor.setFone(result.getString("foneVendedor"));
                vendedor.setPercentComissaoVenda(result.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(result.getFloat("percentComissaoRecebto"));
                vendedor.setComplementoEnd(result.getString("compleEnderecoVendedor"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                vendedor.setEnderecoCep(cep);
            }
            return vendedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Vendedor read(String descricao) {
        String sql = 
            "SELECT idVendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor," +
            "percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idCep " +
            "FROM vendedor " +
            "WHERE vendedor.cpfVendedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            Vendedor vendedor = new Vendedor();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                vendedor.setIdVendedor(result.getInt("idVendedor"));
                vendedor.setNome(result.getString("nomeVendedor"));
                vendedor.setCpf(result.getString("cpfVendedor"));
                vendedor.setEmail(result.getString("emailVendedor"));
                vendedor.setFone(result.getString("foneVendedor"));
                vendedor.setPercentComissaoVenda(result.getFloat("percentComissaoVenda"));
                vendedor.setPercentComissaoRecebto(result.getFloat("percentComissaoRecebto"));
                vendedor.setComplementoEnd(result.getString("compleEnderecoVendedor"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                vendedor.setEnderecoCep(cep);
            }
            return vendedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Vendedor obj) {
        String sql = 
                "UPDATE vendedor SET nomeVendedor = ? , cpfVendedor = ? , emailVendedor = ?, " +
                "foneVendedor = ? , percentComissaoVenda = ? , percentComissaoRecebto = ? , compleEnderecoVendedor = ? , endereco_idCep = ? "+
                "WHERE vendedor.idVendedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getNome());
            prepState.setString(2, obj.getCpf());
            prepState.setString(3, obj.getEmail());
            prepState.setString(4, obj.getFone());
            prepState.setFloat(5, obj.getPercentComissaoVenda());
            prepState.setFloat(6, obj.getPercentComissaoVenda());
            prepState.setString(7, obj.getComplementoEnd());
            prepState.setInt(8, obj.getEnderecoCep().getIdCep());
            prepState.setInt(9, obj.getIdVendedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Vendedor obj) {
        String sql = "DELETE FROM vendedor WHERE idVendedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdVendedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}