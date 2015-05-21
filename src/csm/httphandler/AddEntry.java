package csm.httphandler;

import org.bson.Document;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import com.mongodb.client.MongoCollection;

import csm.Server;

public class AddEntry extends HttpHandler {

	@Override
	public void service(Request req, Response resp) throws Exception {
		MongoCollection<Document> collection = Server.getDatabase()
				.getCollection("test");

		String pName = req.getParameter("name");

		if (pName == null) {
			resp.setContentType("text/plain");
			resp.getWriter().write("parameter 'name' is missing");
			return;
		}

		Document doc = new Document("name", pName).append("time",
				System.currentTimeMillis());
		collection.insertOne(doc);

		resp.setContentType("text/plain");
		resp.getWriter().write(
				String.format("%s was added to the database", pName));
	}
}
