package modelo;

import java.io.File;
import java.util.Date;

public class Gasto {
    private Date data;
    private String tipo;
    private double valor; 
    private int id;
    private long cpf;

    public Gasto(String tipo, double valor,Date data) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
    }
    public Gasto(String tipo, double valor,Date data,int id,long cpf) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.id=id;
        this.cpf=cpf;
    }
     public Gasto(String tipo, double valor,Date data,int id) {
        
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.id=id;

    }

    public Gasto() {        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date Data) {
        this.data = Data;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
}
