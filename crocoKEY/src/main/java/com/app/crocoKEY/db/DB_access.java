package com.app.crocoKEY.db;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB_access implements MongoAbstractMethods {
	protected com.mongodb.client.MongoClient mongoClient;

	public DB_access() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE); // Esto elimina el log que genera el mongo driver de java

            getAllDatabase(getMongoClient()).forEach(db -> System.out.println(db.toJson()));

//			Document student = new Document("_id", new ObjectId());
//			student.append("student_name", "boodah3").append("class_id", 1d).append("scores", "Data with very instance");
//			setDataInCollections("users", student, getDatabase("T800"));
//			Document student2 = new Document("_id", new ObjectId());
//			student2.append("student_name", "boodah4").append("class_id", 1d).append("scores", "Data with very instance");
//			setDataInCollections("users", student2, getDatabase("T800"));

	}// fin clase

	@Override
	public List<Document> getAllDatabase(MongoClient mongo) {
		// TODO Auto-generated method stub
		List<Document> databases = mongo.listDatabases().into(new ArrayList<>());
		return databases;
	}

	@Override
	public String setDataInCollections(String nameCollection, Object dataDocument, Object database) {
		// TODO Auto-generated method stub
		if (database instanceof MongoDatabase) {
			if (dataDocument instanceof Document) {
				MongoCollection<Document> collectionSet = ((MongoDatabase) database).getCollection(nameCollection);
				collectionSet.insertOne((Document) dataDocument);
				System.out.println("Se creo el registro: " + ((Document) dataDocument).get("_id"));
				return "" + ((Document) dataDocument).get("_id");
			} else {
				// Validar el retorno de acuerdo al error, como por ejemplo cuando se mande
				// datos incorrectos
			}

		} else {
			// validar el retorno de acuerdo al error de el objeto de base de datos no sea
			// de tipo MongoDatabase.
		}
		return null;
	}

	@Override
	public MongoDatabase getDatabase(String nameDatabase) {
		// TODO Auto-generated method stub
		MongoDatabase database = getMongoClient().getDatabase("T800");
		System.out.println("Conectado a " + database.getName() + " satisfactoriamente!");
		return database;
	}// end

	@Override
	public MongoClient getMongoClient() {
		if (mongoClient == null) {
			mongoClient = MongoClients.create();
		}
		return mongoClient;
	}// end

}// fin clase
