package Tabelas;


public class CandidatoxPesquisa{

    private int idcandidatoxpesquisa;
    private int votos;
    private String candidato;
    private String pesquisa;
 
    public CandidatoxPesquisa(int idcandidatoxpesquisa, int votos, String candidato, String pesquisa) {
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

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

   
}