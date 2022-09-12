package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Controller.CandidatosController;
import Controller.CandidatoxPesquisaController;
import Controller.PesquisaController;
import Tabelas.Candidato;
import Tabelas.CandidatoxPesquisa;
import Tabelas.Pesquisa;
import view.tables.VotosTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Votos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String CandidatoxPesquisa = null;
	private JTextField txtVotosVotos;
	private JTable tbVotos;
	
	JComboBox<Candidato> comVotosCandidatos = new JComboBox<Candidato>();
	JComboBox<Pesquisa> comVotosPesquisa = new JComboBox<Pesquisa> ();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Votos frame = new Votos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Votos() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Intenção de Votos - Pesquisas");
		setBounds(100, 100, 952, 445);
		
		DefaultComboBoxModel<Candidato> modelCandidato = new DefaultComboBoxModel<Candidato>();
		for(Candidato candidato : new CandidatosController().listar()) {
			modelCandidato.addElement(candidato);
		}
		comVotosCandidatos.setModel(modelCandidato);
		
		DefaultComboBoxModel<Pesquisa> modelPesquisa = new DefaultComboBoxModel<Pesquisa>();
		for(Pesquisa pesquisa : new PesquisaController().listar()) {
			modelPesquisa.addElement(pesquisa);
		}
		comVotosPesquisa.setModel(modelPesquisa);
		
		txtVotosVotos = new JTextField();
		txtVotosVotos.setColumns(10);
		
		List<Votos> votosVotos = new ArrayList<Votos>();
		
		JLabel lblVotosCandidatos = new JLabel("Candidatos: ");
		
		JLabel lblVotosPesquisa = new JLabel("Pesquisa:");
		
		JLabel lblVotos = new JLabel("Votos:");
		
		JButton btnVotosAdicionar = new JButton("Adicionar");
		btnVotosAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = (Tabelas.Candidato) comVotosCandidatos.getSelectedItem();
				Pesquisa pesquisa = (Tabelas.Pesquisa) comVotosPesquisa.getSelectedItem(); 
				int voto = Integer.parseInt(txtVotosVotos.getText());
				tbVotos.add(tbVotos);
				tbVotos.setModel(new VotosTableModel(votosVotos));
			}
		});
		
		JButton btnVotosSalvar = new JButton("Salvar");
		btnVotosSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = (Candidato) comVotosCandidatos.getSelectedItem();
				Pesquisa pesquisa = (Pesquisa) comVotosPesquisa.getSelectedItem();
				CandidatoxPesquisa candidatoxpesquisa = new CandidatoxPesquisa();
				candidatoxpesquisa.getVotos();
				new CandidatoxPesquisaController().registrarVotos();
				JOptionPane.showMessageDialog(null, "Intenção de Votos Registrada");
				dispose();				
			}
		});
		
		JButton btnVotosCancelar = new JButton("Cancelar");
		btnVotosCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrVotos = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVotosCandidatos, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVotosPesquisa, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVotos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtVotosVotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 667, Short.MAX_VALUE)
									.addComponent(btnVotosAdicionar))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comVotosPesquisa, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comVotosCandidatos, 0, 364, Short.MAX_VALUE)))
							.addContainerGap(18, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnVotosSalvar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnVotosCancelar))
								.addComponent(scrVotos, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(18, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVotosCandidatos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comVotosCandidatos, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVotosPesquisa)
						.addComponent(comVotosPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVotos)
						.addComponent(txtVotosVotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVotosAdicionar))
					.addGap(28)
					.addComponent(scrVotos, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVotosCancelar)
						.addComponent(btnVotosSalvar))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		tbVotos = new JTable();
		scrVotos.setViewportView(tbVotos);
		getContentPane().setLayout(groupLayout);

	}

	public Object getIdCandidato() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPesquisa() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getVotos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNome(String string) {
		// TODO Auto-generated method stub
		
	}
}
