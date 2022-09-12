package Tabelas;

import java.sql.Date;



public class Pesquisa {

    private int idPesquisa;
    private String institutopesquisa;
    private Date datapesquisa;
    private int medialidade;
    private String uf;
    private String formatopesquisa;
    private String tipopesquisa;

    public Pesquisa(int idPesquisa, String institutoPesquisa, Date dataPesquisa, int medialIdade, String uf, String formatoPesquisa, String tipoPesquisa) {
        this.idPesquisa = idPesquisa;
        this.institutopesquisa = institutoPesquisa;
        this.datapesquisa = dataPesquisa;
        this.medialidade = medialIdade;
        this.uf = uf;
        this.formatopesquisa = formatoPesquisa;
        this.tipopesquisa = tipoPesquisa;
    }

    public Pesquisa() {
	}

    public int getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(int idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public String getInstitutopesquisa() {
		return institutopesquisa;
	}

	public void setInstitutopesquisa(String institutopesquisa) {
		this.institutopesquisa = institutopesquisa;
	}

	public Date getDatapesquisa() {
		return datapesquisa;
	}

	public void setDatapesquisa1(Date date) {
		this.datapesquisa = date;
	}

	public int getMedialidade() {
		return medialidade;
	}

	public void setMedialidade(int medialidade) {
		this.medialidade = medialidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFormatopesquisa() {
		return formatopesquisa;
	}

	public void setFormatopesquisa(String formatopesquisa) {
		this.formatopesquisa = formatopesquisa;
	}

	public String getTipopesquisa() {
		return tipopesquisa;
	}

	public void setTipopesquisa(String tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

    public String toString() {
    	return datapesquisa + " - " + institutopesquisa;
    }

    public void setDatapesquisa(Date date) {
    		
	}

}