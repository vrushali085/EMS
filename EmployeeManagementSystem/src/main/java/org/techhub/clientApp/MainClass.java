package org.techhub.clientApp;

import java.util.Scanner;

import org.techhub.controller.AdminPannel;

public class MainClass {

	public static void main(String[] args) {   //main class
		
	Scanner scn = new Scanner(System.in);
		
		do {
			System.out.println("1.Admin Pannel");
			System.out.println("2.Customer Pannel");
			
			System.out.println("Enter choice ");
			int choice = scn.nextInt();
			
			switch(choice) {
						case 1:
				//AdminPannel.adminOperation();
				break;
			
			}
			
		}while(true);
	}
		
}

