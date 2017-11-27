package club;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookingRegister
{
	private HashMap<Facility,ArrayList<Booking>> bookingLists;


	public BookingRegister()
	{
		bookingLists = new HashMap<Facility,ArrayList<Booking>>();
	}
	
	public void addBooking(Member member, Facility facility, Date startDate, Date endDate) throws BadBookingException
	{
		
		boolean isOverLap = false;
		Booking newBooking = new Booking(member,facility,startDate,endDate);
		ArrayList<Booking>facBookingList = bookingLists.get(facility);
		if(facBookingList == null)
		{
			facBookingList = new ArrayList<Booking>();
			facBookingList.add(newBooking);
			bookingLists.put(facility, facBookingList);
		}
		else
		{
			for (Booking booking : facBookingList)
			{
				if(booking.overlaps(newBooking))
				{
					isOverLap = true;
				}
			}
			
			if(isOverLap)
			{
				throw new BadBookingException("Booking is overLap");
			}
			else
			{
				facBookingList.add(newBooking);
				bookingLists.put(facility, facBookingList);
			}
		}
		

		
	}
	
	public ArrayList<Booking> getBookings (Facility fac)
	{
		return bookingLists.get(fac);
	}
	
	
}
