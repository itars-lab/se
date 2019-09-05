package pl.qa.selenium.data.jdbc.dto;

/**
 * 
 * @author Pawel Tarsa
 *
 */
public class CurrencyDTO {

	private long id;
	private int value;
	private String name;

	public CurrencyDTO() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonDTO{" +
				"id=" + id +
				", value=" + value +
				", name='" + name + '\'' +
				'}';
	}
}
