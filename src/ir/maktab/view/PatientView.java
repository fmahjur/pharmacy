package ir.maktab.view;

import ir.maktab.model.entity.Patient;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.impl.PatientServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PatientView {
    PatientServiceImpl patientService = PatientServiceImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void login() throws Exception {
        System.out.print("please enter your username: ");
        String username = scanner.next();
        System.out.print("please enter your password: ");
        String password = scanner.next();
        Patient patient = new Patient(username, password);
        patient.setId(patientService.login(patient));
    }

    public void addPrescription(int patientId) throws Exception {
            System.out.print("please enter doctor name: ");
            String doctorName = scanner.next();
            System.out.print("please enter prescription date (yyyy-mm-dd): ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date prescriptionDate = simpleDateFormat.parse(scanner.next());
            Prescription prescription = new Prescription(patientId, doctorName, prescriptionDate);
            prescription.setId(patientService.addPrescription(prescription));
            addItem(prescription.getId());
    }

    public void deletePrescription(int patientId) throws Exception{
        Prescription prescription = new Prescription((patientId));
        patientService.deletePrescription(prescription);
    }

    public void addItem(int prescriptionID) throws Exception{
        System.out.println("please enter prescription item name: ");
        String drugName = scanner.next();
        patientService.addItemsPrescription(prescriptionID, drugName);
    }

    public void deleteItem(int prescriptionID) throws Exception{
        System.out.println("please enter prescription item name for deleted: ");
        String drugName = scanner.next();
        patientService.deleteItemPrescription(prescriptionID, drugName);
    }

}
