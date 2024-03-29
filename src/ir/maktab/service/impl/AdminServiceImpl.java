package ir.maktab.service.impl;

import ir.maktab.model.dao.PrescriptionDao;
import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;
import ir.maktab.service.interfaces.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static AdminServiceImpl instance = new AdminServiceImpl();

    private AdminServiceImpl() {
    }

    public static AdminServiceImpl getInstance() {
        return instance;
    }

    PrescriptionDao prescriptionDao = PrescriptionDao.getInstance();
    PrescriptionServiceImpl prescriptionService = PrescriptionServiceImpl.getInstance();

    public List<Prescription> getUnCheckedPrescription() throws Exception {
        return prescriptionDao.selectPrescriptionByCheckStatus();
    }

    public Prescription getPrescription(int prescriptionId) throws Exception {
        return prescriptionDao.selectPrescriptionById(prescriptionId);
    }

    public boolean isExpirePrescription(Prescription prescription) {
        return prescriptionService.expireDate(prescription.getDate());
    }

    public double calculateTotalPrescription(int prescriptionId) throws Exception {
        return prescriptionService.calculateTotal(prescriptionId);
    }

    public void confirmPrescription(Prescription prescription) throws Exception {
        prescription.setApprovalStatus(true);
        prescriptionDao.updateApprovalStatusPrescription(prescription);
    }

    public void failPrescription(Prescription prescription) throws Exception {
        prescription.setApprovalStatus(false);
        prescriptionDao.updateApprovalStatusPrescription(prescription);
    }

    public void waitingStatusPrescription(Prescription prescription) throws Exception {
        prescription.setCheckStatus(true);
        prescriptionDao.updateCheckStatusPrescription(prescription);
    }

    public List<Item> checkItem(Prescription prescription) throws Exception {
        waitingStatusPrescription(prescription);
        return prescriptionService.getItems(prescription.getId());
    }

    public void checkExistItem(Item item, boolean doesExist) throws Exception {
        item.setDoesExist(doesExist);
        prescriptionService.editItemExist(item);
    }

    public void addPriceItem(Item item) throws Exception {
        prescriptionService.editItemPrice(item);
    }
}
