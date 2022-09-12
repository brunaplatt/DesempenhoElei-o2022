package Controller;

import java.util.List;

import DAO.PesquisaDao;
import Tabelas.Pesquisa;

public class PesquisaController {

    public void salvar(Pesquisa pesquisa) throws Exception{
        if (pesquisa.getFormatopesquisa() == null || pesquisa.getFormatopesquisa().trim().equals("")) {
            throw new Exception("Descrição inválida");
        }
        PesquisaDao.getInstance().salvar(pesquisa);

    }

    public void atualizar(Pesquisa pesquisa) throws Exception {
        if (pesquisa.getFormatopesquisa() == null || pesquisa.getFormatopesquisa().trim().equals("")) {
            throw new Exception("Descrição inválida");
        }
        PesquisaDao.getInstance().atualizar(pesquisa);
    }

    public void excluir(int idPesquisa) throws Exception {
        if (idPesquisa == 0) {
            throw new Exception("Erro");

        }
        PesquisaDao.getInstance().excluir(idPesquisa);
    }

    public List<Pesquisa> listar(){
        return PesquisaDao.getInstance().listar();
    }
}