package lucasm.rest_soap.services;

import jakarta.ws.rs.core.Response;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.models.PersonList;

public interface PersonServiceRest {

  Response addPerson(Person person);

  Response deletePerson(int id);

  Person getPerson(int id);

  PersonList getAllPersons();
}