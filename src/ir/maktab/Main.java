package ir.maktab;

import ir.maktab.view.MainHandler;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("• 1 : Admin");
        System.out.println("• 2 : Patient");
        System.out.println("• 3 : Exit");
        System.out.print("Enter your choice : ");
        String choice;
        choice = scanner.next();
        switch (choice) {
            case "1" -> {
                MainHandler startAdminMenu = new MainHandler();
                startAdminMenu.adminStart();
            }
            case "2" -> {
                MainHandler startPatientMenu = new MainHandler();
                startPatientMenu.patientStart();
            }
            case "3" -> exit(0);
            default -> System.out.println("Invalid input! Please input again!");
        }
    }
}
