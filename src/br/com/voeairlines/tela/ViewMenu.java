package br.com.voeairlines.tela;

import java.awt.EventQueue;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void TelaMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu window = new ViewMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 590, 495);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 573, 434);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 573, 434);
		panel.add(tabbedPane);
		
		JPanel navegar = new JPanel();
		tabbedPane.addTab("Dados da Aeronave", null, navegar, null);
		navegar.setLayout(null);
		
		JPanel conta = new JPanel();
		conta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados da Conta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		tabbedPane.addTab("Usuário", null, conta, null);
		conta.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSemFuno = new JMenu("Cadastrar");
		menuBar.add(mnSemFuno);
		
		JMenuItem cadas_tipo = new JMenuItem("Cadastrar Tipo de Aeronave");
		cadas_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroTipoAeronava tipoCadastro = new ViewCadastroTipoAeronava();
				tipoCadastro.TelaCadastroTipo();
			}
		});
		cadas_tipo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		mnSemFuno.add(cadas_tipo);
		
		JMenuItem cadas_aeronave = new JMenuItem("Cadastrar Aeronave");
		cadas_aeronave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abir tela de cadastro de aeronave
				ViewCadastroAeronave telaCadastroAeronave = new ViewCadastroAeronave();
				telaCadastroAeronave.TelaCadastroAeronave();
			}
		});
		cadas_aeronave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnSemFuno.add(cadas_aeronave);
		
	}

}
