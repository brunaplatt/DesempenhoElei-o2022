package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.PesquisaController;
import Tabelas.Candidato;
import Tabelas.Pesquisa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;


public class Pesquisas extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtInstitutoPesquisa;
	private JTextField txtDataPesquisa;
	private JTextField txtMediaIdade;
	private JTextField txtUfPesquisa;
	private JTextField txtFormatoPesquisa;
	private JTextField txtTipoPesquisa;
	private Pesquisa pesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisas frame = new Pesquisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pesquisas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Pesquisas");
		setBounds(100, 100, 778, 452);
		
		JPanel jpPesquisas = new JPanel();
		jpPesquisas.setBorder(new TitledBorder(null, "Pesquisas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCancelarPesquisa = new JButton("Cancelar");
		btnCancelarPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvarPesquisa = new JButton("Salvar");
		btnSalvarPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pesquisa pesquisa = new Pesquisa();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					pesquisa.setInstitutopesquisa(txtInstitutoPesquisa.getText());
					pesquisa.setDatapesquisa(LocalDate.parse(txtDataPesquisa.getText(), formatter));
					pesquisa.setUf(txtUfPesquisa.getText());
					pesquisa.setTipopesquisa(txtTipoPesquisa.getText());
					pesquisa.setFormatopesquisa(txtFormatoPesquisa.getText());
					pesquisa.setMediaidade(getX());
					
					new PesquisaController().salvar(pesquisa);
					JOptionPane.showMessageDialog(null, "Pesquisa salva com sucesso");
					dispose();
				} catch (Exception pe) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar pesquisa");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvarPesquisa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelarPesquisa))
						.addComponent(jpPesquisas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpPesquisas, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelarPesquisa)
						.addComponent(btnSalvarPesquisa))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JLabel lblnstitutoPesquisa = new JLabel("Instituto Pesquisa:");
		
		txtInstitutoPesquisa = new JTextField();
		txtInstitutoPesquisa.setColumns(10);
		
		JLabel lbDataPesquisa = new JLabel("Data Pesquisa:");
		
		txtDataPesquisa = new JTextField();
		txtDataPesquisa.setColumns(10);
		
		JLabel lbMediaIdadePesquisa = new JLabel("Média Idade: ");
		
		txtMediaIdade = new JTextField();
		txtMediaIdade.setColumns(10);
		
		JLabel lbUfPesquisa = new JLabel("UF:");
		
		JLabel lbTipoPesquisa = new JLabel("Tipo Pesquisa:");
		
		JLabel lbFormatoPesquisa = new JLabel("Formato Pesquisa:");
		
		txtUfPesquisa = new JTextField();
		txtUfPesquisa.setColumns(10);
		
		txtFormatoPesquisa = new JTextField();
		txtFormatoPesquisa.setColumns(10);
		
		txtTipoPesquisa = new JTextField();
		txtTipoPesquisa.setColumns(10);
		GroupLayout gl_jpPesquisas = new GroupLayout(jpPesquisas);
		gl_jpPesquisas.setHorizontalGroup(
			gl_jpPesquisas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPesquisas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lbMediaIdadePesquisa, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lblnstitutoPesquisa, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtInstitutoPesquisa, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lbDataPesquisa, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lbTipoPesquisa, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lbUfPesquisa, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUfPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPesquisas.createSequentialGroup()
							.addComponent(lbFormatoPesquisa, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFormatoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpPesquisas.setVerticalGroup(
			gl_jpPesquisas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPesquisas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnstitutoPesquisa, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtInstitutoPesquisa, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbDataPesquisa, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataPesquisa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMediaIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbMediaIdadePesquisa))
					.addGap(34)
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbUfPesquisa)
						.addComponent(txtUfPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFormatoPesquisa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFormatoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_jpPesquisas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbTipoPesquisa)
						.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		jpPesquisas.setLayout(gl_jpPesquisas);
		getContentPane().setLayout(groupLayout);

	}
	public void setPesquisaUI(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;	
		preencheFormulario();
	}
	
	private void preencheFormulario() {
		if(pesquisa != null) {
			txtDataPesquisa.setText(pesquisa.getDatapesquisa().toString());
			txtInstitutoPesquisa.setText(pesquisa.getInstitutopesquisa());
			txtFormatoPesquisa.setText(pesquisa.getFormatopesquisa());
			txtTipoPesquisa.setText(pesquisa.getTipopesquisa());
			txtMediaIdade.setText(Integer.toString(pesquisa.getMediaidade()));
			txtUfPesquisa.setText(pesquisa.getUf());
		}
	}
}
