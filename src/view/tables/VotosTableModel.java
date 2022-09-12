package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tabelas.CandidatoxPesquisa;
import view.Votos;

public class VotosTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_PESQUISA = 1;
	private static final int COL_VOTOS = 2;
		
	private List<Votos> valores;
	
	public VotosTableModel(List<Votos> valores) {
		this.valores = new ArrayList<Votos>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int column) {
		if(column == COL_NOME) return "Nome Candidato";
		if(column == COL_PESQUISA) return "Instituto Pesquisa";
		if(column == COL_VOTOS) return "Votos";
		return "";
	}

	public Object getValueAt(int row, int column) {
		Votos Votos = valores.get(row);
		if(column == COL_NOME)
			return Votos.getNome();
		else
			if(column == COL_PESQUISA)
				return Votos.getPesquisa();
		else
			if(column == COL_VOTOS)
				return Votos.getVotos();
		return "";
	}	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Votos voto = valores.get(rowIndex);
		if(columnIndex == COL_NOME)
			voto.setNome(aValue.toString());
		else
			if(columnIndex == COL_PESQUISA)
				voto.setPesquisa(aValue.toString());
		else
			if(columnIndex == COL_VOTOS)
				voto.setVotos(Integer.parseInt(aValue.toString()));
		
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	public Votos get (int row) {
		return valores.get(row);
	}

}
