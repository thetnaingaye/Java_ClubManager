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
	
	//4b (15)
	public ArrayList<Booking> getBookings (Facility fac,Date startDate,Date endDate)
	{
		ArrayList<Booking> bookingListByDateRange = new ArrayList<Booking>();
		for (Booking booking : bookingLists.get(fac))
		{
			if( (booking.getStartDate().equals(startDate) ||booking.getStartDate().after(startDate)) && (booking.getEndDate().equals(endDate) || booking.getEndDate().before(endDate)) )
			{
				bookingListByDateRange.add(booking);
			}
		}
		
		return bookingListByDateRange;
	}
	
	//4b (16)
	public void removeBooking(Booking b)
	{
		Facility fac = b.getFacility();
		ArrayList<Booking> removeList = bookingLists.get(fac);
		removeList.remove(b);
		bookingLists.put(fac, removeList);
		
	}
	
	
}
