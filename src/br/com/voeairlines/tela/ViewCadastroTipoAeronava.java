package br.com.voeairlines.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.com.voeairlines.controller.CadastroTipoAeronaveController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroTipoAeronava {

	private JFrame frame;
	private JTextField textFieldTipo;
	private JTextField textFieldDescricao;
	private final CadastroTipoAeronaveController controller;
	
	/**
	 * Launch the application.
	 */
	public static void TelaCadastroTipo(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroTipoAeronava window = new ViewCadastroTipoAeronava();
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
	public ViewCadastroTipoAeronava() {
		initialize();
		controller = new CadastroTipoAeronaveController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 590, 495);
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
		
		JLabel tipo_aeronave = new JLabel("Cadastro \r\nTipo de Aeronave");
		tipo_aeronave.setHorizontalAlignment(SwingConstants.CENTER);
		tipo_aeronave.setFont(new Font("Tahoma", Font.BOLD, 15));
		tipo_aeronave.setBounds(10, 11, 202, 35);
		formulario.add(tipo_aeronave);
		
		//nome da caixar
		JLabel labelTipo = new JLabel("Tipo de Aeronave");
		labelTipo.setBounds(32, 68, 92, 14);
		formulario.add(labelTipo);
		
		//caixar para digitar
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(32, 82, 156, 20);
		formulario.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		//nome da caixar
		JLabel labelDes = new JLabel("Descrição");
		labelDes.setBounds(32, 113, 46, 14);
		formulario.add(labelDes);
		
		//caixar para digitar
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(32, 127, 156, 50);
		formulario.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);

		//botao para salvar
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//passar negocio de conexão para o controller
				controller.salvarTipoAeronave();
				
			}
		});
		salvar.setBounds(65, 237, 89, 23);
		formulario.add(salvar);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpar campos
				textFieldTipo.setText("");
				textFieldDescricao.setText("");
			}
		});
		limpar.setBounds(65, 271, 89, 23);
		formulario.add(limpar);	
	}

	//acesso as caixas
	public JTextField getTextFieldTipo() {
		return textFieldTipo;
	}

	public void setTextFieldTipo(JTextField textFieldTipo) {
		this.textFieldTipo = textFieldTipo;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public void setTextFieldDescricao(JTextField textFieldDescricao) {
		this.textFieldDescricao = textFieldDescricao;
	}
	
	
}
