import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Candidato extends JPanel {

	/**
	 * Create the panel.
	 */
	public Candidato() {
		
		JLabel lblNome = new JLabel("Nome Candidato:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<?> comboBoxNome = new JComboBox();
		comboBoxNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxNome.setModel(new DefaultComboBoxModel(new String[] {"CIRO GOMES", "FELIPE D AVILA", "JAIR BOLSONARO", "LEO PERICLES", "LULA", "SIMONE TEBET", "SOFIA MANZANO", "VERA", "CONSTITUINTE EYMAEL", "SORAYA THRONICKE"}));
		
		JLabel lblNewLabelCabeçalho = new JLabel("Desempenho Campanha Eleitoral 2022");
		lblNewLabelCabeçalho.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JRadioButton rdbtnNewRadioButtonFichaLimpa = new JRadioButton("SIM");
		rdbtnNewRadioButtonFichaLimpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabelFichaLimpa = new JLabel("Ficha Limpa?");
		lblNewLabelFichaLimpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdbtnNewRadioButton_1FichaLimpa = new JRadioButton("NÃO");
		rdbtnNewRadioButton_1FichaLimpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Preencha abaixo as informações dos candidatos ao cargo de Presidente.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<?> comboBoxPartido = new JComboBox();
		comboBoxPartido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxPartido.setModel(new DefaultComboBoxModel(new String[] {"PDT - PARTIDO DEMOCRÁTICO TRABALHISTA", "NOVO - NOVO", "PL - PELO BEM DO BRASIL", "UP - UNIDADE POPULAR", "PT - PARTIDO DOS TRABALHADORES", "MDB - MOVIMENTO DEMOCRÁTICO BRASILEIRO", "PCB - PARTIDO COMUNISTA BRASILEIRO", "PSTU - PARTIDO SOCIALISTA DOS TRABALHADORES UNIFICADO", "DC - DEMOCRACIA CRISTÃ", "UNIÃO - UNIÃO"}));
		
		JLabel lblPartidoPartido = new JLabel("Partido:");
		lblPartidoPartido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButtonSalvarCandidatos = new JButton("Salvar");
		btnNewButtonSalvarCandidatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(277)
							.addComponent(lblNewLabelCabeçalho, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnNewRadioButtonFichaLimpa, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_1FichaLimpa, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabelFichaLimpa, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxPartido, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxNome, Alignment.LEADING, 0, 603, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPartidoPartido, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(236, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(719, Short.MAX_VALUE)
					.addComponent(btnNewButtonSalvarCandidatos, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(161))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabelCabeçalho, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxNome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNewLabelFichaLimpa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButtonFichaLimpa)
						.addComponent(rdbtnNewRadioButton_1FichaLimpa))
					.addGap(18)
					.addComponent(lblPartidoPartido, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(comboBoxPartido, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(btnNewButtonSalvarCandidatos)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
