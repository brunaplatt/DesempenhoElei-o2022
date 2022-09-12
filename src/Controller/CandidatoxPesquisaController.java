package Controller;

import DAO.CandidatoxPesquisaDao;
import Tabelas.CandidatoxPesquisa;

public class CandidatoxPesquisaController {

    public void registrarVotos(CandidatoxPesquisa candidatopesquisa) throws Exception {
        if(candidatopesquisa.getPesquisa() == null) {
            throw new Exception("Pesquisa Inválida");
        }
        if(candidatopesquisa.getCandidato() == null) {
            throw new Exception("Candidato Inválido");
        }
        CandidatoxPesquisaDao.getInstance().registrarVotos(candidatopesquisa);
    }

	public void registrarVotos() {
		
		
	}

	public void salvar(CandidatoxPesquisa votos) {
		
		
	}
}