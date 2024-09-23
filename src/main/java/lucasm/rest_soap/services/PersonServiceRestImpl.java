package lucasm.rest_soap.services;

import static lucasm.rest_soap.RestSoapApplication.persons;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.models.PersonList;

public class PersonServiceRestImpl implements PersonServiceRest {

  @Override
  public Response addPerson(Person person) {
    if (Objects.nonNull(persons.get(person.getId()))) {
      return Response.status(Status.BAD_REQUEST)
          .header(Status.BAD_REQUEST.name(),
              "Person with %s id already exists.".formatted(person.getId()))
          .build();
    }
    persons.put(person.getId(), person);
    return Response.ok()
        .header(Status.OK.name(), "Person created successfully.")
        .build();
  }

  @Override
  public Response deletePerson(int id) {
    if (Objects.isNull(persons.get(id))) {
      return Response.status(Status.BAD_REQUEST)
          .header(Status.BAD_REQUEST.name(), "Person with %s id doesn't exists.".formatted(id))
          .build();
    }
    persons.remove(id);
    return Response.ok()
        .header(Status.OK.name(), "Person removed successfully.")
        .build();
  }

  @Override
  public Person getPerson(int id) {
    return persons.get(id);
  }

  @Override
  public PersonList getAllPersons() {
    List<Person> personList = new ArrayList<>(persons.values());
    return new PersonList(personList);
  }
}