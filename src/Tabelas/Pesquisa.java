package Tabelas;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Pesquisa {

    private int idPesquisa;
    private String institutopesquisa;
    private LocalDate datapesquisa;
    private int mediaidade;
    private String uf;
    private String formatopesquisa;
    private String tipopesquisa;

    public Pesquisa(int idPesquisa, String institutoPesquisa, LocalDate dataPesquisa, int mediaIdade, String uf, String formatoPesquisa, String tipoPesquisa) {
        this.idPesquisa = idPesquisa;
        this.institutopesquisa = institutoPesquisa;
        this.datapesquisa = dataPesquisa;
        this.mediaidade = mediaIdade;
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

	public LocalDate getDatapesquisa() {
		return datapesquisa;
	}

	public void setDatapesquisa(LocalDate datapesquisa) {
		this.datapesquisa = datapesquisa;
	}

	public int getMediaidade() {
		return mediaidade;
	}

	public void setMediaidade(int mediaidade) {
		this.mediaidade = mediaidade;
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

	public void setDatapesquisa(ResultSet rs, Date valueOf) {
				
	}

	
}