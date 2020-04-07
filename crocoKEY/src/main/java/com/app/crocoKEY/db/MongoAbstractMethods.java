package com.app.crocoKEY;

import java.util.List;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;


public interface MongoAbstractMethods {
	
	public List<Document> getAllDatabase(com.mongodb.client.MongoClient mongo);
	public String setDataInCollections(String nameCollection, Object dataDocument, Object database);
	public MongoDatabase getDatabase(String nameDatabase);
	public MongoClient getMongoClient();
}
