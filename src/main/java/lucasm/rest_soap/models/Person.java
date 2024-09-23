package lucasm.rest_soap.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Period;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lucasm.rest_soap.application.LocalDateAdapter;

@XmlRootElement(name = "person")
@XmlType(propOrder = {"id", "name", "age", "birthDate", "description"})
@Setter
@NoArgsConstructor
public class Person {

  private Integer id;
  private String name;
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate birthDate;

  @XmlElement
  public Integer getId() {
    return id;
  }

  @XmlElement
  public String getName() {
    return name;
  }

  @XmlElement
  public int getAge() {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  @XmlElement
  public String getDescription() {
    return this.toString();
  }

  @Override
  public String toString() {
    return id + ": " + name + ", " + getAge() + " years. Birthdate: " + birthDate.toString();
  }
}