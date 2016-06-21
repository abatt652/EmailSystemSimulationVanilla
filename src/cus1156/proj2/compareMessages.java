package cus1156.proj2;

import java.util.Comparator;
/**
 * @author Aidan Battad
 * Implementing the comparator <T> interface to compare Message objects
 */
public class compareMessages implements Comparator <Message>
{
	/**
	 * Compares two Message objects based on the name of the sender of the message
	 * @return returns the Message comparison condition
	 */
	@Override
	public int compare(Message message1, Message message2) {
		return message1.getSender().compareTo(message2.getSender());

	}

}
