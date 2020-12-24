package modelo;

import java.util.Date;

public class Doacao {
    private long cpf;
    private float valor;
    private Date data;
    private int id;

    public Doacao(long cpf, float valor, Date data) {
        this.cpf = cpf;
        this.valor = valor;
        this.data = data;

    }
     public Doacao(long cpf, float valor, Date data,int id) {
        this.cpf = cpf;
        this.valor = valor;
        this.data = data;
        this.id=id;
    }
    public Doacao() {        
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
}
