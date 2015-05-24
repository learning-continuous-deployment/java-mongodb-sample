package csm; 

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.ServerConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import csm.httphandler.AddEntry;
import csm.httphandler.DropEntries;
import csm.httphandler.GetEntries;

public class Server {

	private static MongoDatabase database;
	private static MongoClient mongoClient;

	private static void initMongoClient() {
		mongoClient = new MongoClient();
		// mongoClient = new MongoClient(new MongoClientURI(args[0]));

		database = mongoClient.getDatabase("mydb");
	}

	public static MongoDatabase getDatabase() {
		return database;
	}

	public static void main(String[] args) throws IOException {
		initMongoClient();

		HttpServer server = HttpServer.createSimpleServer();
		ServerConfiguration config = server.getServerConfiguration();

		config.addHttpHandler(new GetEntries(), "/getEntries");
		config.addHttpHandler(new DropEntries(), "/dropEntries");
		config.addHttpHandler(new AddEntry(), "/addEntry");

		server.start();

		System.out.println("Press any key to stop the server...");
		System.in.read();
	}

}
