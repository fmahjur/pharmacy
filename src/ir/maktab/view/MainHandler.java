package ir.maktab.view;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainHandler {
    AdminView adminView = AdminView.getInstance();
    PatientView patientView = PatientView.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void adminStart() throws Exception {
        System.out.println("• 1 : view UnChecked Prescriptions");
        System.out.println("• 2 : check Prescription");
        System.out.println("• 3 : check Prescription's Items");
        System.out.println("• 4 : enter Item's Price");
        System.out.println("• 5 : Exit");
        System.out.print("Enter your choice : ");
        String choice = scanner.next();
        switch (choice) {
            case "1" -> adminView.viewUnCheckedPrescriptions();
            case "2" -> adminView.checkPrescription();
            case "3" -> adminView.checkPrescriptionItems();
            case "4" -> adminView.enterItemPrice();
            case "5" -> exit(0);
            default -> {
                System.out.println("Invalid input! Please input again!");
                patientStart();
            }
        }
    }

    public void patientStart() throws Exception {
        System.out.println("• 1 : Login");
        System.out.println("• 2 : Create patient account");
        System.out.println("• 3 : Exit");
        System.out.print("Enter your choice : ");
        String choice = scanner.next();
        switch (choice) {
            case "1" -> patientView.login();
            case "2" -> patientView.signUp();
            case "3" -> exit(0);
            default -> {
                System.out.println("Invalid input! Please input again!");
                patientStart();
            }
        }
    }

    public void setPatientViewAfterLogin(int patientId) throws Exception {
        System.out.println("• 1 : Add new Prescription");
        System.out.println("• 2 : Delete Prescription");
        System.out.println("• 3 : Edit Prescription's Items");
        System.out.println("• 4 : Exit");
        System.out.print("Enter your choice : ");
        String choice = scanner.next();
        switch (choice) {
            case "1" -> patientView.addPrescription(patientId);
            case "2" -> patientView.deletePrescription(patientId);
            case "3" -> patientView.editPrescriptionItems(patientId);
            case "5" -> exit(0);
            default -> {
                System.out.println("Invalid input! Please input again!");
                adminStart();
            }
        }
    }
}
