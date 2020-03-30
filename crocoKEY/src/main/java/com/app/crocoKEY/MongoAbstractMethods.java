package com.app.crocoKEY;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;


public interface MongoAbstractMethods {
	
	public List<Document> getAllDatabase(com.mongodb.client.MongoClient mongo);
	
	
}
