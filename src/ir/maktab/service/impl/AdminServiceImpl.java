package ir.maktab.service.impl;

import ir.maktab.model.dao.PrescriptionDao;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.interfaces.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    PrescriptionDao prescriptionDao = PrescriptionDao.getInstance();
    PrescriptionServiceImpl prescriptionService = PrescriptionServiceImpl.getInstance();

    public boolean confirmPrescription(Prescription prescription) throws Exception {
        prescription.setApprovalStatus(true);
        return prescriptionDao.updateApprovalStatusPrescription(prescription);
    }

    public boolean failPrescription(Prescription prescription) throws Exception {
        prescription.setApprovalStatus(false);
        return prescriptionDao.updateApprovalStatusPrescription(prescription);
    }

    public Boolean waitingStatusPrescription(Prescription prescription) throws Exception {
        prescription.setCheckStatus(true);
        return prescriptionDao.updateApprovalStatusPrescription(prescription);
    }

    public List<Item> checkItem(Prescription prescription) throws Exception {
        waitingStatusPrescription(prescription);
        return prescriptionService.getItems(prescription.getId());
    }

    public void checkExistItem(Item item, boolean doesExist) throws Exception {
        item.setDoesExist(doesExist);
        prescriptionService.editItemExist(item);
    }

    public void addPriceItem(Item item, double price) throws Exception {
        item.setPrice(price);
        prescriptionService.editItemPrice(item);
    }
}
