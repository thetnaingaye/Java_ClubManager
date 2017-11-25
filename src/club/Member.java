package club;

public class Member extends Person
{
	private int memberNumber;
	
	public int getMemberNumber()
	{
		return memberNumber;
	}

	public Member(String surname, String firstname, String secondname,int membernumber)
	{
		super(surname, firstname, secondname); //calling parent class constructor
		this.memberNumber = membernumber;
	}

	public String toString()
	{
		String fullname = super.toString();
		String memName = fullname + " Membership number :" + memberNumber;
		return memName;
	}

}
