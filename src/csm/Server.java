package csm;

import java.io.IOException;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.ServerConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import csm.httphandler.AddEntry;
import csm.httphandler.DropEntries;
import csm.httphandler.GetEntries;

public class Server {

	private final static String DB_ENV_NAME = "MONGO_PORT";

	private static MongoDatabase database;
	private static MongoClient mongoClient;

	private static void initMongoClient() {
		String address = getDatabaseEnv();
		if (address != null) {
			System.out.println(String.format("Connecting to database: %s", address));
			address = address.substring(6);
			mongoClient = new MongoClient(address);
		} else {
			mongoClient = new MongoClient();
		}
		database = mongoClient.getDatabase("mydb");
	}

	private static String getDatabaseEnv() {
		Map<String, String> env = System.getenv();
		return env.get(DB_ENV_NAME);
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

		try {
			server.wait();
		} catch (Exception e) {
		}
	}

}
