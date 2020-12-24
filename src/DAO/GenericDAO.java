package DAO;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class GenericDAO<T> {    

    Conexao conexao;

    public GenericDAO() {
        this.conexao = new Conexao();
    }

    public abstract void cadastrar(T obj);

    public abstract void atualizar(T obj);

    public abstract void remover(T obj);

    public abstract ArrayList<T> consultar(String column);
}
