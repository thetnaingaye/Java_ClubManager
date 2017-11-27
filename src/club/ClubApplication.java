package club;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class ClubApplication 
{
	public static void main(String[] args) 
	{
		Member member1, member2, member3, member4;
		Facility fac1, fac2, fac3;

		Club myClub = new Club();
		member1 = myClub.addMember("Edison", "Thomas", "Alva");
		member2 = myClub.addMember("Baggio", "Roberto", null);
		member3 = myClub.addMember("Webber", "Andrew", "Lloyd");
		member4 = myClub.addMember("Aye", "Thet", "Naing");

		fac1 = myClub.addFacility("Main Hall", null);
		fac2 = myClub.addFacility("Room1", "Conference Room on Level 2");
		fac3 = myClub.addFacility("Room2", "Meeting Room on Level 3");

		
		try 
		{
			Date b1Start = getDate("25-NOV-2017 15:00");
			Date b1End = getDate("27-NOV-2017 15:00");
			myClub.addBooking(3,"Main Hall", b1Start, b1End);
		
			Date b2Start = getDate("27-NOV-2017 15:01");
			Date b2End = getDate("29-NOV-2017 15:00");
			myClub.addBooking(3, "Main Hall", b2Start, b2End);
			
			Date b4Start = getDate("29-NOV-2017 15:01");
			Date b4End = getDate("30-NOV-2017 15:00");
			myClub.addBooking(1, "Main Hall", b4Start, b4End);
			
			Date b3Start = getDate("27-NOV-2017 15:01");
			Date b3End = getDate("29-NOV-2017 15:00");
			myClub.addBooking(2, "Room1", b3Start, b3End);
		
		} 
		catch (BadBookingException e) 
		{
			System.err.println(e.getMessage());
		}
		
		Date start = getDate("20-NOV-2017 15:00");
		Date end = getDate("30-NOV-2017 15:00");
		myClub.showBookings("Main Hall",start,end);
		System.out.println();
		

		//try remove booking
		try
		{
			Booking b = null;
			ArrayList<Booking> removeList = myClub.getBookings("Main Hall", start, end);
			for (Booking booking : removeList)
			{
				if(booking.getMember().getMemberNumber() == 3)
					b = booking;
			}
			myClub.removeBooking(b);
			System.out.println("----------remove Booking try-----------");
			myClub.showBookings("Main Hall",start,end);
			
			
		} 
		catch (BadBookingException e)
		{
			System.out.println(e.getMessage());
				
		}

		
		Date start1 = getDate("26-NOV-2017 15:00");
		Date end1 = getDate("30-NOV-2017 15:00");
		myClub.showBookings("Room1",start1,end1);
		

	}

	public static Date getDate(String strDate) 
	{
		SimpleDateFormat simpledateformat = new SimpleDateFormat("d-MMM-yyyy H:mm");
		try 
		{
			Date date = simpledateformat.parse(strDate);
			return date;
		} 
		catch (ParseException e) 
		{

			System.err.println("Input Date Format is invalid");
		}
		return null;
	}

}
