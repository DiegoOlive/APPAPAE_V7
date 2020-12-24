
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Doador;

public class DoadorDAO extends GenericDAO<Doador> {

    private static final String DELETE = "DELETE FROM doador WHERE cpf = ?";
    private static final String FIND = "SELECT * FROM doador";
    private static final String UPDATEStatus="Update doador set status=? ";
    private static final String INSERT = "INSERT INTO doador (NOME, CPF, EMAIL, ENDERECO, CIDADE, TELEFONE, NASCIMENTO, CEP, STATUS) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE doador SET NOME=?, EMAIL=?, ENDERECO=?, CIDADE=?, CEP=?, TELEFONE=?, NASCIMENTO=? WHERE CPF = ?";

    @Override
    public void cadastrar(Doador obj) {
        String sql = INSERT;
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);

            comando.setString(1, obj.getNome());
            comando.setLong(2, obj.getCpf());
            comando.setString(3, obj.getEmail());
            comando.setString(4, obj.getEndereco());
            comando.setString(5, obj.getCidade());
            comando.setLong(6, obj.getTelefone());
            comando.setString(7, obj.getNascimento());
            comando.setInt(8, obj.getCep());
            comando.setBoolean(9, obj.getStatus());
            comando.execute();
            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void atualizar(Doador obj) {
        String sql = UPDATE;
        
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getEmail());
            comando.setString(3, obj.getEndereco());
            comando.setString(4, obj.getCidade());
            comando.setInt(5, obj.getCep());
            comando.setLong(6, obj.getTelefone());
            comando.setString(7, obj.getNascimento());
            comando.setLong(8, obj.getCpf());
            comando.executeUpdate();
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remover(Doador obj) {
        String sql = DELETE;
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setLong(1, obj.getCpf());
            comando.execute();
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<Doador> consultar(String search) {
        String sql = FIND;
        
        if(search !=null && !search.trim().isEmpty()){
            sql += search;
        }

        ArrayList<Doador> objects;
        objects = new ArrayList<Doador>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Doador pessoa = new Doador();
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCpf(resultSet.getLong("cpf"));
                pessoa.setCep(resultSet.getInt("cep"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setEndereco(resultSet.getString("endereco"));
                pessoa.setCidade(resultSet.getString("cidade"));
                pessoa.setTelefone(resultSet.getLong("telefone"));
                pessoa.setNascimento(resultSet.getString("nascimento"));               
                pessoa.setStatus(resultSet.getBoolean("status"));
                objects.add(pessoa);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects;
    }
    public void atualizaStatus(String search) {
        String sql = UPDATEStatus;
        
        if(search !=null && !search.trim().isEmpty()){
            sql += search;
        }
        System.out.println(sql);
         try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setBoolean(1, (true));
            comando.executeUpdate();
            
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}

