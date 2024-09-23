package lucasm.rest_soap.services;

import static lucasm.rest_soap.RestSoapApplication.TARGET_NAMESPACE;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lucasm.rest_soap.models.Person;
import lucasm.rest_soap.models.PersonList;

@WebService(targetNamespace = TARGET_NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface PersonServiceSoap {

  @WebMethod
  String addPerson(@WebParam(name = "person") Person person);

  @WebMethod
  String deletePerson(@WebParam(name = "id") int id);

  @WebMethod
  Person getPerson(@WebParam(name = "id") int id);

  @WebMethod
  PersonList getAllPersons();
}