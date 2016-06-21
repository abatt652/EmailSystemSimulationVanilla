package cus1156.proj2;
import java.time.LocalDateTime;
/**
 *  Constructs a Message object
 * @author Aidan Battad
 *
 */
public class Message implements Comparable <Message>
{
	
	private String sender;
	private String recipient;
	private String text;
	private LocalDateTime timeSent;
	
	/**
    Creates a Message object.
    @param from- the sender of the message
    @param recip - the recipient of the message
    @param txt - the message text
	 */
	public Message(String composer, String receiver, String msg)
	{  
	  sender = composer;
	  text = msg;
	  recipient = receiver;
	  timeSent=currentDT();
	  
	}
	
	/**
	 * retrieves the recipient's name 
	 * @return recipient's username
	 */
	public String getRecipient() {
		return recipient;
	}
	
	/**
	 * retrieves the sender's name 
	 * @return sender's name
	 */
	public String getSender() {
		return sender;
	}

	
	/**
    Formats the email message.
    @return email format
	 */
	public String toString()
	{
		return "From: " + sender + "\n" + "To: " + recipient + "\n" + "Time Sent: " + currentDT() + "\n" + text + "*****************\n";
	}
	
	/**
   	The date and time a message was sent
    @return date and time sent
	 */
	public LocalDateTime currentDT()
	{
		timeSent=LocalDateTime.now();
		 return timeSent;     
	}

	@Override
	public int compareTo(Message message) {
		if(timeSent== message.timeSent)
			return -1; //if the message arrived later than the compared message, return timeSent < o.timeSent
		
		if(timeSent != message.timeSent)
			return 1;
		return 0;
	}
}

