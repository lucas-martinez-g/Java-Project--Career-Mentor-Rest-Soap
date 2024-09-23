package lucasm.rest_soap.services;

import static lucasm.rest_soap.RestSoapApplication.TARGET_NAMESPACE;
import static lucasm.rest_soap.RestSoapApplication.persons;

import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.models.PersonList;

@WebService(endpointInterface = "lucasm.rest_soap.services.PersonServiceSoap", targetNamespace = TARGET_NAMESPACE)
public class PersonServiceSoapImpl implements PersonServiceSoap {

  @Override
  public String addPerson(Person person) {
    if (Objects.nonNull(persons.get(person.getId()))) {
      return "Person with %s id already exists.".formatted(person.getId());
    }
    persons.put(person.getId(), person);
    return "Person created successfully.";
  }

  @Override
  public String deletePerson(int id) {
    if (Objects.isNull(persons.get(id))) {
      return "Person with %s id doesn't exists.".formatted(id);
    }
    persons.remove(id);
    return "Person removed successfully.";
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