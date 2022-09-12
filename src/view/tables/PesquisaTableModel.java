package view.tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import Tabelas.Pesquisa;

public class PesquisaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_DATAPESQUISA = 0;
	private static final int COL_INSTITUTOPESQUISA = 1;
	private static final int COL_FORMATOPESQUISA = 2;
	private static final int COL_TIPOPESQUISA = 3;
	private static final int COL_MEDIAIDADE = 4;
	private static final int COL_UF = 5;
			
	private List<Pesquisa> valores;
	
	public PesquisaTableModel(List<Pesquisa> valores) {
		this.valores = new ArrayList<Pesquisa>(valores);
	}
	public int getRowCount() {
		return valores.size();
	}
	public int getColumnCount() {
		return 6;
	}
	public String getColumnName(int column) {
		if(column == COL_DATAPESQUISA) return "Data Pesquisa";
		if(column == COL_INSTITUTOPESQUISA) return "Instituto";
		if(column == COL_FORMATOPESQUISA) return "Formato";
		if(column == COL_TIPOPESQUISA) return "Tipo Pesquisa";
		if(column == COL_MEDIAIDADE) return "Média Idade";
		if(column == COL_UF) return "UF";
		return "";
	}

	public Object getValueAt(int row, int column) {
		Pesquisa Pesquisa = valores.get(row);
		if (column == COL_DATAPESQUISA)
			return Pesquisa.getDatapesquisa();
		else
			if(column == COL_INSTITUTOPESQUISA)
				return Pesquisa.getInstitutopesquisa();
		else
			if(column == COL_FORMATOPESQUISA)
				return Pesquisa.getFormatopesquisa();
		else
			if(column == COL_TIPOPESQUISA)
				return Pesquisa.getTipopesquisa();
		else
			if(column == COL_MEDIAIDADE)
				return Pesquisa.getMediaidade();
		else
			if(column == COL_UF)
				return Pesquisa.getUf();
		return "";
	}	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pesquisa pesquisa = valores.get(rowIndex);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		if (columnIndex == COL_DATAPESQUISA)
			pesquisa.setDatapesquisa(LocalDate.parse(aValue.toString(), formatter));
		else
			if(columnIndex == COL_INSTITUTOPESQUISA)
			 pesquisa.setInstitutopesquisa(aValue.toString());
		else
			if(columnIndex == COL_FORMATOPESQUISA)
				pesquisa.setFormatopesquisa(aValue.toString());
		else
			if(columnIndex == COL_TIPOPESQUISA)
				pesquisa.setTipopesquisa(aValue.toString());
		else			
			if(columnIndex == COL_MEDIAIDADE)
				pesquisa.setMediaidade(Integer.parseInt(aValue.toString()));
		else
			if(columnIndex == COL_UF)
				pesquisa.setUf(aValue.toString());
	
	}
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	public Pesquisa get (int row) {
		return valores.get(row);
	}
}

