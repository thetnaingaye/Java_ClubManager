package club;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Club
{
	private int currentNumber;

	private ArrayList<Member> member;
	private HashMap<String, Facility> facility;
	
	private BookingRegister bookingRegister;

	public Club()
	{
		currentNumber = 0;
		member = new ArrayList<Member>();
		facility = new HashMap<String, Facility>();
		bookingRegister = new BookingRegister();

	}

	//Member METHODS
	public Member addMember(String surname, String firstname, String secondname)
	{

		Member m = new Member(surname, firstname, secondname, currentNumber + 1);
		member.add(currentNumber, m);
		currentNumber++;
		return m;

	}

	public void showMembers()
	{
		System.out.println("Members:");
		for (Member member2 : member)
		{
			if (member2 != null)
			{
				member2.show();
			}

		}

	}

	public void removeMember(int memberNumber)
	{

		if (memberNumber - 1 < 0 || memberNumber - 1 >= member.size())
		{
			System.out.println("\nMemberNumber is not valid");
		} else
		{
			member.remove(memberNumber - 1);
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Member> getMembers()
	{
		return (ArrayList<Member>) member.clone();
	}

	// Facility METHODS
	public Facility addFacility(String name, String description)
	{

		Facility fac = new Facility(name, description);
		facility.put(fac.getName(), fac);
		return fac;

	}

	public Facility getFacility(String name)
	{
		return facility.get(name);
	}

	public Collection<Facility> getFacilities()
	{
		return facility.values();
	}

	public void removeFacility(String name)
	{
		if (facility.containsKey(name))
		{
			facility.remove(name);
		} else
		{
			System.out.println("Invalid Facility name");
		}
	}

	public void showFacilities()
	{

		System.out.println("Facilities:");
		for (Facility fac : this.getFacilities())
		{
			fac.show();
		}
	}

	public void show()
	{
		System.out.println("------------------------------");
		System.out.println("List of Members and Facilities");
		System.out.println("------------------------------");
		this.showMembers();
		System.out.println();
		this.showFacilities();
	}
	
	
	//4b (17)
	public void addBooking(int membershipnumber,String facName,Date startdate,Date enddate) throws BadBookingException
	{
		try 
		{
			Member m =member.get(membershipnumber-1);
			Facility fac = facility.get(facName);
			bookingRegister.addBooking(m,fac, startdate, enddate);
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new BadBookingException("Member not exist");
		}
		catch(NullPointerException e)
		{
			throw new BadBookingException("Facility not exist");
		}

		
	}
	
	public void showBookings(String facName)
	{
		
		Facility fac = facility.get(facName);
		ArrayList<Booking> blist = bookingRegister.getBookings(fac);
		for (Booking booking : blist)
		{
			booking.show();
		}
	}

}
