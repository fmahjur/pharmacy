package ir.maktab.service.impl;

import ir.maktab.model.dao.PatientDao;
import ir.maktab.model.dao.PrescriptionDao;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Patient;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.interfaces.PatientService;

public class PatientServiceImpl implements PatientService {
    private static PatientServiceImpl instance = new PatientServiceImpl();

    private PatientServiceImpl() {
    }

    public static PatientServiceImpl getInstance() {
        return instance;
    }

    PatientDao patientDao = PatientDao.getInstance();
    PrescriptionDao prescriptionDao = PrescriptionDao.getInstance();
    PrescriptionServiceImpl prescriptionService = PrescriptionServiceImpl.getInstance();

    public int login(Patient patient) throws Exception {
        return patientDao.patientValidation(patient).getId();
    }

    public int signUp(Patient patient) throws Exception {
        return patientDao.insertPatient(patient);
    }

    public int addPrescription(Prescription prescription) throws Exception {
        prescription.setId(prescriptionDao.insertPrescription(prescription));
        return prescription.getId();
    }

    public void deletePrescription(Prescription prescription) throws Exception {
        prescriptionDao.deletePrescription(prescription.getId());
    }

    public void addItemsPrescription(int prescriptionId, String drugName) throws Exception {
        Item item = new Item(prescriptionId, drugName);
        prescriptionService.addItem(item);
    }

    public void deleteItemPrescription(int prescriptionId, String drugName) throws Exception {
        prescriptionService.deleteItem(prescriptionId, drugName);
    }
}
