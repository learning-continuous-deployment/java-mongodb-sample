package csm.httphandler;

import org.bson.Document;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import com.mongodb.client.MongoCollection;

import csm.Server;

public class DropEntries extends HttpHandler {

	@Override
	public void service(Request req, Response resp) throws Exception {
		MongoCollection<Document> collection = Server.getDatabase()
				.getCollection("test");

		collection.drop();

		String response = "dropped it like it's hot!";
		
		resp.setContentType("text/plain");
		resp.setContentLength(response.length());
		resp.getWriter().write(response.toString());
	}

}
