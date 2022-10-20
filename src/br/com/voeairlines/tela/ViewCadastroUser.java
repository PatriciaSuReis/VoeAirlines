package br.com.voeairlines.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import br.com.voeairlines.controller.CadastroUserController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroUser {

	private JFrame frame;
	private JTextField textFieldNome;
	private JPasswordField passwordFieldSenha;
	private final CadastroUserController controller;

	/**
	 * Launch the application.
	 */
	public static void TelaCadastro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroUser window = new ViewCadastroUser();
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
	public ViewCadastroUser() {
		initialize();
		controller = new CadastroUserController(this);
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 497, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(139, 40, 218, 298);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 198, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel_1);
		
		//caixar para digitar
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 71, 198, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(10, 102, 46, 14);
		panel.add(lblNewLabel_2);
		
		//caixar para digitar
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(10, 119, 198, 20);
		panel.add(passwordFieldSenha);
		
		JButton btnNewButton = new JButton("Salvar");
		//ação do botão
		btnNewButton.addActionListener(new ActionListener() {
			//sobrepor
			@Override 
			public void actionPerformed(ActionEvent e) {
				
				//validação de dados digitados
				if(textFieldNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome obrigatório!");
					textFieldNome.requestFocus();
				}
				else if(passwordFieldSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Senha obrigatória!");
					passwordFieldSenha.requestFocus();
				} 
				else {
				//passar negocio de conexão para o controller
					controller.salvarUsuario();
				}
							
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(64, 191, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpar campos
				textFieldNome.setText("");
				passwordFieldSenha.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(64, 225, 89, 23);
		panel.add(btnNewButton_1);
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JPasswordField getPasswordFieldSenha() {
		return passwordFieldSenha;
	}

	public void setPasswordFieldSenha(JPasswordField passwordFieldSenha) {
		this.passwordFieldSenha = passwordFieldSenha;
	}
	
	

}
