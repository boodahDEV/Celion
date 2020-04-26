package com.app.crocoKEY.gui;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

import com.app.crocoKEY.db.DB_access;

public class Register extends Thread{
	public Document dataRegister;
	public String nombre, apellido, correo, pass;
	private long t0;
	private long t1;
	public String result;
	
	public Register(String nombre ,String apellido,String correo, String pass) {
		this.nombre = nombre;this.apellido = apellido;this.correo = correo;this.pass = pass;
		dataRegister = new Document("_id", new ObjectId());
	}
	
	public void run() {
	    t0 = System.currentTimeMillis();
	    try {
	    	dataRegister.append("Nombre", nombre.trim())
	    	.append("Apellido", apellido.trim())
	    	.append("Username", (nombre.trim().charAt(0)+apellido.trim()).toLowerCase()) //La forma con la que se obtiene el username se corrige a minisculas
	    	.append("Correo", correo)
	    	.append("pass", BCrypt.hashpw(pass,BCrypt.gensalt()) );
			DB_access db = new DB_access();
			result = db.setDataInCollections("users", dataRegister, db.getDatabase("T800"));
			db = null;
			System.gc();
	    }catch(Exception e) {
	    	System.out.println("No connected!");
	    }finally {
	       t1 = System.currentTimeMillis();
	    }				
	}
	
	public long getTimeExcecutingThread() { //Retorna el tiempo en la que el hilo se ejecuto.
		return t1- t0;
	}
	
	public String getStatusDB() {
		return result;
	}
}
