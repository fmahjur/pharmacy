package ir.maktab.view;

import ir.maktab.model.entity.Patient;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.impl.PatientServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PatientView {
    private static PatientView instance = new PatientView();

    private PatientView() {
    }

    public static PatientView getInstance() {
        return instance;
    }

    PatientServiceImpl patientService = PatientServiceImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void login() throws Exception {
        System.out.print("please enter your username: ");
        String username = scanner.next();
        System.out.print("please enter your password: ");
        String password = scanner.next();
        Patient patient = new Patient(username, password);
        patient.setId(patientService.login(patient));
        MainHandler mainHandler = new MainHandler();
        mainHandler.setPatientViewAfterLogin(patient.getId());
    }

    public void signUp() throws Exception {
        System.out.print("please enter your firstname: ");
        String firstname = scanner.next();
        System.out.print("please enter your lastname: ");
        String lastname = scanner.next();
        System.out.print("please enter your nationalCode: ");
        String nationalCode = scanner.next();
        System.out.print("please enter your mobilePhone: ");
        String mobilePhone = scanner.next();
        Patient patient = new Patient(firstname, lastname, nationalCode, mobilePhone);
        patient.setId(patientService.signUp(patient));
        MainHandler mainHandler = new MainHandler();
        mainHandler.setPatientViewAfterLogin(patient.getId());
    }

    public void addPrescription(int patientId) throws Exception {
        System.out.print("please enter doctor name: ");
        String doctorName = scanner.next();
        System.out.print("please enter prescription date (yyyy-mm-dd): ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date prescriptionDate = simpleDateFormat.parse(scanner.next());
        Prescription prescription = new Prescription(patientId, doctorName, prescriptionDate);
        prescription.setId(patientService.addPrescription(prescription));
        addItem(prescription.getId());
    }

    public void viewPrescriptions(int patientId) throws Exception {
        Patient patient = new Patient((patientId));
        System.out.println("| PrescriptionId | Check Status | ApprovalStatus | total ");
        System.out.println("--------------------------------------------------------");
        for (Prescription prescription : patientService.getPrescriptions(patient)) {
            System.out.print("|       " + prescription.getId() + "       |     ");
            System.out.print(prescription.isCheckStatus() + "     |      ");
            System.out.println(prescription.isApprovalStatus() + "      |");
            System.out.println("--------------------------------------------------------");
        }
    }

    public void deletePrescription(int patientId) throws Exception {
        Prescription prescription = new Prescription((patientId));
        patientService.deletePrescription(prescription);
    }

    public void editPrescriptionItems(int patientId) throws Exception {
        Prescription prescription = new Prescription((patientId));
        System.out.println("for edit item, you should delete this at first and then add again!");
        deleteItem(prescription.getId());
    }

    public void addItem(int prescriptionID) throws Exception {
        System.out.println("please enter prescription item name: ");
        String drugName = scanner.next();
        patientService.addItemsPrescription(prescriptionID, drugName);
    }

    public void deleteItem(int prescriptionID) throws Exception {
        System.out.println("please enter prescription item name for deleted: ");
        String drugName = scanner.next();
        patientService.deleteItemPrescription(prescriptionID, drugName);
    }

}
