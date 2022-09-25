package Controller;

import java.util.List;

import DAO.CandidatoDao;
import Tabelas.Candidato;

public class CandidatoController {

    public void salvar(Candidato candidato) throws Exception {
        if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
            throw new Exception("Candidato e/ou Partido Inválidos!");
        }
        CandidatoDao.getInstance().salvar(candidato);
    }

    public void atualizar(Candidato candidato) throws Exception {
        if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
            throw new Exception("Candidato e/ou Partido Inválidos!");
        }
        CandidatoDao.getInstance().atualizar(candidato);
    }

    public  void excluir(int idcandidatos) throws Exception {
        if (idcandidatos == 0) {
            throw new Exception("Nenhum candidato selecionado!");
        }
        CandidatoDao.getInstance().excluir(idcandidatos);

    }

    public List<Candidato> listar(){

        return CandidatoDao.getInstance().listar();
    }
}
