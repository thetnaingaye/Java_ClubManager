package club;

public class Facility
{
	private String name;
	private String description;

	// constructor
	public Facility(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public Facility(String name)
	{

		this(name, null);

	}

	// getter setter
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	// methods
	public void show()
	{
		System.out.println(this);
	}

	public String toString()
	{
		String fullName = name;
		if (description != null)
		{
			fullName += " (" + description + ")";
		}
		return fullName;
	}

}
