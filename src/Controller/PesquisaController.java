package Controller;

import java.util.List;

import DAO.PesquisaDao;
import Tabelas.Pesquisa;

public class PesquisaController {

    public void salvar(Pesquisa pesquisa) throws Exception{
        if (pesquisa.getDatapesquisa() == null || pesquisa.getInstitutopesquisa() == null) {
            throw new Exception("Dados incompletos!");
        }
        PesquisaDao.getInstance().salvar(pesquisa);

    }

    public void atualizar(Pesquisa pesquisa) throws Exception {
    	 if (pesquisa.getDatapesquisa() == null || pesquisa.getInstitutopesquisa() == null) {
            throw new Exception("Dados incompletos!");
        }
        PesquisaDao.getInstance().atualizar(pesquisa);
    }

    public void excluir(int idPesquisa) throws Exception {
        if (idPesquisa == 0) {
            throw new Exception("Nenhuma pesquisa encontrada.");

        }
        PesquisaDao.getInstance().excluir(idPesquisa);
    }

    public List<Pesquisa> listar(){
        return PesquisaDao.getInstance().listar();
    }
}
