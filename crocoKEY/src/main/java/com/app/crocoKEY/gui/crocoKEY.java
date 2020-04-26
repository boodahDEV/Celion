package com.app.crocoKEY.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import com.app.crocoKEY.panels.*;

import javax.swing.SwingConstants;
import java.awt.Font;

public class crocoKEY extends JFrame {

	private JPanel contentPane;
	public JPanel titlebar, dashboard,centerPanel;
	public JButton exit;
	public int x,y,xx,yy;


	//CONSTRUCTOR
	public crocoKEY(String titulo, String ver) {
		super(""+titulo + " - "+ver);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titlebar = new JPanel();
		titlebar.setBackground(new Color(255, 255, 255));
		titlebar.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(60, 179, 113)));
		titlebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent a) {
				x = a.getX();
				y = a.getY();
			}
		});
		titlebar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent b) {
				xx = b.getXOnScreen();
				yy = b.getYOnScreen();
				
				setLocation(xx-x, yy-y);
			}
		});
		
		dashboard = new JPanel();
		dashboard.setBackground(new Color(60, 179, 113));
		dashboard.setBounds(0, 0, 200, 375);
		contentPane.add(dashboard);
		dashboard.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/logoICON.png")));
		logo.setBounds(23, 23, 156, 156);
		dashboard.add(logo);
		
		JLabel title = new JLabel(titulo);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Consolas", Font.BOLD, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(23, 191, 156, 28);
		dashboard.add(title);
		
		JLabel version = new JLabel(ver);
		version.setHorizontalAlignment(SwingConstants.LEFT);
		version.setForeground(Color.WHITE);
		version.setFont(new Font("Consolas", Font.BOLD, 15));
		version.setBounds(3, 356, 81, 19);
		dashboard.add(version);
		titlebar.setBounds(0, 0, 480, 30);
		contentPane.add(titlebar);
		titlebar.setLayout(null);
		
		exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/exit.png")));
		exit.setContentAreaFilled(false);
		exit.setFocusable(false);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBorderPainted(false);
		exit.setBounds(452, 3, 26, 26);
		titlebar.add(exit);
		
		//200, 30, 280, 345
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(60, 179, 113)));
		centerPanel.setBounds(200, 30, 280, 345);
		contentPane.add(centerPanel);
		centerPanel.setLayout(null);

		/**
		 * Load Login interface
		 * */
		new ChangePanel(centerPanel , new PanelLogin(centerPanel, getUI()));
		
	}
	
	public crocoKEY getUI() {
		return this;
	}
}
