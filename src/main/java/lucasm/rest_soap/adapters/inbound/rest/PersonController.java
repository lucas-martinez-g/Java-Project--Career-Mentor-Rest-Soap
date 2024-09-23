package lucasm.rest_soap.adapters.inbound.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.services.PersonServiceRest;
import lucasm.rest_soap.services.PersonServiceRestImpl;

@Path("/person")
public class PersonController {

  private PersonServiceRest personServiceRest = new PersonServiceRestImpl();

  @GET
  @Path("/getAll")
  @Produces(MediaType.APPLICATION_XML)
  public Response getAllPersons() {
    return Response.ok(personServiceRest.getAllPersons()).build();
  }

  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public Response addPerson(Person person) {
    return personServiceRest.addPerson(person);
  }

  @DELETE
  @Path("/delete/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Response deletePerson(@PathParam("id") int id) {
    return personServiceRest.deletePerson(id);
  }

  @GET
  @Path("/get/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Response getPerson(@PathParam("id") int id) {
    Person person = personServiceRest.getPerson(id);
    if (person == null) {
      return Response.status(Response.Status.NOT_FOUND)
          .header(Status.BAD_REQUEST.name(),
              "Person with %s id doesn't exists.".formatted(id))
          .build();
    }
    return Response.ok(person).build();
  }
}