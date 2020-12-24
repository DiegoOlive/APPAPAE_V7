
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Relacionamento;

public class RelacionamentoDAO extends GenericDAO<Relacionamento> {

    private static final String DELETE = "DELETE FROM doador WHERE cpf = ?";
    private static final String FIND = "SELECT * FROM doador";
    private static final String INSERT = "INSERT INTO relauserdoador ( CPF, cpf2) VALUES (?,?)";
    private static final String UPDATE = "UPDATE doador SET NOME=?, EMAIL=?, ENDERECO=?, CIDADE=?, CEP=?, TELEFONE=?, NASCIMENTO=?, STATUS=? WHERE CPF = ?";

    public void cadastrar(Relacionamento obj) {
        String sql = INSERT;
        
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
               
            comando.setLong(1, obj.getCpf());
            comando.setLong(2, obj.getCpf2());
            comando.execute();
            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void atualizar(Relacionamento obj) {
    }
    @Override
    public void remover(Relacionamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Relacionamento> consultar(String column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

