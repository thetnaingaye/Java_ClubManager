package club;

public class BadBookingException extends Exception
{

	public BadBookingException()
	{
		super("Invalid Booking");
		
	}

	public BadBookingException(String message)
	{
		super(message);
		
	}


}
