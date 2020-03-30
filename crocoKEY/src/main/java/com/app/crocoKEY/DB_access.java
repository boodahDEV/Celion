package com.app.crocoKEY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB_access implements MongoAbstractMethods {

	public DB_access() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

//		try {
//			
//			MongoDatabase database = (MongoDatabase) MongoClients.create().getDatabase("T800");
//			
//			MongoCollection<Document> collection = database.getCollection("users");
////			collection.insertOne(new Document("test 1", "hehe 2")); //ESTE ES PARA INSERTAR UNO EN UNO
//			
////			List<Document> data = Arrays.asList(new Document("a","a"),new Document("b","b")); // ESTE ES PARA INSERTAR MUCHOS 
////			collection.insertMany(data);
//
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} // end catch

		try (com.mongodb.client.MongoClient mongoClient = MongoClients.create()) {
//            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
            getAllDatabase(mongoClient).forEach(db -> System.out.println(db.toJson()));
			
            MongoDatabase database = mongoClient.getDatabase("T800");
            	System.out.println("Conectado a "+database.getName()+" satisfactoriamente!");
            MongoCollection<Document> collection = database.getCollection("users");
            
            Document student = new Document("_id", new ObjectId());
            student.append("student_id", 10000d)
                   .append("class_id", 1d)
                   .append("scores","OK");
            
            collection.insertOne(student);
        }

	}// fin clase

	@Override
	public List<Document> getAllDatabase(MongoClient mongo) {
		// TODO Auto-generated method stub
		  List<Document> databases = mongo.listDatabases().into(new ArrayList<>());
		return databases;
	}

}// fin clase
