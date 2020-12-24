package controle;

import DAO.RelacionamentoDAO;
import java.util.ArrayList;
import modelo.Relacionamento;

public class OperacaoRelacionamento implements OperacaoGeneric<Relacionamento> {

    private RelacionamentoDAO relacionamentoDao;

    public OperacaoRelacionamento() {
        relacionamentoDao = new RelacionamentoDAO();
    }

    @Override
    public void realiza(Relacionamento obj) {
        this.relacionamentoDao.cadastrar(obj);
    }
    
    @Override
    public void atualiza(Relacionamento obj){
        this.relacionamentoDao.atualizar(obj);
    }

    public ArrayList<Relacionamento> visualizaLista(Relacionamento obj, java.sql.Date data1, java.sql.Date data2) {
       String sql=" WHERE data BETWEEN '"+data1+"' AND '"+data2+"' ORDER BY data ASC";
        return this.relacionamentoDao.consultar(sql);
    }
    
    public  Relacionamento find(Relacionamento obj) {
        String sql = " WHERE cpf = " + obj.getCpf();
        return this.relacionamentoDao.consultar(sql).get(0);
    }

    @Override
    public void cancelar(Relacionamento obj) {
        this.relacionamentoDao.remover(obj);
    }

    @Override
    public ArrayList<Relacionamento> visualiza(Relacionamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
