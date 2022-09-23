package Controller;

import java.util.List;

import DAO.CandidatoxPesquisaDao;
import Tabelas.Candidato;
import Tabelas.CandidatoxPesquisa;
import Tabelas.Pesquisa;

public class CandidatoxPesquisaController {

    public void salvar(Pesquisa pesquisa, Candidato candidato, CandidatoxPesquisa candidatoxpesquisa) throws Exception {
        if(candidatoxpesquisa.getCandidato() == null || candidatoxpesquisa.getPesquisa() == null || candidatoxpesquisa.getVotos() == 0) {
            throw new Exception("Informação faltante, favor verificar!");
        }
        CandidatoxPesquisaDao.getInstance().salvar(pesquisa, candidato, candidatoxpesquisa);
    }
    
    public void atualizar(CandidatoxPesquisa candidatoxpesquisa) throws Exception {
    	  if(candidatoxpesquisa.getCandidato() == null || candidatoxpesquisa.getPesquisa() == null || candidatoxpesquisa.getVotos() == 0) {
              throw new Exception("Informação faltante, favor verificar!");
          }
          CandidatoxPesquisaDao.getInstance().atualizar(candidatoxpesquisa);
	}

	public void excluir(int idcandidatoxpesquisa) throws Exception {
		if(idcandidatoxpesquisa == 0) {
			throw new Exception("Nenhuma informação selecionada.");
		}
		CandidatoxPesquisaDao.getInstance().excluir(idcandidatoxpesquisa);
	}
	public List<CandidatoxPesquisa> listar(){
		return CandidatoxPesquisaDao.getInstance().listar();
		
		
	}
}
