package Tabelas;

public class Pesquisa {

    private int idPesquisa;
    private String institutopesquisa;
    private String datapesquisa;
    private int mediaidade;
    private String uf;
    private String formato;
    private String tipopesquisa;
    private String tipo;

    public Pesquisa(int idPesquisa, String institutoPesquisa, String dataPesquisa, int mediaIdade, String uf, String formato, String tipoPesquisa, String tipo) {
        this.idPesquisa = idPesquisa;
        this.institutopesquisa = institutoPesquisa;
        this.datapesquisa = dataPesquisa;
        this.mediaidade = mediaIdade;
        this.uf = uf;
        this.formato = formato;
        this.tipopesquisa = tipoPesquisa;
        this.tipo = tipo;
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

	public String getDatapesquisa() {
		return datapesquisa;
	}

	public void setDatapesquisa(String datapesquisa) {
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

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getTipopesquisa() {
		return tipopesquisa;
	}

	public void setTipopesquisa(String tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    public String toString() {
    	return "Pesquisa " + this.idPesquisa + " - " + this.institutopesquisa + " - " + this.formato + " - " + this.tipopesquisa;
    }

}
