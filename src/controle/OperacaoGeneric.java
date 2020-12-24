package controle;

import java.util.ArrayList;

public interface OperacaoGeneric<T> {
    public void realiza(T obj);
    public void atualiza(T obj);
    public ArrayList<T> visualiza (T obj);
    public void cancelar (T obj);
}
