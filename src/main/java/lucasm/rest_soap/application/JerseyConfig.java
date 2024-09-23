package lucasm.rest_soap.application;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    packages("lucasm.rest_soap.adapters.inbound.rest");
    register(org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider.App.class);
    register(org.glassfish.jersey.jaxb.internal.XmlRootElementJaxbProvider.App.class);
    register(org.glassfish.jersey.jaxb.internal.XmlRootObjectJaxbProvider.App.class);
  }
}