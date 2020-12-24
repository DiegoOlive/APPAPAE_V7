package modelo;

import java.util.Date;

public class Relacionamento {
    private long cpf;
    private long cpf2;
    private int id;

    public Relacionamento(long cpf,long cpf2, int id) {
        this.cpf = cpf;
        this.cpf2 = cpf2;
        this.id=id;
    }

    public Relacionamento() {        
    }


    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public long getCpf2() {
        return cpf2;
    }

    public void setCpf2(long cpf) {
        this.cpf2 = cpf;
    }
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
