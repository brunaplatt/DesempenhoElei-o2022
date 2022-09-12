package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Tabelas.Candidato;

public class CandidatoTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_IDCANDIDATO = 0;
	private static final int COL_NOME = 1;
	private static final int COL_PARTIDO = 2;
	private static final int COL_FICHALIMPA = 3;
		
	private List<Candidato> valores;
	
	public CandidatoTableModel(List<Candidato> valores) {
		this.valores = new ArrayList<Candidato>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
		
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int column) {
		if(column == COL_IDCANDIDATO) return "Código do Candidato";
		if(column == COL_NOME) return "Nome Candidato";
		if(column == COL_PARTIDO) return "Partido";
		if(column == COL_FICHALIMPA) return "Ficha Limpa?";
		return "";
	}

	public Object getValueAt(int row, int column) {
		Candidato candidato = valores.get(row);
		if (column == COL_IDCANDIDATO)
			return candidato.getIdcandidatos();
		else
			if(column == COL_NOME)
				return candidato.getNome();
		else
			if(column == COL_PARTIDO)
				return candidato.getPartido();
		else
			if(column == COL_FICHALIMPA)
				return candidato.getFichaLimpa();
		return "";
	}	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Candidato candidato = valores.get(rowIndex);
		if (columnIndex == COL_IDCANDIDATO)
			candidato.setIdcandidatos(Integer.parseInt(aValue.toString()));
		else
			if(columnIndex == COL_NOME)
				candidato.setNome(aValue.toString());
		else
			if(columnIndex == COL_PARTIDO)
				candidato.setPartido(aValue.toString());
		else
			if(columnIndex == COL_FICHALIMPA)
				candidato.setFichaLimpa(aValue.toString());
	}
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	public Candidato get (int row) {
		return valores.get(row);
	}
}
