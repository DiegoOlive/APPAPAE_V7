package controle;

import DAO.PessoaDAO;
import modelo.Usuarios;

public class OperacaoAutenticacao {
    private Usuarios usuario;
    private PessoaDAO pessoaDao;
    
    public OperacaoAutenticacao(){
        this.pessoaDao = new PessoaDAO();
    }
    
    public boolean autenticar(long cpf, String senha){
        boolean usuarioEncontrado = false;
        
        Usuarios pessoa = pessoaDao.autenticar(cpf, senha);
        
        if(pessoa !=null){
            usuarioEncontrado=true;
            this.usuario = pessoa;
        }
        
        return usuarioEncontrado;
    }
    
    public void finalizar(){        
        this.usuario=null;
    }
    
    public Usuarios getUsuario(){
        return this.usuario;
    }
}
