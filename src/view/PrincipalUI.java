package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class PrincipalUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Desempenho dos Candidatos à Presidência da República");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 724);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastros = new JMenu("Candidatos");
		jmCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrosUI cadCandidatos = new CadastrosUI();
				cadCandidatos.setVisible(true);
				contentPane.add(cadCandidatos, 0);
			}
		});
		jbPrincipal.add(jmCadastros);
		
		JMenu jmPesquisa = new JMenu("Pesquisas");
		jmPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisas pesquisa = new Pesquisas();
				pesquisa.setVisible(true);
				contentPane.add(pesquisa, 0);
			}
		});
		jbPrincipal.add(jmPesquisa);
		
		JMenu jmVotos = new JMenu("Votos");
		jmVotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votos voto = new Votos();
				voto.setVisible(true);
				contentPane.add(voto,0);
			}
		});
		jbPrincipal.add(jmVotos);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultasCandidatos = new JMenuItem("Candidatos");
		jmiConsultasCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCandidatosUI consultaCandUI = new ConsultaCandidatosUI();
				consultaCandUI.setVisible(true);
				contentPane.add(consultaCandUI, 0);
			}
		});
		jmConsultas.add(jmiConsultasCandidatos);
		
		JMenuItem jmiConsultasPesquisas = new JMenuItem("Pesquisas");
		jmConsultas.add(jmiConsultasPesquisas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 426, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 253, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
