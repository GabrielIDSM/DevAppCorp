package Factory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ConnectionFactory {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    public EntityManager getConnection(){
        Properties PROPERTIES = new Properties();

        String url, username, password;
        URI dbUri;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
            url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
        } catch (URISyntaxException | NullPointerException ex) {
            url = "jdbc:postgresql://localhost:5432/devappcorp";
            username = "postgres";
            password = "postgres";
        }

        PROPERTIES.setProperty("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        PROPERTIES.setProperty("javax.persistence.jdbc.url", url);
        PROPERTIES.setProperty("javax.persistence.jdbc.user", username);
        PROPERTIES.setProperty("javax.persistence.jdbc.password", password);

        if (ENTITY_MANAGER_FACTORY == null)
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("PU", PROPERTIES);

        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}