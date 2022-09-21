package ir.maktab.view;

import ir.maktab.model.entity.Prescription;
import ir.maktab.service.impl.AdminServiceImpl;
import ir.maktab.service.impl.PrescriptionServiceImpl;

public class AdminView {
    AdminServiceImpl adminService = AdminServiceImpl.getInstance();
    PrescriptionServiceImpl prescriptionService = PrescriptionServiceImpl.getInstance();

    public void viewUnCheckedPrescriptions() throws Exception{
        System.out.println("| PrescriptionId | PatientName |    Date    ");
        System.out.println("--------------------------------------------");
        for (Prescription prescription: adminService.getUnCheckedPrescription()) {
            System.out.print("|       " + prescription.getId() + "       |     ");
            System.out.print(prescription.getPatient().getUsername()+ "     | ");
            System.out.println(prescription.getDate() + " |");
            System.out.println("--------------------------------------------");
        }
    }

    public void checkPrescription(int prescriptionId) throws Exception{
        Prescription prescription = adminService.getPrescription(prescriptionId);
        if (prescriptionService.expireDate(prescription.getDate()))
            prescriptionService.getItems(prescriptionId);
    }

    public void viewPrescriptionItems(){

    }
}
