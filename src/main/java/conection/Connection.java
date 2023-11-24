package conection;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.bson.Document;
import vars.NeededVars;
import java.util.ArrayList;
import java.util.Date;
import model.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author oscar
 */
public class Connection implements NeededVars
{

    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private MongoClient mongoClient;

    private int connect()
    {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);

        // Configura las opciones del cliente
        int i = 0;
        while (i < 3)
        {
            try
            {
                MongoClientSettings options = MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .applyToClusterSettings(builder
                                -> builder.serverSelectionTimeout(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS))
                        .build();
                setMongoClient(MongoClients.create(options));
                getMongoClient().listDatabaseNames();
                i = 3;
                return 200;//ok
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "reintentando conexión " + (i + 1));
                i++;
            }
        }
        JOptionPane.showMessageDialog(null, "Conexión fallida");
        return 404; //error
    }

    private int useDefaultDatabase()
    {
        try
        {
            setDb(getMongoClient().getDatabase(DATABASE_NAME));
            return 200;//ok
        } catch (Exception e)
        {
            return 400;//error
        }
    }

    private int useDefaultCollection()
    {
        try
        {
            setCollection(getDb().getCollection(COLLECTION_NAME));
            return 200;//ok
        } catch (Exception e)
        {
            return 400;//error
        }
    }

    public int defaultConnection()
    {
        int connStat = connect();
        if (connStat >= 200 && connStat < 300)
        {
            int usedb = useDefaultDatabase();

            if (usedb >= 200 && usedb < 300)
            {
                int collTarget = useDefaultCollection();
                if (collTarget >= 200 && collTarget < 300)
                {
                    return 200;//ok
                }
            }
        }
        return 400;//error
    }

    public ArrayList getAllDocuments()
    {
        FindIterable<Document> documents = getCollection().find();

        MongoCursor<Document> iterator = documents.iterator();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Usuario> result = new ArrayList<>();
        while (iterator.hasNext())
        {
            Document document = iterator.next();
            Usuario user = new Usuario();
            user.setId(document.get("_id").toString());
            user.setNombre(document.get("NOMBRE").toString());
            user.setAp_pat(document.get("AP_PAT").toString());
            user.setAp_mat(document.get("AP_MAT").toString());
            user.setFech_nac(document.getDate("FECHA_NAC"));
            user.setCorreo(document.get("CORREO").toString());
            user.setNickname(document.get("NICKNAME").toString());
            user.setContrasenia(document.get("CONTRASENIA").toString());
            user.setFecha_registro(document.getDate("FECHA_REGISTRO"));
            user.setGenero(document.get("GENERO").toString());
            user.setLocalidad(document.get("LOCALIDAD").toString());
            user.setProfesion(document.get("PROFESION").toString());
            user.setEstatus(document.getInteger("estatus"));
            result.add(user);
        }
        return result;
    }

    public int updateDocument(String id, String nombre, String apPaterno, String apMaterno, String correo, String nickname, String contrasenia, String genero, String localidad, String profesion, Date fechaNacimiento, String estatus)
    {
        try
        {
            ObjectId oid = new ObjectId(id);

            // Construir el filtro
            Document filter = new Document("_id", oid);
            /*

             */
            // Construir el documento de actualización
            Document update = new Document("$set",
                    new Document("NOMBRE", nombre)
                            .append("AP_PAT", apPaterno)
                            .append("AP_MAT", apMaterno)
                            .append("FECHA_NAC", fechaNacimiento)
                            .append("CORREO", correo)
                            .append("NICKNAME", nickname)
                            .append("CONTRASENIA", contrasenia)
                            .append("GENERO", genero)
                            .append("LOCALIDAD", localidad)
                            .append("PROFESION", profesion)
                            .append("estatus", Integer.parseInt(estatus)));

            // Realizar la actualización
            collection.updateOne(filter, update);
            return 200;//ok
        } catch (Exception e)
        {
            return 500;//error
        }
    }

    public int deleteDocument(String id)
    {
        try
        {
            ObjectId oid = new ObjectId(id);
            Document filtro = new Document("_id", oid);
            collection.deleteOne(filtro);
            return 200;//ok
        } catch (Exception e)
        {
            return 500;//error
        }
    }

    /**
     * @return the mongoClient
     */
    public MongoClient getMongoClient()
    {
        return mongoClient;
    }

    /**
     * @param mongoClient the mongoClient to set
     */
    public void setMongoClient(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    /**
     * @return the db
     */
    public MongoDatabase getDb()
    {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(MongoDatabase db)
    {
        this.db = db;
    }

    /**
     * @return the collection
     */
    public MongoCollection<Document> getCollection()
    {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(MongoCollection<Document> collection)
    {
        this.collection = collection;
    }

    public int addDocument(String nombre, String apPaterno, String apMaterno, String correo, String nickname, String contrasenia, String genero, String localidad, String profesion, Date fecha_nac)
    {
        try
        {
            Document usuario = new Document()
                    .append("NOMBRE", nombre)
                    .append("AP_PAT", apPaterno)
                    .append("AP_MAT", apMaterno)
                    .append("FECHA_NAC", fecha_nac)
                    .append("CORREO", correo)
                    .append("NICKNAME", nickname)
                    .append("CONTRASENIA", contrasenia)
                    .append("FECHA_REGISTRO", new Date())
                    .append("GENERO", genero)
                    .append("LOCALIDAD", localidad)
                    .append("PROFESION", profesion)
                    .append("estatus", 1);

            // Realizar la actualización
            collection.insertOne(usuario);
            return 200;//ok
        } catch (Exception e)
        {
            return 500;//error
        }
    }
}
