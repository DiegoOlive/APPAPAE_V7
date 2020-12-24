package controle;

import DAO.GastoDAO;
import java.util.ArrayList;
import modelo.Gasto;

public class OperacaoGastos implements OperacaoGeneric<Gasto> {

    private GastoDAO gastoDao;

    public OperacaoGastos() {
        gastoDao = new GastoDAO();
    }

    @Override
    public void realiza(Gasto obj) {
        this.gastoDao.cadastrar(obj);
        System.out.println("xxx");
    }
    
    @Override
    public void atualiza(Gasto obj){
        this.gastoDao.atualizar(obj);
    }

    @Override
    public ArrayList<Gasto> visualiza(Gasto obj) {
        return this.gastoDao.consultar(null);
    }
    
    public Gasto find(Gasto obj) {
        String sql = " WHERE tipo = " + obj.getTipo() + " and data = " +obj.getData();
        return this.gastoDao.consultar(sql).get(0);
    }

    @Override
    public void cancelar(Gasto obj) {
        this.gastoDao.remover(obj);
    }
    public ArrayList<Gasto> visualizaLista(Gasto obj,java.sql.Date data1, java.sql.Date data2) {
       String sql=" WHERE data BETWEEN '"+data1+"' AND '"+data2+"' ORDER BY data ASC";
        return this.gastoDao.consultar(sql);
    }

    public void atualizaT(Gasto dados,int id) {    
        String sql=(" set valor="+dados.getValor()+" , tipo= '"+dados.getTipo()+"' , data='"+dados.getData()+"' Where id="+id);
        this.gastoDao.atualizarT(sql);
    }
    
    public float somaGastos(){
        return this.gastoDao.consultarGastos();
    }
    
}