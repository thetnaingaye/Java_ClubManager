package club;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ClubApplication
{
	public static void main(String[] args) throws ParseException
	{
		Member member1,member2,member3,member4;
		Facility fac1, fac2, fac3;

		
		Club myClub = new Club();
		member1 = myClub.addMember("Edison", "Thomas", "Alva");
		member2 = myClub.addMember("Baggio", "Roberto", null);
		member3 = myClub.addMember("Webber", "Andrew", "Lloyd");
		member4 = myClub.addMember("Aye", "Thet", "Naing");
		
		fac1 = myClub.addFacility("Main Hall", null);
		fac2 = myClub.addFacility("Room1", "Conference Room on Level 2");
		fac3 = myClub.addFacility("Room2", "Meeting Room on Level 3");
		
		System.out.println("\nTesting Member.show() method individually");
		System.out.println("--------------------");
		System.out.println("Members:");
		member1.show();
		member2.show();
		member3.show();
		member4.show();
		
		System.out.println("\nTesting showMember method");
		System.out.println("--------------------");
		myClub.showMembers();
		
		myClub.removeMember(2);
		
		System.out.println("\nTesting removeMember method");
		System.out.println("--------------------");

		ArrayList<Member> memList = myClub.getMembers();
		for (Member member : memList)
		{
			member.show();
		}
		
		
		System.out.println("\nFacility Testing");
		System.out.println("--------------------");

		
		System.out.println("\nGet Facility test");
		System.out.println("--------------");
		Facility fac4 = myClub.getFacility("Main Hall");
		System.out.println(fac4);
	
		System.out.println("\ngetFacilities test");
		System.out.println("--------------");
		Collection<Facility> facList = myClub.getFacilities();
		for (Facility facility : facList)
		{
			facility.show();
		}
		
		System.out.println("\nFacility Remove Testing");
		System.out.println("--------------------");
		myClub.removeFacility("Main Hall");
		myClub.showFacilities();
		
		myClub.show();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("d-MMM-yyyy H:mm");
		Date b1Start = simpledateformat.parse("25-NOV-2017 15:01");
		Date b1End = simpledateformat.parse("29-NOV-2017 15:00");
		Booking b1 = new Booking(member1,fac1,b1Start,b1End);

		Date b2Start = simpledateformat.parse("22-NOV-2017 15:00");
		Date b2End = simpledateformat.parse("25-NOV-2017 15:00");
		Booking b2 = new Booking(member2,fac1,b2Start,b2End);
		System.out.println("\nCheck overlap");
		System.out.println(b1.overlaps(b2));
		System.out.println(b2.overlaps(b1));
		System.out.println(b2);
		b1.show();
	}

}
