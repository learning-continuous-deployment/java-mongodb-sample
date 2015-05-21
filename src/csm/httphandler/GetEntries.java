package csm.httphandler;

import org.bson.Document;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import csm.Server;

public class GetEntries extends HttpHandler {

	@Override
	public void service(Request req, Response resp) throws Exception {
		MongoCollection<Document> collection = Server.getDatabase()
				.getCollection("test");

		StringBuffer buffer = new StringBuffer();

		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				buffer.append(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}

		resp.setContentType("text/plain");
		resp.setContentLength(buffer.length());
		resp.getWriter().write(buffer.toString());
	}
}
