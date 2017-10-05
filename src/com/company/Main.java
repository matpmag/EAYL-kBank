package com.company;

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
            int option;
            boolean optionActive = true;
            while(optionActive)
            try{
                option = scan.nextInt();
                if(option > 0 || option < 2){
                    optionActive = false;
                }
            } catch (InputMismatchException e) {

            }

        }
    }
}
