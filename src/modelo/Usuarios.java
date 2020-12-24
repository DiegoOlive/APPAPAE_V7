
package modelo;


public class Usuarios extends Pessoa{
    
    private String senha;
    private String tipo;
    public Usuarios(String nome, long cpf, String email, int cep, String endereco, String cidade, long telefone, String nascimento,String senha,String tipo ) {        
        super(nome,cpf,email,cep,endereco,cidade,telefone,nascimento);
        this.tipo=tipo;
        this.senha=senha;
    }
    public Usuarios() {
        
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
}
