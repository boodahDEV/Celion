package com.app.crocoKEY.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class crocoKEY extends JFrame {

	private JPanel contentPane, norte, sur, centro;
	private JLabel jlTitleLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crocoKEY frame = new crocoKEY();
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
	public crocoKEY() {
		setTitle("crocoKEY_GUI 0.20.01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 450);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 0, 0)));
		setContentPane(contentPane);

		/* Instancia de paneles */
		norte = new JPanel();
		norte.setLayout(null);
		norte.setBounds(3, 3, 290, 60);
		norte.setBorder(new MatteBorder(1, 1, 1, 1, new Color(69, 69, 69))); // Esto no va
		norte.setVisible(true);
		contentPane.add(norte);

		sur = new JPanel();
		sur.setLayout(null);
		sur.setBounds(3, 300, 290, 140);
		sur.setBorder(new MatteBorder(1, 1, 1, 1, new Color(69, 69, 69))); // Esto no va
		sur.setVisible(true);
		contentPane.add(sur);

		centro = new JPanel();
		centro.setLayout(null);
		centro.setBounds(3, 63, 290, 237);
		centro.setBorder(new MatteBorder(1, 1, 1, 1, new Color(69, 69, 69))); // Esto no va
		centro.setVisible(true);
		contentPane.add(centro);
		/* Instancia de paneles */

		generateAllViews();
		setLocationRelativeTo(null);
		setResizable(false);
	}// end

	public void generateAllViews() {
		generatePanelNort();

	}// end

	public void generatePanelNort() {
		jlTitleLogin = new JLabel("Inicio de sesion");
		jlTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		jlTitleLogin.setFont(new Font("Consolas", Font.BOLD, 20));
		jlTitleLogin.setBounds(12, 12, 266, 47);
		norte.add(jlTitleLogin);
		
		// agregar al panel norte
	}// end
}
