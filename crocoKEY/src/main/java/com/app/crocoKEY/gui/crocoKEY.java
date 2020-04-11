package com.app.crocoKEY.gui;

import java.awt.EventQueue;

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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class crocoKEY extends JFrame {

	private JPanel contentPane;
	public int x,y,xx,yy;
	private JTextField jtfuser;
	private JPasswordField jpfpass;

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
		
		JPanel titlebar = new JPanel();
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
		
		JPanel dashboard = new JPanel();
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
		version.setBounds(3, 356, 62, 19);
		dashboard.add(version);
		titlebar.setBounds(0, 0, 480, 30);
		contentPane.add(titlebar);
		titlebar.setLayout(null);
		
		JButton exit = new JButton("");
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
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(60, 179, 113)));
		centerPanel.setBounds(200, 30, 280, 345);
		contentPane.add(centerPanel);
		centerPanel.setLayout(null);
		
		jtfuser = new JTextField("");
		jtfuser.setForeground(new Color(69, 69, 69));
		jtfuser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
//		jtfuser.setFocusable(false);
		jtfuser.setHorizontalAlignment(SwingConstants.LEFT);
		jtfuser.setFont(new Font("Consolas", Font.PLAIN, 15));
		jtfuser.setBounds(79, 90, 150, 30);
		centerPanel.add(jtfuser);
		jtfuser.setColumns(10);
		
		jpfpass = new JPasswordField("");
		jpfpass.setForeground(new Color(69, 69, 69));
//		jpfpass.setFocusable(false);
		jpfpass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jpfpass.setFont(new Font("Consolas", Font.PLAIN, 15));
		jpfpass.setEchoChar('*');
		jpfpass.setBounds(79, 151, 150, 30);
		centerPanel.add(jpfpass);
		
		JLabel iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/user.png")));
		iconUser.setBounds(45, 86, 30, 30);
		centerPanel.add(iconUser);
		
		JLabel iconPass = new JLabel("");
		iconPass.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/pass.png")));
		iconPass.setBounds(50, 146, 24, 30);
		centerPanel.add(iconPass);
		
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
		jbiniciar.setBounds(97, 216, 106, 35);
		centerPanel.add(jbiniciar);
		
		JLabel tituloInit = new JLabel("Iniciar sesion");
		tituloInit.setForeground(new Color(60, 179, 113));
		tituloInit.setHorizontalAlignment(SwingConstants.CENTER);
		tituloInit.setFont(new Font("Consolas", Font.BOLD, 20));
		tituloInit.setBounds(30, 30, 237, 30);
		centerPanel.add(tituloInit);
	}
}
