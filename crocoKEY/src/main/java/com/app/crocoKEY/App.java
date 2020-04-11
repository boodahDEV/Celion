package com.app.crocoKEY;

import java.awt.EventQueue;

import com.app.crocoKEY.db.DB_access;
import com.app.crocoKEY.gui.crocoKEY;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome!");
//		DB_access db = new DB_access();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crocoKEY frame = new crocoKEY("crocoKEY","v0.20.3");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
