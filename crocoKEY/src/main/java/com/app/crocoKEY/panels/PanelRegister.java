package com.app.crocoKEY.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.app.crocoKEY.gui.MaterialButton;
import com.app.crocoKEY.gui.Register;
import com.app.crocoKEY.gui.crocoKEY;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelRegister extends JPanel {
	
	private JTextField jtfNombre;
	private JPasswordField jpfpass;
	private JTextField jtfApellido;
	private JPasswordField jpfPassConfirm;
	private JTextField jtfEmail;
	
	/**
	 * Create the panel.
	 */
	
	public PanelRegister(JPanel centerPanel, crocoKEY GUIMain) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(280, 345);
		
		jtfNombre = new JTextField("Nombre");
		jtfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) { 
				if (!Character.isLetter(evt.getKeyChar()) &&
		                !(evt.getKeyChar() == KeyEvent.VK_SPACE) &&
		                 !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					evt.consume();
				}
			}
		});
		jtfNombre.setForeground(new Color(158,158,158));
		jtfNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jtfNombre.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (jtfNombre.getText().equalsIgnoreCase("Nombre")) {
		        	jtfNombre.setText("");
		    		jtfNombre.setForeground(new Color(69,69,69));

		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (jtfNombre.getText().isEmpty()) {
		    		jtfNombre.setForeground(new Color(158,158,158));
		        	jtfNombre.setText("Nombre");
		        	
		        }
		    }
		    });
		
		JLabel tituloInit = new JLabel("Registro");
		tituloInit.setForeground(new Color(60, 179, 113));
		tituloInit.setHorizontalAlignment(SwingConstants.CENTER);
		tituloInit.setFont(new Font("Consolas", Font.BOLD, 20));
		tituloInit.setBounds(52, 0, 173, 30);
		this.add(tituloInit);
		
		JLabel iconNombre = new JLabel("");
		iconNombre.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/user.png")));
		iconNombre.setBounds(30, 40, 30, 30);
		this.add(iconNombre);
		jtfNombre.setHorizontalAlignment(SwingConstants.LEFT);
		jtfNombre.setFont(new Font("Consolas", Font.PLAIN, 15));
		jtfNombre.setBounds(64, 45, 173, 25);
		this.add(jtfNombre);
		jtfNombre.setColumns(10);
		
		jtfApellido = new JTextField("Apellido");
		jtfApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) { 
				if (!Character.isLetter(evt.getKeyChar()) &&
		                !(evt.getKeyChar() == KeyEvent.VK_SPACE) &&
		                 !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					evt.consume();
				}
			}
		});
		jtfApellido.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (jtfApellido.getText().equalsIgnoreCase("Apellido")) {
		        	jtfApellido.setText("");
		        	jtfApellido.setForeground(new Color(69,69,69));

		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (jtfApellido.getText().isEmpty()) {
		        	jtfApellido.setForeground(new Color(158,158,158));
		        	jtfApellido.setText("Apellido");
		        	
		        }
		    }
		    });
		
		JLabel iconApellido = new JLabel("");
		iconApellido.setBounds(30, 78, 30, 30);
		add(iconApellido);
		jtfApellido.setHorizontalAlignment(SwingConstants.LEFT);
    	jtfApellido.setForeground(new Color(158,158,158));
		jtfApellido.setFont(new Font("Consolas", Font.PLAIN, 15));
		jtfApellido.setColumns(10);
		jtfApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jtfApellido.setBounds(64, 82, 173, 25);
		add(jtfApellido);
		
		JLabel iconEmail = new JLabel("");
		iconEmail.setIcon(new ImageIcon(PanelRegister.class.getResource("/com/app/crocoKEY/assets/mail.png")));
		iconEmail.setBounds(35, 133, 24, 30);
		add(iconEmail);
		
		jtfEmail = new JTextField("Correo");
		jtfEmail.setHorizontalAlignment(SwingConstants.LEFT);
		jtfEmail.setForeground(new Color(158, 158, 158));
		jtfEmail.setFont(new Font("Consolas", Font.PLAIN, 15));
		jtfEmail.setColumns(10);
		jtfEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jtfEmail.setBounds(64, 137, 173, 25);
		jtfEmail.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (jtfEmail.getText().equalsIgnoreCase("Correo")) {
		        	jtfEmail.setText("");
		        	jtfEmail.setForeground(new Color(69,69,69));

		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (jtfEmail.getText().isEmpty()) {
		        	jtfEmail.setForeground(new Color(158,158,158));
		        	jtfEmail.setText("Correo");
		        	
		        }
		    }
		    });
		add(jtfEmail);
		
		JLabel iconPass = new JLabel("");
		iconPass.setIcon(new ImageIcon(crocoKEY.class.getResource("/com/app/crocoKEY/assets/pass.png")));
		iconPass.setBounds(35, 187, 24, 30);
		this.add(iconPass);
		
		jpfpass = new JPasswordField("");
		jpfpass.setForeground(new Color(69, 69, 69));
