package cus1156.proj2;
/**
 * @author Aidan Battad
 * A JUnit class that tests the MessagingSystem class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessagingSystemTest {
	private MessagingSystem system;
	
	
	@Before
	public void setUp() throws Exception {
		system=new MessagingSystem();
	}

	@Test
	public void testAddMailbox() {
		system.addMailbox("Aidan");
    	assertNotNull(system.retrieveMailbox("Aidan"));
	}
	
	@Test
	public void testRetrieveMailbox() {
		system.addMailbox("Aidan");
    	assertEquals(system.retrieveMailbox("Aidan").getUserName(), "Aidan");
	}
	@Test
	
	public void testReadUnreadMessage() {
		
		Message msg= new Message("Bob", "Terry", "Hello");
		system.addMailbox("Aidan");
		system.retrieveMailbox("Aidan").composeMessage(msg);
    	assertNotNull(system.readUnreadMessage("Aidan"));
	}
	
	@Test
	public void testDoesTheUserHaveAMailbox() {
		system.addMailbox("Aidan");
    	assertTrue(system.doesTheUserHaveAMailbox("Aidan"));
	}
	
	@Test
	public void testDelivery() {
		Mailbox recipientMB= new Mailbox("Tedd");
		Mailbox senderMB= new Mailbox("Bill");
		Message msg= new Message("Bill", "Tedd", "Hi");
		senderMB.composeMessage(msg);
    	assertEquals(system.delivery(msg), recipientMB.doYouHaveMail());
	}

}
