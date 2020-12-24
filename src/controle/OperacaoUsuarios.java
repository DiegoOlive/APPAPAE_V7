package controle;

import DAO.PessoaDAO;
import java.util.ArrayList;
import modelo.Usuarios;

public class OperacaoUsuarios implements OperacaoGeneric<Usuarios> {

    private PessoaDAO pessoaDao;

    public OperacaoUsuarios() {
        pessoaDao = new PessoaDAO();
    }

    @Override
    public void realiza(Usuarios obj) {
        this.pessoaDao.cadastrar(obj);
    }
    
    @Override
    public void atualiza(Usuarios obj){
        this.pessoaDao.atualizar(obj);
    }
    
    public void atualizaTudo(Usuarios obj){
        
        this.pessoaDao.atualizarTudo(obj);
    }

    public ArrayList<Usuarios> visualiza(Usuarios obj) {
        String sql = " WHERE tipo ILIKE '%" + obj.getTipo() + "%'";

        return this.pessoaDao.consultar(sql);
    }

    public Usuarios find(Usuarios obj) {
        String sql = " WHERE cpf = " + obj.getCpf();
        return this.pessoaDao.consultar(sql).get(0);
    }

    @Override
    public void cancelar(Usuarios obj) {
        this.pessoaDao.remover(obj);
    }
    
    public ArrayList<Usuarios> visualizaLista(Usuarios obj) {
        String sql = " ";

        return this.pessoaDao.consultar(sql);
    }

    public void atualizaSenha(Long cpf,String senha,String email){
        this.pessoaDao.atualizaSenha(cpf,senha,email);
    }
}
