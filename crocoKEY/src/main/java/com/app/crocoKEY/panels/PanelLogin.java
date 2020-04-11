package com.app.crocoKEY.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.app.crocoKEY.gui.MaterialButton;
import com.app.crocoKEY.gui.crocoKEY;

public class PanelLogin extends JPanel {
	private JTextField jtfuser;
	private JPasswordField jpfpass;
	public crocoKEY GUI;
	/**
	 * Create the panel.
	 */
	public PanelLogin(JPanel centerPanel, crocoKEY GUIMain) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(280, 345);this.GUI = GUIMain;
		
		jtfuser = new JTextField("");
		jtfuser.setForeground(new Color(69, 69, 69));
		jtfuser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
//		jtfuser.setFocusable(false);
		jtfuser.setHorizontalAlignment(SwingConstants.LEFT);
		jtfuser.setFont(new Font("Consolas", Font.PLAIN, 15));
		jtfuser.setBounds(64, 90, 173, 30);
		add(jtfuser);
		jtfuser.setColumns(10);
		
		jpfpass = new JPasswordField("");
		jpfpass.setForeground(new Color(69, 69, 69));
//		jpfpass.setFocusable(false);
		jpfpass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jpfpass.setFont(new Font("Consolas", Font.PLAIN, 15));
		jpfpass.setEchoChar('*');
		jpfpass.setBounds(64, 151, 173, 30);
		add(jpfpass);
		
		JLabel iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/mail.png")));
		iconUser.setBounds(35, 86, 24, 30);
		add(iconUser);
		
		JLabel iconPass = new JLabel("");
		iconPass.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/pass.png")));
		iconPass.setBounds(35, 146, 24, 30);
		add(iconPass);
		
		MaterialButton jbiniciar = new MaterialButton();
		jbiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//llamar a la funcion de login
			}
		});
		jbiniciar.setColorHover(new Color(60, 179, 113));
		jbiniciar.setColorNormal(new Color(60, 179, 113));
		jbiniciar.setColorPressed(new Color(60, 179, 113));
		jbiniciar.setText("Iniciar");
		jbiniciar.setBounds(90, 220, 106, 35);
		add(jbiniciar);
		
		JLabel tituloInit = new JLabel("Iniciar sesion");
		tituloInit.setForeground(new Color(60, 179, 113));
		tituloInit.setHorizontalAlignment(SwingConstants.CENTER);
		tituloInit.setFont(new Font("Consolas", Font.BOLD, 20));
		tituloInit.setBounds(52, 28, 173, 30);
		add(tituloInit);
		
		JLabel register = new JLabel("No tienes una cuenta? click aqui");
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * Load Register interface
				 * */
				new ChangePanel(centerPanel, new PanelRegister(centerPanel, GUIMain));
				/*
				 * Load Register interface
				 * */
			}
		});
		register.setHorizontalAlignment(SwingConstants.CENTER);
		register.setForeground(new Color(60, 179, 113));
		register.setFont(new Font("Consolas", Font.BOLD, 12));
		register.setBounds(25, 265, 231, 22);
		add(register);
	}

}
