package cus1156.proj2;

/**
 * @author Aidan Battad
 * A JUnit class that tests the Mailbox class
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailboxTest {
	private Mailbox mbox;
	private String name="Aidan";
	private Message msg;
	
	@Before
	public void setUp() throws Exception {
		mbox= new Mailbox(name);
		msg=new Message("Aidan", "Tom", "Hello");
	}

	@Test
	public void testGetMessage() {
		mbox.composeMessage(msg);
    	assertEquals(mbox.getMessage(), msg);
	}
	
	@Test
	public void testComposeMessage() {
		Message m= null;
		mbox.composeMessage(m);
    	assertEquals(mbox.getMessage(), null);
	}
	
	@Test
	public void testDoYouHaveMail() {
		mbox.composeMessage(msg);
    	assertTrue(mbox.doYouHaveMail());
	}
	
	@Test
	public void testSortBySender() {
		Message msg1=new Message("Jenny", "Tom", "Good Morning");
		Message msg2=new Message("Bob", "Aidan", "Hi");
		mbox.composeMessage(msg1);
		mbox.composeMessage(msg2);
		mbox.sortBySender();
		assertEquals("Bob", mbox.getMessage().getSender());
	    assertEquals("Jenny", mbox.getMessage().getSender());
	   
	}
	
	@Test
	public void testSortByTime() {
		Message msg1=new Message("Dan", "Arthur", "Good Morning");
		Message msg2=new Message("Kevin", "Bob", "Hi");
		mbox.composeMessage(msg1);
		mbox.composeMessage(msg2);
		mbox.sortByTime();
		assertEquals(msg1.currentDT(), mbox.getMessage().currentDT());
	    assertEquals(msg2.currentDT(), mbox.getMessage().currentDT());
	}

}
