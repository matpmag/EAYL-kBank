package com.company;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Date;
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
            System.out.print("\n" +
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
                if(optionNo > 0 && optionNo < 2){
                    optionActive = false;
                    switch (optionNo){
                        case 0: System.exit(0);
                        case 1: createAccount(); break;
                    }
                }else{
                    System.out.print("\nPlease enter a valid option:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid option:");
            }

        }
    }
    public static void createAccount(){
        boolean activeOne = true;
        String forename, surname, address, telNo;
        Date dateOfBirth;
        char gender;
        System.out.print("Please enter your first name:");
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                forename = scanTwo.nextLine();
                if(isLetters(forename)){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid name:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid name:");
            }
        }
        System.out.print("Please enter your second name:");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                surname = scanTwo.nextLine();
                if(isLetters(surname)){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid surname:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid surname:");
            }
        }
        System.out.print("Please enter your address:");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                address = scanTwo.nextLine();
                if(isLetters(address)){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid address:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid address:");
            }
        }
        System.out.print("Please enter your gender(m or f):");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                char[] genderString = scanTwo.nextLine().toLowerCase().toCharArray();
                if(genderString.length == 1 && (genderString[0] == 'm' || genderString[0] == 'f')){
                    gender = genderString[0];
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid gender(m or f):");
                }

            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid gender(m or f):");
            }
        }
        System.out.print("Please enter your phone number:");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                telNo = scanTwo.nextLine();
                if(isLetters(telNo)){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid phone number:");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid phone number:");
            }
        }

        int year = 1900, month = 12, day = 31;
        System.out.print("Please enter your year of birth(YYYY):");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                year = scanTwo.nextInt();
                if(year > 1850 && year < 2015){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid year(YYYY):");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid year(YYYY):");
            }
        }
        System.out.print("Please enter your month of birth(MM):");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                month = scanTwo.nextInt();
                if(month > 0 && month < 13){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid month(MM):");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid month(MM):");
            }
        }
        System.out.print("Please enter your day of birth(DD):");
        activeOne = true;
        while (activeOne){
            try{
                Scanner scanTwo = new Scanner(System.in);
                day = scanTwo.nextInt();
                if(day > 0 && day < 32){
                    activeOne = false;
                } else {
                    System.out.print("\nPlease enter a valid day(DD):");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nPlease enter a valid day(DD):");
            }
        }
        dateOfBirth = new Date(year, month, day);
    }

    public static boolean isLetters(String input){
        return input.matches("[a-zA-Z]+");
    }
}
