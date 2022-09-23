package Tabelas;


public class CandidatoxPesquisa{

    private int idcandidatoxpesquisa;
    private int votos;
    private Candidato candidato;
    private Pesquisa pesquisa;
 
    public CandidatoxPesquisa(int idcandidatoxpesquisa, int votos, Candidato candidato, Pesquisa pesquisa) {
        this.idcandidatoxpesquisa = idcandidatoxpesquisa;
        this.votos = votos;
        this.candidato = candidato;
        this.pesquisa = pesquisa;
    }
    
    public CandidatoxPesquisa() {
    }

    public int getIdcandidatoxpesquisa() {
        return idcandidatoxpesquisa;
    }

    public void setIdcandidatoxpesquisa(int idcandidatoxpesquisa) {
        this.idcandidatoxpesquisa = idcandidatoxpesquisa;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public String toString() {
    	return "Candidato: " + this.candidato  + " - Pesquisa: " + this.pesquisa + " - Votos: " + this.votos;
    }

   
}
