package cus1156.proj2;

import java.util.Scanner;

/**
 * @author Aidan Battad
   This class creates a user interface for the email simulation
*/

public class EmailMenu
{
	private Scanner scan;
	private MessagingSystem system = null;
	private String name=null; //user logged in
	public EmailMenu()
	{
		scan=new Scanner(System.in);
	}
	/**
	 * runs the email menu display by passing the messaging/mailing system as a parameter 
	 * and allows user interaction for that menu
	 * @param MessagingSystem object to store and retrieve mailboxes
	 */
	public void run(MessagingSystem emailSystem)
	{
		menuDisplay(emailSystem);
	}
	
	/**
	 * prints the email menu and allows user interaction for that menu
	 * @param MessagingSystem object
	 */
	public void menuDisplay(MessagingSystem ms) 
	{
		system=ms;
		boolean quit=false;//if Q is inputted, boolean quit becomes true and ends the do while loop/simulation
		System.out.println("Welcome to the Email Server!");
		
		do{	//loops the menu for multiple inputs
		System.out.println("Please enter a command");
		System.out.println("I: login in");
		System.out.println("S: send message");
		System.out.println("R: read the next unread message");
		System.out.println("D: display all messages");
		System.out.println("O: log out");
		System.out.println("Q: quit");
		System.out.println(">>>>>>>>>>");
		String input=scan.next();
		
		switch(input)
		{
			case "I": //login
			{
				if (name!=null) //tests if someone is logged on
				{
					System.out.println("You are still logged on\nYou have been automatically logged off\n");
					name=null;
				}
				login();
				break;
			}
			
			case "S"://send message
			{
				sendMessage();
				break;
			}
			case "R": //read message
			{
				readMessage();
				break;
			}
			case "D"://Display all messages by recipient or latest message first
			{
				displayAllMessages();
				break;
			}
			case "O": //logout
			{
				System.out.println(name +" logged out.");
				name=null;
				break;
			}
			case "Q": //quit
			{
				System.out.println("Bye!");
				quit=true;
				break;
			}
			default: //input error
				System.out.println("Error: Incorrect Input!");	
		}
		System.out.println();
	   }while(quit==false); //ends menuDisplay method if quit = true
	}
	
	private void displayAllMessages() 
	{
		System.out.println("R: Sort messages by sender");
		System.out.println("T: Sort messages by time");
		String choice = scan.next();
		switch(choice)
		{
			case "S":
			{
				system.retrieveMailbox(name).sortBySender();
			}
			
			case "T":
			{
				system.retrieveMailbox(name).sortByTime();
			}
		}
		
	}

	/**
	 * checks to see if the user has created a mailbox, if not, it will create one
	 */
	private void login() { //login
		System.out.print("Username: ");
		name=scan.next();
		if (system.retrieveMailbox(name)== null)
		{
			system.addMailbox(name);
			System.out.println("New user added");
		}
		System.out.println("User logged in");		
	}

	
	/**
	 * creates a Message object that contains the user's name, recipient's name, and formatted message
	 * @param MessagingSystem object
	 */
	private Message createMessage() //create message
	{
		Message msg=null;
		if (name==null) //tests if someone is not logged in
		{
			System.out.println("You must log in first to send messages");
		}
		else//if user is logged in
		{
			System.out.print("Mail to: ");
			String receiver=scan.next();
			if(system.doesTheUserHaveAMailbox(receiver)==false)//searches if the recipient has a mailbox in messaging system
			{
				System.out.println("No such recipient in the mailing system.");
				return null;
			}
			else//if there is a mailbox for the recipient
			{
				System.out.println("Enter text, and end with a single Q");
				String message = "";
				String text = "";
					
				while (!text.equals("Q"))
				{
					text = scan.nextLine();
					message = message + "\n" + text;
				}
				message = message.substring(0, message.length()-1);
				msg= new Message(name, receiver, message);//adds message to recipient's mailbox
				System.out.println("Message read");
				
				return msg;
			}
		}
		return msg;
	}
	
	/**
	 * calls the createMessage method to create a Message object that contains
	 *  the user's name, recipient's name, and message. It then uses the deliver() method to send the message to the
	 *  corresponding recipient. If delivered, boolean delivered will be true, else it would be false
	 *
	 */
	private void sendMessage() {//send
		if (name==null) //tests if someone is not logged in
		{
			System.out.println("You must log in first to create messages");
		}
		else
		{  
		   Message message = createMessage(); //uses the createMessage method above to initialize a constructed Message object
		   if (message != null)
		   {
			   boolean delivered  = system.delivery(message);
			   message.currentDT(); //marks the date and time the message was sent
			   if (delivered== true)
				   System.out.println("Message delivered to " + message.getRecipient());
			   else
				   System.out.println("Message not delivered");
		   }
		}
	} 
	
	/**
	 * A Message object is initialized with the readNextMessage()method which will return the last Message object
	 * retrieved from the user's Mailbox. If the Message object assigned null, then the method will print "No unread
	 * messages". Else, the Message object is printed in a formatted way.
	 *
	 */
	private void readMessage() {//read
		if (name==null) //tests if someone is logged in
		{
			System.out.println("You must log in first to read messages");
		}
		else
		{
			Message msg= system.readUnreadMessage(name);
				if(msg==null)//checks if the user's mailbox has no messages in them
				{
					System.out.println("No unread messages");
				}
				else
				{
					System.out.println(msg.toString());
				}
		}
		
	}
}


