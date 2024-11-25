package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;

import java.util.Scanner;

public class SelectBreadTypeScreen {
    static Scanner scanner = new Scanner(System.in);

    public static Sandwich.BreadType selectBreadType(Order order) {
        boolean isRunning = true;
        BreadType breadType = null;
        while (isRunning) {
            // allows user to select their choice of sandwich type and returns choice
            System.out.println("Select bread type: \n1) White \n2) Wheat \n3) Rye \n4) Wrap \n0) Exit");
            String breadChoice = scanner.nextLine();
            switch (breadChoice) {
                case "1":
                    breadType = BreadType.WHITE;
                    break;
                case "2":
                    breadType = BreadType.WHEAT;
                    break;
                case "3":
                    breadType = BreadType.RYE;
                    break;
                case "4":
                    breadType = BreadType.WRAP;
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-4.");
                    continue;
            }
            if (breadType != null) {
                System.out.println("You selected: " + breadType + " bread.");
                isRunning = false;

        }

        }
       // order.addProduct(breadType);
        return breadType;
    }
}