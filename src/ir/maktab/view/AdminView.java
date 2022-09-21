package ir.maktab.view;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.impl.AdminServiceImpl;
import ir.maktab.service.impl.PrescriptionServiceImpl;

import java.util.Scanner;

public class AdminView {
    private static AdminView instance = new AdminView();

    private AdminView() {
    }

    public static AdminView getInstance() {
        return instance;
    }
    AdminServiceImpl adminService = AdminServiceImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void viewUnCheckedPrescriptions() throws Exception {
        System.out.println("| PrescriptionId | PatientName |    Date    ");
        System.out.println("--------------------------------------------");
        for (Prescription prescription : adminService.getUnCheckedPrescription()) {
            System.out.print("|       " + prescription.getId() + "       |     ");
            System.out.print(prescription.getPatient().getUsername() + "     | ");
            System.out.println(prescription.getDate() + " |");
            System.out.println("--------------------------------------------");
        }
    }

    public void checkPrescription() throws Exception {
        System.out.print("enter prescriptionId for check: ");
        int prescriptionId = scanner.nextInt();
        Prescription prescription = adminService.getPrescription(prescriptionId);
        if (adminService.isExpirePrescription(prescription)) {
            adminService.waitingStatusPrescription(prescription);
            viewPrescriptionItems(prescriptionId);
        }
    }

    public void viewPrescriptionItems(int prescriptionId) throws Exception {
        System.out.println("| DrugName |");
        System.out.println("------------");
        for (Item item : adminService.checkItem(adminService.getPrescription(prescriptionId))) {
            System.out.print("|       " + item.getDrugName() + "       |     ");
            System.out.println("------------");
        }
    }

    public void checkPrescriptionItems() throws Exception {
        System.out.print("enter prescriptionId for check prescription item: ");
        int prescriptionId = scanner.nextInt();
        for (Item item : adminService.checkItem(adminService.getPrescription(prescriptionId))) {
            System.out.print(item.getDrugName() + "is Exist? (Y/N): ");
            String choices = scanner.next();
            if (choices.equalsIgnoreCase("Y"))
                adminService.checkExistItem(item, true);
            else if (choices.equalsIgnoreCase("N")) {
                adminService.checkExistItem(item, false);
            }
        }
    }

    public void enterItemPrice() throws Exception {
        System.out.print("enter prescriptionId for check prescription item: ");
        int prescriptionId = scanner.nextInt();
        for (Item item : adminService.checkItem(adminService.getPrescription(prescriptionId))) {
            System.out.print("please enter price for " + item.getDrugName() + ": ");
            double price = scanner.nextDouble();
            item.setPrice(price);
            adminService.addPriceItem(item);
        }
    }

    public void prescriptionApprovalStatus(int prescriptionId) throws Exception {
        for (Item item : adminService.checkItem(adminService.getPrescription(prescriptionId))) {
            if (!item.isExist())
                adminService.failPrescription(adminService.getPrescription(prescriptionId));
        }
        adminService.confirmPrescription(adminService.getPrescription(prescriptionId));
    }

}
