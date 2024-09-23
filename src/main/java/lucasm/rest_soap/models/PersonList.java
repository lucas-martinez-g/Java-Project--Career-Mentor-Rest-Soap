package lucasm.rest_soap.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@XmlRootElement
public class PersonList {

  private List<Person> persons;

  public PersonList(List<Person> persons) {
    this.persons = persons;
  }

  @XmlElement(name = "persons")
  public List<Person> getPersons() {
    return persons;
  }

}