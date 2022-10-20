package br.com.voeairlines.tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewCadastroAeronave {
	
	private JFrame frame;
	private JTextField tipo;
	private JTextField fabricante;
	private JTextField textField;
	private JTextField cod;

	/**
	 * Launch the application.
	 */
	public static void TelaCadastroAeronave() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroAeronave window = new ViewCadastroAeronave();
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
	public ViewCadastroAeronave() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 491, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel fundo = new JPanel();
		fundo.setBackground(new Color(128, 128, 128));
		frame.getContentPane().add(fundo, BorderLayout.CENTER);
		fundo.setLayout(null);
		
		JPanel formulario = new JPanel();
		formulario.setBackground(new Color(192, 192, 192));
		formulario.setBounds(128, 24, 222, 328);
		fundo.add(formulario);
		formulario.setLayout(null);
		
		JLabel tipo_aeronave = new JLabel("Cadastro de Aeronave");
		tipo_aeronave.setHorizontalAlignment(SwingConstants.CENTER);
		tipo_aeronave.setFont(new Font("Tahoma", Font.BOLD, 15));
		tipo_aeronave.setBounds(10, 11, 202, 35);
		formulario.add(tipo_aeronave);
		
		tipo = new JTextField();
		tipo.setBounds(32, 69, 156, 20);
		formulario.add(tipo);
		tipo.setColumns(10);
		
		/*
		JLabel aeronave = new JLabel("Tipo de Aeronave");
		aeronave.setBounds(32, 57, 156, 14);
		formulario.add(aeronave);*/
		
		JLabel fabrica = new JLabel("Fabricante");
		fabrica.setBounds(32, 100, 156, 14);
		formulario.add(fabrica);
		
		fabricante = new JTextField();
		fabricante.setBounds(32, 113, 156, 20);
		formulario.add(fabricante);
		fabricante.setColumns(10);
		
		//campo
		JLabel modelo = new JLabel("Modelo\r\n");
		modelo.setBounds(32, 138, 46, 14);
		formulario.add(modelo);
		
		textField = new JTextField();
		textField.setBounds(32, 150, 156, 20);
		formulario.add(textField);
		textField.setColumns(10);
		
		//campo
		JLabel codigo = new JLabel("Codigo");
		codigo.setBounds(32, 173, 46, 14);
		formulario.add(codigo);
		
		cod = new JTextField();
		cod.setBounds(32, 187, 156, 20);
		formulario.add(cod);
		cod.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.setBounds(65, 237, 89, 23);
		formulario.add(salvar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setBounds(65, 271, 89, 23);
		formulario.add(limpar);
	
	}

}
