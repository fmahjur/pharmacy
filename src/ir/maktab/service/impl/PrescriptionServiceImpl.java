package ir.maktab.service.impl;

import ir.maktab.model.dao.PrescriptionDao;
import ir.maktab.model.entity.Medicine;
import ir.maktab.model.entity.Patient;

import java.util.Date;
import java.util.List;

public class PrescriptionServiceImpl {
    PrescriptionDao prescriptionDao = PrescriptionDao.getInstance();

    public void addPrescription(Patient patient, String doctorName, Date date, List<Medicine> medicineList) {


    }
}
