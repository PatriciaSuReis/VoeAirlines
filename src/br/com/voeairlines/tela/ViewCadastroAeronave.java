package br.com.voeairlines.tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.voeairlines.controller.CadastroAeronaveController;
import br.com.voeairlines.controller.CadastroTipoAeronaveController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroAeronave {
	
	private JFrame frame;
	private JTextField textFieldTipo;
	private JTextField textFieldFabricante;
	private JTextField textFieldModelo;
	private JTextField textFieldCodigo;
	private final CadastroAeronaveController controller;

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
		controller = new CadastroAeronaveController(this);
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
		
		JLabel aeronavaTitle = new JLabel("Cadastro de Aeronave");
		aeronavaTitle.setHorizontalAlignment(SwingConstants.CENTER);
		aeronavaTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		aeronavaTitle.setBounds(10, 11, 202, 35);
		formulario.add(aeronavaTitle);
		
		//campo
		JLabel tipoLabel = new JLabel("Tipo da aeronave");
		tipoLabel.setBounds(32, 57, 156, 14);
		formulario.add(tipoLabel);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(32, 71, 156, 20);
		formulario.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		//campo
		JLabel fabricaLabel = new JLabel("Fabricante");
		fabricaLabel.setBounds(32, 100, 156, 14);
		formulario.add(fabricaLabel);
		
		textFieldFabricante = new JTextField();
		textFieldFabricante.setBounds(32, 113, 156, 20);
		formulario.add(textFieldFabricante);
		textFieldFabricante.setColumns(10);
		
		//campo
		JLabel modeloLabel = new JLabel("Modelo\r\n");
		modeloLabel.setBounds(32, 138, 46, 14);
		formulario.add(modeloLabel);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(32, 150, 156, 20);
		formulario.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		//campo
		JLabel codigoLabel = new JLabel("Codigo");
		codigoLabel.setBounds(32, 173, 46, 14);
		formulario.add(codigoLabel);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(32, 187, 156, 20);
		formulario.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//validação
				if(textFieldTipo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tipo de aeronave obrigatório!");
					textFieldTipo.requestFocus();
				}
				else if(textFieldFabricante.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fabricante obrigatória!");
					textFieldFabricante.requestFocus();
				} 
				else if(textFieldModelo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Modelo obrigatório!");
					textFieldModelo.requestFocus();
				} 
				else if(textFieldCodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Código obrigatória!");
					textFieldCodigo.requestFocus();
				}
				else {
				//passar negocio de conexão para o controller
					controller.salvarAeronave();
				}
				
			}
		});
		salvar.setBounds(65, 237, 89, 23);
		formulario.add(salvar);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpar campos
				textFieldTipo.setText("");
				textFieldFabricante.setText("");
				textFieldModelo.setText("");
				textFieldCodigo.setText("");
				
			}
		});
		limpar.setBounds(65, 271, 89, 23);
		formulario.add(limpar);
	}
	

	public JTextField getTextFieldTipo() {
		return textFieldTipo;
	}

	public void setTextFieldTipo(JTextField textFieldTipo) {
		this.textFieldTipo = textFieldTipo;
	}

	public JTextField getTextFieldFabricante() {
		return textFieldFabricante;
	}

	public void setTextFieldFabricante(JTextField textFieldFabricante) {
		this.textFieldFabricante = textFieldFabricante;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public void setTextFieldModelo(JTextField textFieldModelo) {
		this.textFieldModelo = textFieldModelo;
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(JTextField textFieldCodigo) {
		this.textFieldCodigo = textFieldCodigo;
	}
	
}
