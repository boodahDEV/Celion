package com.app.crocoKEY.db;

import java.util.List;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;


public interface MongoAbstractMethods {
	
	public List<Document> getAllDatabase(com.mongodb.client.MongoClient mongo);
	public String setDataInCollections(String nameCollection, Object dataDocument, Object database);
	public MongoDatabase getDatabase(String nameDatabase);
	public MongoClient getMongoClient();
	public String deleteOneData(String nameCollection, Object dataDocument, Object database);
	public String updateOneData(String nameCollection, Object dataDocument, Object dataUpdateNew, Object database);
	public List<Document> read(String nameCollection, Object dataForFindDocument, Object database);
}