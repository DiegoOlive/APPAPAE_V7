package controle;

import DAO.DoadorDAO;
import java.util.ArrayList;
import modelo.Doacao;
import modelo.Doador;

public class OperacaoDoador implements OperacaoGeneric<Doador> {

    private DoadorDAO doadorDao;

    public OperacaoDoador() {
        doadorDao = new DoadorDAO();
    }

    @Override
    public void realiza(Doador obj) {
        this.doadorDao.cadastrar(obj);
    }
    
    @Override
    public void atualiza(Doador obj){
        this.doadorDao.atualizar(obj);
    }

    @Override
    public ArrayList<Doador> visualiza(Doador obj) {
        String sql = " ";

        return this.doadorDao.consultar(sql);
    }

    public Doador find(Doador obj) {
        String sql = " WHERE cpf = " + obj.getCpf();
        return this.doadorDao.consultar(sql).get(0);
    }

    @Override
    public void cancelar(Doador obj) {
        this.doadorDao.remover(obj);
    }
    
    public ArrayList<Doador> visualizaLista(Doador obj) {
        return this.doadorDao.consultar("");
    }
    public void atualizaStatus(Doacao doa, java.sql.Date dataUltima){
        String sql=" Where cpf= "+doa.getCpf()+" and AGE(now(),'"+ dataUltima+"') < '3 months' ";
        this.doadorDao.atualizaStatus(sql);
    }

}
