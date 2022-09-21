package ir.maktab.service.impl;

import ir.maktab.model.dao.PrescriptionDao;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.interfaces.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    PrescriptionDao prescriptionDao = PrescriptionDao.getInstance();
    PrescriptionServiceImpl prescriptionService = PrescriptionServiceImpl.getInstance();

    public boolean addPrescription(Prescription prescription, List<Item> items) throws Exception {
        prescription.setId(prescriptionDao.insertPrescription(prescription));
        if (items.size() <= 10) {
            for (Item item : items) {
                item.setPrescriptionId(prescription.getId());
                prescriptionService.addItem(item);
            }
            return true;
        }
        return false;
    }

    public void deletePrescription(Prescription prescription) throws Exception {
        prescriptionDao.deletePrescription(prescription.getId());
    }

    public void deleteItemPrescription(Prescription prescription, String drugName) throws Exception {
        prescriptionService.deleteItem(prescription.getId(), drugName);
    }
}
