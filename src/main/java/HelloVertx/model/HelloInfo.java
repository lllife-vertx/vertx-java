package HelloVertx.model;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created by recovery on 12/19/13.
 */
public class HelloInfo {

    private String name;
    private String email;
    private String password;
    private ObjectId _id;

    public boolean insert() throws UnknownHostException {
        MongoClient client = new MongoClient("localhost", 27017);
        DB db = client.getDB("vert.x");
        DBCollection collection = db.getCollection("infos");

        BasicDBObject obj = new BasicDBObject();
        obj.append("name", this.name);
        obj.append("email", this.email);

        WriteResult result = collection.insert(obj);
        return  true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
