package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.CandidatoController;
import Tabelas.Candidato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrosUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeCandidato;
	private JTextField txtIdCandidatos;
	private JTextField txtPartidoCandidato;
	private JTextField txtFichaLimpaCandidato;
	private Candidato candidato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrosUI frame = new CadastrosUI();
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
	
	public CadastrosUI() {
		setMaximizable(true);
		setIconifiable(true);
		
			
		setClosable(true);
		setToolTipText("Cadastro de Candidatos");
		setBounds(100, 100, 1037, 357);
		
		JPanel jpCadastroCandidatos = new JPanel();
		jpCadastroCandidatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Candidatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnCandidatoCancelar = new JButton("Cancelar");
		btnCandidatoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnCandidatoSalvar = new JButton("Salvar");
		btnCandidatoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					if (candidato != null && candidato.getIdcandidatos() > 0) {
						candidato.setNome(txtNomeCandidato.getText());
						candidato.setPartido(txtPartidoCandidato.getText());
						candidato.setFichaLimpa(txtFichaLimpaCandidato.getText());
						new CandidatoController().atualizar(candidato);
						JOptionPane.showMessageDialog(null, "Candidato atualizado com sucesso");
					} else {
						Candidato cadastros = new Candidato();
						cadastros.setIdcandidatos(Integer.parseInt(txtIdCandidatos.getText()));
						cadastros.setNome(txtNomeCandidato.getText());
						cadastros.setPartido(txtPartidoCandidato.getText());
						cadastros.setFichaLimpa(txtFichaLimpaCandidato.getText());
						
						new CandidatoController().salvar(cadastros);
						JOptionPane.showMessageDialog(null, "Candidato salvo com sucesso");
					}
					dispose();
				} catch	(Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar candidato");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroCandidatos, GroupLayout.PREFERRED_SIZE, 1002, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(856, Short.MAX_VALUE)
					.addComponent(btnCandidatoSalvar)
					.addGap(18)
					.addComponent(btnCandidatoCancelar)
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(jpCadastroCandidatos, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCandidatoSalvar)
						.addComponent(btnCandidatoCancelar))
					.addGap(70))
		);
		
		JLabel jlNomeCandidato = new JLabel("Nome:");
		jlNomeCandidato.setToolTipText(" ");
		
		txtNomeCandidato = new JTextField();
		txtNomeCandidato.setColumns(10);
		
		JLabel jlIdCandidatos = new JLabel("Código Candidato:");
		
		txtIdCandidatos = new JTextField();
		txtIdCandidatos.setColumns(10);
		
		JLabel jlPartidoCandidato = new JLabel("Partido:");
		
		txtPartidoCandidato = new JTextField();
		txtPartidoCandidato.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ficha Limpa:");
		
		txtFichaLimpaCandidato = new JTextField();
		txtFichaLimpaCandidato.setColumns(10);
		GroupLayout gl_jpCadastroCandidatos = new GroupLayout(jpCadastroCandidatos);
		gl_jpCadastroCandidatos.setHorizontalGroup(
			gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFichaLimpaCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
							.addComponent(jlIdCandidatos, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdCandidatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
							.addComponent(jlNomeCandidato, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeCandidato, GroupLayout.PREFERRED_SIZE, 805, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
							.addComponent(jlPartidoCandidato, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPartidoCandidato, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_jpCadastroCandidatos.setVerticalGroup(
			gl_jpCadastroCandidatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidatos.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlIdCandidatos)
						.addComponent(txtIdCandidatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlNomeCandidato)
						.addComponent(txtNomeCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPartidoCandidato)
						.addComponent(txtPartidoCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_jpCadastroCandidatos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtFichaLimpaCandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		jpCadastroCandidatos.setLayout(gl_jpCadastroCandidatos);
		getContentPane().setLayout(groupLayout);

	}

	public void setCandidatoUI(Candidato candidato) {
		this.candidato = candidato;	
		preencheFormulario();
	}
	
	private void preencheFormulario() {
		if(candidato != null) {
			txtIdCandidatos.setText(Integer.toString(candidato.getIdcandidatos()));
			txtNomeCandidato.setText(candidato.getNome());
			txtPartidoCandidato.setText(candidato.getPartido());
			txtFichaLimpaCandidato.setText(candidato.getFichaLimpa());
		}
	}


	
}
