package persistence;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//package-private -  to ensure that the implementation details are hidden from the rest of application
 class PersistenceAPIImpl {

 private String connectionUrl;
 private String username;
 private String password;

 public PersistenceAPIImpl (){
  try {
   Class.forName("org.postgresql.Driver");
   loadProperties();
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  }
 }

 private void loadProperties() {
  Properties props = new Properties();
  try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
   props.load(inputStream);
   connectionUrl = props.getProperty("CONNECTION_URL");
   username = props.getProperty("USERNAME");
   password = props.getProperty("PASSWORD");
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 public String getConnectionUrl() {
  return connectionUrl;
 }

 public String getUsername() {
  return username;
 }

 public String getPassword() {
  return password;
 }
}
