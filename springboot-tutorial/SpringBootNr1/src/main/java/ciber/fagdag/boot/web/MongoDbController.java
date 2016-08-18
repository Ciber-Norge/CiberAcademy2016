package ciber.fagdag.boot.web;

import ciber.fagdag.boot.domain.mongodb.Books;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/webservice")
public class MongoDbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String test() {
        return "test";
    }


    @GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String showMsg(@PathParam("message") String message) {
        return message;
    }


    @GET
    @Path("/insert/{title}/{by}/{likes}/{year}/{description}")
    @Produces("text/plain")
    public String insert(@PathParam("title") String title,
                         @PathParam("description") String description,
                         @PathParam("likes") Long likes,
                         @PathParam("year") String year,
                         @PathParam("by") String by) {
        DB db = mongoTemplate.getDb();
        DBCollection coll = db.getCollection("Books");
        BasicDBObject doc = new BasicDBObject("title", title).
                append("description", description).
                append("likes", likes).
                append("year", year).
                append("by", by);
        coll.insert(doc);
        return db.isAuthenticated() + " ; " + db.getName();
    }

    @GET
    @Path("/getRecords")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> getRecords() {
        DB db = mongoTemplate.getDb();
        DBCollection coll = db.getCollection("Books");
        DBCursor cursor = coll.find().sort(new BasicDBObject("by", 1));
        List<Books> list = new ArrayList<Books>();
        while (cursor.hasNext()) {
            DBObject o = cursor.next();
            Books bools = new Books();
            bools.setTitle((String) o.get("title"));
            bools.setDescription((String) o.get("description"));
            bools.setYear((String) o.get("year"));
            bools.setBy((String) o.get("by"));
            bools.setLikes((Long) o.get("likes"));
            list.add(bools);
        }
        return list;
    }

    @GET
    @Path("/getRecord/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> getRecordFromName(@PathParam("title") String message) {
        DB db = mongoTemplate.getDb();
        DBCollection coll = db.getCollection("Books");
        DBCursor cursor = coll.find(new BasicDBObject("title", message));
        List<Books> list = new ArrayList<Books>();
        while (cursor.hasNext()) {
            DBObject o = cursor.next();
            Books bools = new Books();
            bools.setTitle((String) o.get("title"));
            bools.setDescription((String) o.get("description"));
            bools.setYear((String) o.get("year"));
            bools.setBy((String) o.get("by"));
            list.add(bools);
        }
        return list;
    }
}

