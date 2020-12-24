
package modelo;

public class Doador extends Pessoa {
    private boolean status;
    public Doador(String nome, long cpf, String email, int cep, String endereco, String cidade, long telefone, String nascimento,boolean status ) {        
        super(nome,cpf,email,cep,endereco,cidade,telefone,nascimento);
        this.status=status;
    } 
    public Doador(){
        
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