//		jpfpass.setFocusable(false);
		jpfpass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jpfpass.setFont(new Font("Consolas", Font.PLAIN, 15));
		jpfpass.setEchoChar('*');
		jpfpass.setBounds(64, 190, 173, 25);
		this.add(jpfpass);
		
		JLabel iconPassConfirm = new JLabel("");
		iconPassConfirm.setVisible(false);
		iconPassConfirm.setBounds(36, 229, 24, 30);
		add(iconPassConfirm);
		
		jpfPassConfirm = new JPasswordField("");
		jpfPassConfirm.setForeground(new Color(69, 69, 69));
		jpfPassConfirm.setFont(new Font("Consolas", Font.PLAIN, 15));
		jpfPassConfirm.setEchoChar('*');
		jpfPassConfirm.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(60, 179, 113)));
		jpfPassConfirm.setBounds(64, 230, 173, 25);
		jpfPassConfirm.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	char[] pass = jpfpass.getPassword();
		    	char[] passconfirm = jpfPassConfirm.getPassword();
		    	
		        if (String.valueOf(passconfirm).equalsIgnoreCase(String.valueOf(pass))) {
		    		iconPassConfirm.setIcon(new ImageIcon(PanelRegister.class.getResource("/com/app/crocoKEY/assets/valid.png")));
		    		iconPassConfirm.setVisible(true);
		    		jpfPassConfirm.setEnabled(false);
		    		jpfpass.setEnabled(false);

		        }else {
		    		iconPassConfirm.setIcon(new ImageIcon(PanelRegister.class.getResource("/com/app/crocoKEY/assets/cancel.png")));
		    		iconPassConfirm.setVisible(true);
		    		jpfPassConfirm.setText("");
		        }
		    }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			   	char[] pass = jpfpass.getPassword();
		    	char[] passconfirm = jpfPassConfirm.getPassword();
		    	
				if (String.valueOf(passconfirm).equalsIgnoreCase(String.valueOf(pass))) {
		    		iconPassConfirm.setIcon(new ImageIcon(PanelRegister.class.getResource("/com/app/crocoKEY/assets/valid.png")));
		    		iconPassConfirm.setVisible(true);
		    		jpfPassConfirm.setEnabled(false);
		    		jpfpass.setEnabled(false);
		        }
			}
		});
		add(jpfPassConfirm);
		
		MaterialButton jbRegistrar = new MaterialButton();
		jbRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//llamar a la funcion de registro
				if( !jtfNombre.getText().isEmpty() && !jtfApellido.getText().isEmpty()  && !jtfEmail.getText().isEmpty() && !jpfPassConfirm.isEnabled()) {
					char[] passconfirm = jpfPassConfirm.getPassword();
					Register rg = new Register(jtfNombre.getText(), jtfApellido.getText(), jtfEmail.getText(), String.valueOf(passconfirm));
					rg.start();
					while(rg.isAlive()) {
						//System.out.println("Time: "+rg.getTimeExcecutingThread());
					}
					System.out.println(rg.getStatusDB());
					//enviar mensaje de validacion de exito!
					new ChangePanel(centerPanel, new PanelLogin(centerPanel, GUIMain));
				}
			}
		});
		jbRegistrar.setColorHover(new Color(60, 179, 113));
		jbRegistrar.setColorNormal(new Color(60, 179, 113));
		jbRegistrar.setColorPressed(new Color(60, 179, 113));
		jbRegistrar.setText("Registrar");
		jbRegistrar.setBounds(95, 266, 106, 35);
		this.add(jbRegistrar);
		
		JLabel login = new JLabel("Ya tienes una cuenta? click aqui");
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * Load Register interface
				 * */
				
				new ChangePanel(centerPanel, new PanelLogin(centerPanel, GUIMain));
				/*
				 * Load Register interface
				 * */
			}
		});
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setForeground(new Color(60, 179, 113));
		login.setFont(new Font("Consolas", Font.BOLD, 12));
		login.setBounds(30, 311, 231, 22);
		this.add(login);
	}
}