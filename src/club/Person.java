package club;

public class Person
{
	private String surname;
	private String firstname;
	private String secondname;

	// constructor
	public Person(String surname, String firstname, String secondname)
	{
		this.surname = surname;
		this.firstname = firstname;
		this.secondname = secondname;

	}

	// getters setters
	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getSecondname()
	{
		return secondname;
	}

	public void setSecondname(String secondname)
	{
		this.secondname = secondname;
	}

	// methods
	public void show()
	{

		System.out.println(this);

	}

	public  String toString()
	{
		if (this.getSecondname() == null || this.getSecondname().isEmpty())
		{
			return ("Person ["+firstname + " " +surname+"]");
		} 
		else
		{
			return ("Person ["+firstname + " "+secondname+" "+surname+"]");
		}

	}

}
