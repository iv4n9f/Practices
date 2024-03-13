package com.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.*;

public class LoginPanel extends JFrame {
	
	int xMouse, yMouse;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
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
	public LoginPanel() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(255, 255, 255));
		bg.setBounds(0, 0, 1263, 497);
		contentPane.add(bg);
		bg.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE EMPRESA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(995, 161, 268, 62);
		bg.add(lblNewLabel);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBackground(Color.WHITE);
		logo.setIcon(new ImageIcon(LoginPanel.class.getResource("/com/images/logo.png")));
		logo.setBounds(995, 0, 268, 150);
		bg.add(logo);
		
		JLabel cityBg = new JLabel("");
		cityBg.setVerticalAlignment(SwingConstants.BOTTOM);
		cityBg.setHorizontalAlignment(SwingConstants.CENTER);
		cityBg.setIcon(new ImageIcon(LoginPanel.class.getResource("/com/images/city.png")));
		cityBg.setBounds(995, 0, 268, 497);
		bg.add(cityBg);
		
		JLabel logoIcon = new JLabel("LOGO");
		logoIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/com/images/favicon.png")));
		logoIcon.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setBounds(10, 25, 101, 62);
		bg.add(logoIcon);
		
		JLabel title = new JLabel("INICIAR SESION");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Roboto Black", Font.BOLD, 14));
		title.setBounds(10, 82, 600, 76);
		bg.add(title);
		
		JLabel usernameTitle = new JLabel("USUARIO");
		usernameTitle.setFont(new Font("Roboto Black", Font.BOLD, 11));
		usernameTitle.setBounds(70, 169, 169, 46);
		bg.add(usernameTitle);
		
		JSeparator usernameSep = new JSeparator();
		usernameSep.setForeground(Color.BLACK);
		usernameSep.setBounds(70, 259, 892, 29);
		bg.add(usernameSep);
		
		usernameInput = new JTextField();
		usernameInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (usernameInput.getText().equals("Ingrese su nombre de usuario")) {
					usernameInput.setText("");
					usernameInput.setForeground(Color.BLACK);
				} if (String.valueOf(passwordInput.getPassword()).isEmpty()){
					passwordInput.setText("********");
					passwordInput.setForeground(Color.LIGHT_GRAY);
				}				
			}
		});
		usernameInput.setBorder(null);
		usernameInput.setForeground(Color.LIGHT_GRAY);
		usernameInput.setFont(new Font("Roboto Black", Font.BOLD, 11));
		usernameInput.setText("Ingrese su nombre de usuario");
		usernameInput.setBounds(70, 215, 892, 34);
		bg.add(usernameInput);
		usernameInput.setColumns(10);
		
		JLabel passwordTitle = new JLabel("CONTRASEÑA");
		passwordTitle.setForeground(Color.BLACK);
		passwordTitle.setFont(new Font("Roboto Black", Font.BOLD, 11));
		passwordTitle.setBounds(70, 292, 169, 46);
		bg.add(passwordTitle);
		
		JSeparator passwordSep = new JSeparator();
		passwordSep.setForeground(Color.BLACK);
		passwordSep.setBounds(70, 382, 892, 29);
		bg.add(passwordSep);
		
		passwordInput = new JPasswordField();
		passwordInput.setBorder(null);
		passwordInput.setForeground(Color.LIGHT_GRAY);
		passwordInput.setText("********");
		passwordInput.setFont(new Font("Roboto Black", Font.BOLD, 11));
		passwordInput.setToolTipText("");
		passwordInput.setEchoChar('*');
		passwordInput.setBounds(70, 337, 892, 34);
		bg.add(passwordInput);
		passwordInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(passwordInput.getPassword()).equals("********")) {
					passwordInput.setText("");
					passwordInput.setForeground(Color.BLACK);
				} if (usernameInput.getText().isEmpty()){
					usernameInput.setText("Ingrese su nombre de usuario");
					usernameInput.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		
		JPanel loginButton = new JPanel();
		
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setBackground(new Color(0, 134, 190));
		loginButton.setBounds(70, 408, 275, 56);
		bg.add(loginButton);
		loginButton.setLayout(null);
		
		Label loginButtonText = new Label("ENTRAR");
		loginButtonText.setBounds(0, 0, 275, 56);
		loginButtonText.setForeground(Color.WHITE);
		loginButtonText.setFont(new Font("Roboto Black", Font.BOLD, 16));
		loginButtonText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButtonText.setAlignment(Label.CENTER);
		loginButton.add(loginButtonText);
		loginButtonText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButtonText.setBackground(new Color(0, 156, 223));
			}
			public void mouseExited(MouseEvent e) {
				loginButtonText.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			    javax.swing.JOptionPane.showMessageDialog(null, "Intento de login con los datos: \nUsuario:" + usernameInput.getText() + "\nContraseña:" + String.valueOf(passwordInput.getPassword()), "LOGIN", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		});

		
		JPanel bar = new JPanel();
		bar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
		    public void mouseDragged(MouseEvent e) {
		        int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        LoginPanel.this.setLocation(x - xMouse, y - yMouse);
		    }
		});
		bar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		bar.setBackground(Color.WHITE);
		bar.setBounds(0, 0, 1263, 23);
		bg.add(bar);
		bar.setLayout(null);
		
		JLabel barClose = new JLabel("X");
		barClose.setOpaque(true);
		barClose.setBackground(Color.WHITE);
		barClose.setForeground(Color.RED);
		barClose.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        System.exit(0);
		    }
		    
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        barClose.setBackground(Color.RED);
		        barClose.setForeground(Color.white);
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		        barClose.setBackground(Color.WHITE);
		        barClose.setForeground(Color.RED);
		    }
		});
		barClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		barClose.setHorizontalAlignment(SwingConstants.CENTER);
		barClose.setBounds(0, 0, 23, 23);
		bar.add(barClose);
	}
}
