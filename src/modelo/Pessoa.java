package modelo;

public class Pessoa {

    private String nome;
    private long cpf;
    private String email;
    private int cep;
    private String endereco;
    private String cidade;
    private long telefone;
    private String nascimento;
    

    public Pessoa(String nome, long cpf, String email, int cep, String endereco, String cidade, long telefone, String nascimento) {        
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.nascimento = nascimento;
    }

    public Pessoa() {
        
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    


    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
   
}
