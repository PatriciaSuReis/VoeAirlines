package br.com.voeairlines.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import br.com.voeairlines.controller.LoginController;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class ViewLogin {

	private JFrame Jframe;
	private JTextField textUsuario;
	private JPasswordField pfSenha;
	//Final = depois de incializada o seu valor não poderá mais ser modificado
	private final LoginController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.Jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
		controller = new LoginController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Jframe = new JFrame();
		Jframe.setTitle("Login");
		Jframe.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLogin.class.getResource("/br/com/voeairlines/telaimagem/air-g7d59ca83f_1280.png")));
		Jframe.getContentPane().setBackground(new Color(128, 128, 128));
		Jframe.setResizable(false);
		Jframe.setBounds(100, 100, 718, 510);
		Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Jframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(379, 41, 302, 394);
		panel.setBackground(new Color(154, 192, 211));
		Jframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(44, 79, 82, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(44, 151, 82, 20);
		panel.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(44, 110, 215, 30);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(44, 182, 215, 30);
		panel.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ação vai para o controler login
				try {
					controller.autenticar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBounds(93, 263, 116, 31);
		panel.add(btnEntrar);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abir tela de login
				ViewCadastroUser telaCadastro = new ViewCadastroUser();
				telaCadastro.TelaCadastro();
			}
		});
		
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.setBounds(93, 305, 116, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(44, 24, 215, 44);
		panel.add(lblNewLabel_2);
		
		JLabel fundo = new JLabel("Fundo");
		fundo.setBounds(0, 0, 702, 471);
		fundo.setIcon(new ImageIcon(ViewLogin.class.getResource("/br/com/voeairlines/telaimagem/flyer-ge8cf00881_1920.jpg")));
		Jframe.getContentPane().add(fundo);
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JPasswordField getPfSenha() {
		return pfSenha;
	}

	public void setPfSenha(JPasswordField pfSenha) {
		this.pfSenha = pfSenha;
	}
	
	
}
