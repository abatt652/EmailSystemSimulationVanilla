package cus1156.proj2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aidan Battad
   This class represents the method in which the messages are send and retrieved from
   the mailing system which is the HashMap
*/

public class MessagingSystem 
{
	private Map <String, Mailbox> mailboxSystem;
	
	/**
	Creates a MessagingSystem object which contains a HashMap
	*/
	public MessagingSystem()
	{ 
		mailboxSystem= new HashMap <String, Mailbox>(); //the name of the user is the key and the mailbox is its value
	}
	
	/**
	 * adds a mailbox in the HashMap for a new user
	 * @param a mailbox
	 */
	public void addMailbox(String name)
	{
		Mailbox box= new Mailbox(name);
		mailboxSystem.put(name, box);
	}
	
	/**
	 * retrieves a mailbox in the HashMap for a current user
	 * @param name of the user
	 * @return the mailbox owned by the user
	 */
	public Mailbox retrieveMailbox(String name)
	{
		for (Map.Entry<String, Mailbox> singleMailbox : mailboxSystem.entrySet())
		{
			if(singleMailbox.getKey().equals(name))
			{
				return singleMailbox.getValue(); //retrieves mailbox from hashmap
			}
		}
		return null;
	}
	
	  /**
	    * return the next message in the mailbox for the user, 
	    * and utilizes the getMessage() method which will delete the message
	    * @param user
	    * @return a Message object
	    */
	   public Message readUnreadMessage(String user)
	   {
		   Mailbox box = retrieveMailbox(user);
		   if (box == null)
			   return null;
		   if (box.doYouHaveMail()==false)
		       return null;
		   return box.getMessage();
	   }

	   /**
	    * checks to see if a given user has a mailbox
	    * @param user
	    * @return true if the user has a mailbox, false otherwise
	    */
	   public boolean doesTheUserHaveAMailbox(String user)
	   {
		   for (Map.Entry<String, Mailbox> singleMailbox : mailboxSystem.entrySet())
		         if (singleMailbox.getKey().equals(user))
		            return true;
		      return false;
	   }
	   
	   /**
	      The message will be added to the recipient's mailbox
	      If the mailbox does not exist, false is returned and vice-versa.
	      @param msg the message
	      @return true if successful, false if there is no mailbox for the user
	   */
	   public boolean delivery(Message msg)
	   {  
	      Mailbox mbox = retrieveMailbox(msg.getRecipient());
	      if (mbox == null)
	    	  return false;
	      mbox.composeMessage(msg);
	      return true;
	   }
}

