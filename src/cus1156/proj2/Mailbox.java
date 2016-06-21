package cus1156.proj2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Aidan Battad
   This class creates a mailbox in which messages and the mailbox owner's name are stored.
*/
public class Mailbox 
{
	private ArrayList<Message>messages;
	private String userName;
	
	/**
    Constructs a Mailbox object.
    @param person the owner
	 */
	public Mailbox(String person)
	{  
		userName = person;
		messages = new ArrayList<Message>();
	}
	/**
	 * retrieves the user's name 
	 * @return username
	 */
	public String getUserName() {
		return userName;
	}
	
	
	/**
	 * adds a Message object to the mailbox
	 * @return true or false for setLoginTo()
	 */
	public void composeMessage(Message Text)
	{
		messages.add(Text);
	}

	/**
	 * removes the current message in the ArrayList and returns it
	 * @return the first message in the ArrayList
	 */
	
	public Message getMessage() //removes the current message and returns it
	{
		return messages.remove(0);
	}
	
	/**
	 * Checks if there are messages in the Mailbox
	 * @return true if the Mailbox contains no messages, false otherwise
	    */
	public boolean doYouHaveMail()
	{	
		if (!messages.isEmpty())//if there is a message
		{ 
			return true;
		}
		return false;
	}
	
	/**
	 * Sorts a user's messages by the sender's name
	 */
	public void sortBySender()
	{
		//utilizes the comparator to compare the messages by the sender's name
		Collections.sort(messages, new compareMessages());
		for(int scan=1; scan< messages.size(); scan++)
		{
			if(messages.get(scan-1).compareTo(messages.get(scan)) > 0)
			{
		
			System.out.println(messages.get(scan-1).toString());
			}
		}
	}

	/**
	 * Sorts a user's messages from recent to old ones
	 */
	public void sortByTime()
	{
		Collections.sort(messages);
		for(Message msg: messages)
			System.out.println(msg.toString());
	}
	
}

 

