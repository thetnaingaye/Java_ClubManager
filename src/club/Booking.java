package club;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking
{
	private Member member;
	private Facility facility;
	private Date startDate;
	private Date endDate;
	
	public Booking(Member member, Facility fac, Date startDate, Date endDate) throws BadBookingException
	{

		boolean isDateValid = startDate.before(endDate);
		if( member !=null && fac!=null && startDate !=null && endDate!= null && isDateValid)
		{
			this.member = member;
			this.facility = fac;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		else
		{
			throw new BadBookingException("Booking constructor failed");
		}

	}

	public Member getMember()
	{
		return member;
	}

	public Facility getFacility()
	{
		return facility;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public boolean overlaps(Booking anotherbooking)
	{
		boolean isSameFacility = this.facility.getName().equals(anotherbooking.facility.getName());
		
		//getting earlier booking from both bookings
		Date primaryStartDate = this.startDate.before(anotherbooking.startDate)? this.startDate : anotherbooking.startDate;
		Date primaryEndDate = primaryStartDate.equals(this.startDate)? this.endDate : anotherbooking.endDate;
		
		Date secondaryStartDate = primaryStartDate.equals(this.startDate)? anotherbooking.startDate : this.startDate;
		
		//comparing with later booking start date with earlier booking end date
		boolean isOverLap = secondaryStartDate.equals(primaryEndDate) || secondaryStartDate.before(primaryEndDate);
		
		return (isSameFacility && isOverLap);

	}
	
	public String toString()
	{
		
		SimpleDateFormat sm = new SimpleDateFormat("d-MMM-yyyy H:mm");
		
		String bookInfo = "\n-------------";
		bookInfo += "\nMember Name:\t" + member.toString();
		bookInfo += "\nFacility Name:\t" + facility.toString();
		bookInfo += "\nStart Date:\t" + sm.format(startDate);
		bookInfo += "\nEnd Date:\t" + sm.format(endDate);
		return bookInfo;
	}
	
	public void show()
	{
		System.out.println(this);
	}

}
