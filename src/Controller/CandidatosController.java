package Controller;

import java.util.List;

import DAO.CandidatoDao;
import Tabelas.Candidato;

public class CandidatosController {

    public void salvar(Candidato candidatos) throws Exception {
        if (candidatos.getNome() == null || candidatos.getNome().length() < 3) {
            throw new Exception("Descrição Inválida");
        }
        CandidatoDao.getInstance().salvar(candidatos);
    }

    public void atualizar(Candidato candidatos) throws Exception {

        if (candidatos.getNome() == null || candidatos.getNome().length() < 3) {
            throw new Exception("Nome inválido");
        }

        CandidatoDao.getInstance().atualizar(candidatos);
    }

    public  void excluir(int idcandidatos) throws Exception {

        if (idcandidatos == 0) {
            throw new Exception();
        }
        CandidatoDao.getInstance().excluir(idcandidatos);

    }

    public List<Candidato> listar(){

        return CandidatoDao.getInstance().listar();
    }
}