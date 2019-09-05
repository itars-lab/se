package pl.qa.selenium.data.jdbc;


import pl.qa.selenium.data.jdbc.dto.PersonDTO;
import pl.qa.selenium.data.jdbc.model.Person;

import java.util.List;

/**
 * 
 * @author Pawel Tarsa
 *
 */
public class App {

	public static void main(String[] args) {
		Person pm = new Person();

		PersonDTO personById = pm.getPersonById(4);
		System.out.println(personById);

		PersonDTO personByIdPrepStatement = pm.getPersonByIdUsingPreparedStatement(4);
		System.out.println(personByIdPrepStatement);

		int affectedPersons = pm.updatePersonAge(1, 18);
		System.out.println(affectedPersons);

		List<PersonDTO> person = pm.getAllPersons();
		person.forEach(System.out::println);

	}
}
