package org.techhub.clientApp;

import java.util.Scanner;

import org.techhub.controller.AdminPannel;
import org.techhub.controller.HRPanel;

public class MainClass {

	public static void main(String[] args) {
		
	Scanner scn = new Scanner(System.in);
		
		do {
			System.out.println("1.Admin Pannel");
			System.out.println("2. HR Pannel");
			System.out.println("3.User Employee Panel");
			
			System.out.println("Enter choice ");
			int choice = scn.nextInt();
			
			switch(choice) {
						case 1:
				         AdminPannel.AdminLogin();
				break;
						case 2:
							HRPanel.HRLogin();
							break;
						case 3:
							break;
				
				
					
				
						default:
							System.out.println("ENTER VALID CHOICE ");
			
			}
			
		}while(true);
	}
		
}

