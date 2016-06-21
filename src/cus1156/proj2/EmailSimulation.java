package cus1156.proj2;

import java.io.IOException;

/**
 * @author Aidan Battad
   This program simulates an email messaging system.
*/
public class EmailSimulation
{  
   public static void main(String[] args) throws IOException
   { 
      MessagingSystem system = new MessagingSystem();
      EmailMenu menu = new EmailMenu();
      menu.run(system);

   }
}