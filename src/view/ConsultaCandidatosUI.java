package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableModel;

import Controller.CandidatoController;
import Tabelas.Candidato;
import view.tables.CandidatoTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCandidatosUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable jtCandidatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCandidatosUI frame = new ConsultaCandidatosUI();
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
	public ConsultaCandidatosUI() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Candidatos");
		setBounds(100, 100, 873, 289);
		
		JButton btnConsultaCandCancelar = new JButton("Cancelar");
		btnConsultaCandCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnConsultaCandExcluir = new JButton("Excluir");
		btnConsultaCandExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				try { 
					new CandidatoController().excluir(candidato.getIdcandidatos());
					jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir o candidato");
				}
			}
		});
		
		JButton btnConsultaCandEditar = new JButton("Editar");
		btnConsultaCandEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				CadastrosUI cadcandidatoUI = new CadastrosUI();
				cadcandidatoUI.setCandidatoUI(candidato);
				cadcandidatoUI.setVisible(true);
				getParent().add(cadcandidatoUI, 0);
			}
		});
		
		JScrollPane scrCandidatos = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(550)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnConsultaCandEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultaCandExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultaCandCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrCandidatos, GroupLayout.PREFERRED_SIZE, 842, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrCandidatos, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConsultaCandCancelar)
						.addComponent(btnConsultaCandExcluir)
						.addComponent(btnConsultaCandEditar)
						.addComponent(btnAtualizar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		jtCandidatos = new JTable();
		jtCandidatos.setModel((TableModel) new CandidatoTableModel(new CandidatoController().listar()));
		scrCandidatos.setViewportView(jtCandidatos);
		getContentPane().setLayout(groupLayout);

	}
}
