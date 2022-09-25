package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controller.PesquisaController;
import Tabelas.Pesquisa;
import view.tables.PesquisaTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPesquisaUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable jtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPesquisaUI frame = new ConsultaPesquisaUI();
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
	public ConsultaPesquisaUI() {
		setClosable(true);
		setTitle("Consulta Pesquisas");
		setBounds(100, 100, 894, 298);
		
		JScrollPane scrConsultaPesquisa = new JScrollPane();
		
		JButton btnConsultaPesqAtualizar = new JButton("Atualizar Dados");
		btnConsultaPesqAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
			}
		});
		
		JButton btnConsultaPesqEditar = new JButton("Editar");
		btnConsultaPesqEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				PesquisasUI cadpesquisaUI = new PesquisasUI();
				cadpesquisaUI.setPesquisaUI(pesquisa);
				cadpesquisaUI.setVisible(true);
				getParent().add(cadpesquisaUI, 0);
			}
		});
		
		JButton btnConsultaPesqExcluir = new JButton("Excluir");
		btnConsultaPesqExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				try { 
					new PesquisaController().excluir(pesquisa.getIdPesquisa());
					jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir a pesquisa");
				}
			}
		});
		
		JButton btnConsultaPesqCancelar = new JButton("Cancelar");
		btnConsultaPesqCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnConsultaPesqAtualizar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnConsultaPesqEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultaPesqExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultaPesqCancelar))
						.addComponent(scrConsultaPesquisa, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrConsultaPesquisa, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConsultaPesqCancelar)
						.addComponent(btnConsultaPesqExcluir)
						.addComponent(btnConsultaPesqEditar)
						.addComponent(btnConsultaPesqAtualizar))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		
		jtPesquisa = new JTable();
		jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
		scrConsultaPesquisa.setViewportView(jtPesquisa);
		getContentPane().setLayout(groupLayout);

	}
	
}
