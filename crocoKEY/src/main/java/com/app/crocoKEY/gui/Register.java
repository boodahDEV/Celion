package com.app.crocoKEY.gui;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

public class Register extends Thread{
	public Document dataRegister;
	public String nombre, apellido, correo, pass;
	
	
	public Register(String nombre ,String apellido,String correo, String pass) {
		this.nombre = nombre;this.apellido = apellido;this.correo = correo;this.pass = pass;
		dataRegister = new Document("_id", new ObjectId());
	}
	
	public void run() {
		dataRegister.append("Nombre", nombre.trim())
		.append("Apellido", apellido.trim())
		.append("Correo", correo)
		.append("pass", BCrypt.hashpw("Texto",BCrypt.gensalt()));
				
		System.out.println(dataRegister.toJson());
	}
}
