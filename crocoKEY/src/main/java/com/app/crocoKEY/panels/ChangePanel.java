package com.app.crocoKEY.panels;

	import javax.swing.*;
	public class ChangePanel {
		public ChangePanel(JPanel contenedor, JPanel contenido) {
			contenedor.removeAll();
			contenedor.revalidate();
			contenedor.repaint();
			
			contenedor.add(contenido);
			contenedor.revalidate();
			contenedor.repaint();
		}
	}
