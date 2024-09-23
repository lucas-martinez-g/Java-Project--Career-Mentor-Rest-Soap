package lucasm.rest_soap;

import jakarta.xml.ws.Endpoint;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.services.PersonServiceSoapImpl;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RestSoapApplication {

  public static final String BASE_URI = "http://localhost:8080/api/";
  public static final String TARGET_NAMESPACE = "rest-soap-app";
  public static Map<Integer, Person> persons = new HashMap<>();

  public static HttpServer startServer() {
    final ResourceConfig rc = new ResourceConfig().packages(
        "lucasm.rest_soap.adapters.inbound.rest");
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
  }

  public static void main(String[] args) {
    try {
      Endpoint.publish("http://localhost:8081/ws/person", new PersonServiceSoapImpl());
      System.out.println("SOAP Service published at http://localhost:8081/ws/person?wsdl");

      final HttpServer server = startServer();
      System.out.println(String.format(
          "Jersey app started with WADL available at %sapplication.wadl\nHit enter to stop it...",
          BASE_URI));

      System.in.read();
      server.shutdownNow();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}