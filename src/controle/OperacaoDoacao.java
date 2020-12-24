package controle;

import DAO.DoacaoDAO;
import java.util.ArrayList;
import modelo.Doacao;

public class OperacaoDoacao implements OperacaoGeneric<Doacao> {

    private DoacaoDAO doacaoDao;

    public OperacaoDoacao() {
        doacaoDao = new DoacaoDAO();
    }

    @Override
    public void realiza(Doacao obj) {
        this.doacaoDao.cadastrar(obj);
    }
    
    @Override
    public void atualiza(Doacao obj){
        this.doacaoDao.atualizar(obj);
    }

    public ArrayList<Doacao> visualizaLista(Doacao obj, java.sql.Date data1, java.sql.Date data2) {
       String sql=" WHERE data BETWEEN '"+data1+"' AND '"+data2+"' ORDER BY data ASC";
        return this.doacaoDao.consultar(sql);
    }
    
    public  Doacao find(Doacao obj) {
        String sql = " WHERE cpf = " + obj.getCpf();
        return this.doacaoDao.consultar(sql).get(0);
    }
    
    public ArrayList<Doacao> listDoacoes(Doacao obj,long cpf) {
        return this.doacaoDao.listDoacoes("",cpf);
    }

    @Override
    public void cancelar(Doacao obj) {
        this.doacaoDao.remover(obj);
    }

    @Override
    public ArrayList<Doacao> visualiza(Doacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizaT(Doacao dados,int id) {
        String sql=(" set valor="+dados.getValor()+" , data='"+dados.getData()+"' Where id="+id);
        this.doacaoDao.atualizarT(sql);
    }
    
    public float somaDoacoes(){
        return this.doacaoDao.consultarDoacoes();
    }
}
