package ir.maktab.service.impl;

import ir.maktab.model.dao.PatientDao;
import ir.maktab.model.entity.Patient;
import ir.maktab.service.interfaces.PatientService;

public class PatientServiceImpl implements PatientService {
    PatientDao patientDao = PatientDao.getInstance();

    public void addPatient(Patient patient) throws Exception {
        patientDao.insertPatient(patient);
    }

    public void deletePatient(String username) throws Exception {
        patientDao.deletePatient(username);
    }

    public Patient logIn(String username, String password) throws Exception {
        return patientDao.patientValidation(username, password);
    }

}
