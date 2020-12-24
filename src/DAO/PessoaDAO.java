package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;

public class PessoaDAO extends GenericDAO<Usuarios> {

    private static final String AUTHENTICATE = "SELECT * FROM pessoa WHERE cpf=? and senha=?";
    private static final String UPSENHA = "UPDATE pessoa set SENHA=? where cpf=? and email=?";
    private static final String DELETE = "DELETE FROM pessoa WHERE cpf = ?";
    private static final String FIND = "SELECT * FROM pessoa";
    private static final String INSERT = "INSERT INTO pessoa (NOME, CPF, EMAIL, ENDERECO, CIDADE, TELEFONE, NASCIMENTO, SENHA, CEP, TIPO) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE pessoa SET NOME=?, EMAIL=?, ENDERECO=?, CIDADE=?, CEP=?, TELEFONE=?, NASCIMENTO=?, SENHA=?, TIPO=? WHERE CPF = ?";
    private static final String UPDATEP = "UPDATE pessoa SET NOME=?, EMAIL=?, ENDERECO=?, CIDADE=?, CEP=?, TELEFONE=?, NASCIMENTO=? WHERE CPF = ?";

    @Override
    public void cadastrar(Usuarios obj) {
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
            comando.setString(8, obj.getSenha());
            comando.setInt(9, obj.getCep());
            comando.setString(10, obj.getTipo());

            comando.execute();

            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void atualizar(Usuarios obj) {
        String sql = UPDATEP;
        
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
    
    public void atualizarTudo(Usuarios obj) {
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
            comando.setString(8, obj.getSenha());
            comando.setString(9, obj.getTipo());
            
            comando.setLong(10, obj.getCpf());
            
            comando.executeUpdate();
            
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remover(Usuarios obj) {
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
    public ArrayList<Usuarios> consultar(String search) {
        String sql = FIND;
        
        if(search !=null && !search.trim().isEmpty()){
            sql += search;
        }

        ArrayList<Usuarios> objects;
        objects = new ArrayList<Usuarios>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Usuarios pessoa = new Usuarios();
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCpf(resultSet.getLong("cpf"));
                pessoa.setCep(resultSet.getInt("cep"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setEndereco(resultSet.getString("endereco"));
                pessoa.setCidade(resultSet.getString("cidade"));
                pessoa.setTelefone(resultSet.getLong("telefone"));
                pessoa.setNascimento(resultSet.getString("nascimento"));               
                pessoa.setSenha(resultSet.getString("senha"));
                pessoa.setTipo(resultSet.getString("tipo"));

                objects.add(pessoa);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects;
    }

    public Usuarios autenticar(long cpf, String senha) {
        String sql = AUTHENTICATE;
       
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setLong(1, cpf);
            comando.setString(2, senha);
            
            ResultSet resultSet = comando.executeQuery();

            if (!resultSet.next() && resultSet.getRow() == 0) {
                return null;
            }
            
            Usuarios pessoa = new Usuarios();
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setCpf(resultSet.getLong("cpf"));
            pessoa.setCep(resultSet.getInt("cep"));
            pessoa.setEmail(resultSet.getString("email"));
            pessoa.setEndereco(resultSet.getString("endereco"));
            pessoa.setCidade(resultSet.getString("cidade"));
            pessoa.setTelefone(resultSet.getLong("telefone"));
            pessoa.setNascimento(resultSet.getString("nascimento"));               
            pessoa.setSenha(resultSet.getString("senha"));
            pessoa.setTipo(resultSet.getString("tipo"));
            
            comando.close();
            this.conexao.getConnection().close();
           

            return pessoa;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public void atualizaSenha(Long cpf,String senha,String email) {
        String sql = UPSENHA;        
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setString(1, senha);
            comando.setLong(2, cpf); 
            comando.setString(3, email);
            comando.executeUpdate();
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
