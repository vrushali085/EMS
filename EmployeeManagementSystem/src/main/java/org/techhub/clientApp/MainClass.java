package org.techhub.clientApp;

import java.util.Scanner;

import java.util.Scanner;
import org.techhub.controller.AdminPannel;
import org.techhub.controller.UserPanel;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class MainClass {
	static int count=0;
	static Logger logger = Logger.getLogger(MainClass.class);
	   static {
		   SimpleLayout layout=new SimpleLayout();
		   ConsoleAppender appender=new ConsoleAppender(layout);
		   logger.addAppender(appender);
		   logger.setLevel(Level.DEBUG);
	   }


	public static void main(String[] args) {
	
		logger.debug("Main method Started and Admin service and User service created");
	Scanner scn = new Scanner(System.in);
		
		do {
			System.out.println("1.Admin Pannel");
			System.out.println("2. user Pannel");
			
			System.out.println("Enter choice ");
			int choice = scn.nextInt();
			
			switch(choice) {
						case 1:
				        AdminPannel.AdminLogin();
			            break;
						case 2:
							UserPanel.UserDashboard();
							break;
				
					
				
						default:
							System.out.println("ENTER VALID CHOICE ");
			
			}
			
		}while(true);
		
	}
		
}

