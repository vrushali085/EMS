package org.techhub.clientApp;

import java.util.Scanner;

import org.techhub.controller.AdminPannel;
import org.techhub.controller.UserPanel;

public class MainClass {

	public static void main(String[] args) {
		
	Scanner scn = new Scanner(System.in);
		
		do {
			System.out.println("1.Admin Pannel");
			System.out.println("2. user Pannel");
			
			System.out.println("Enter choice ");
			int choice = scn.nextInt();
			
			switch(choice) {
						//case 1:
				       //  AdminPannel.AdminLogin();
				//break;2
						case 2:
							UserPanel.UserDashboard();
							break;
				
					
				
						default:
							System.out.println("ENTER VALID CHOICE ");
			
			}
			
		}while(true);
	}
		
}

