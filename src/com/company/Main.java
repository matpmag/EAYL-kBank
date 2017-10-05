package com.company;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("=== Welcome to kBank! ===");
	menu();
    }

    public static void menu(){
        boolean active = true;
        while(active){
            System.out.println("\n" +
                    "========= Menu ==========\n" +
                    "0 - Exit the kBank App\n" +
                    "1 - Create a new account\n" +
                    "========= Menu ==========\n\n" +
                    "Please enter an option:");

            Scanner scan = new Scanner(System.in);
            int optionNo;
            boolean optionActive = true;
            while(optionActive)
            try{
                optionNo = scan.nextInt();
                if(optionNo > 0 || optionNo < 2){
                    optionActive = false;
                    switch (optionNo){
                        case 0: System.exit(0);
                        case 1:
                            boolean activeOne = true;
                            String forename = "", surname = "", dateOfBirth = "", address = "", telNo = "";
                            char gender;
                            System.out.print("Please enter your first name:");
                            while (activeOne){
                                try{
                                    Scanner scanTwo = new Scanner(System.in);
                                    forename = scanTwo.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.print("\nPlease enter a valid name:");
                                }
                            }
                            System.out.print("Please enter your second name:");
                            while (activeOne){
                                try{
                                    Scanner scanTwo = new Scanner(System.in);
                                    surname = scanTwo.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.print("\nPlease enter a valid surname:");
                                }
                            }
                    }
                }else{
                    System.out.print("\nPlease enter a valid option:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid option:");
            }

        }
    }
}
