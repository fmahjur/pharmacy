package ir.maktab.service.interfaces;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;

import java.util.List;

public interface AdminService {
    List<Prescription> getUnCheckedPrescription() throws Exception;

    Prescription getPrescription(int prescriptionId) throws Exception;

    boolean isExpirePrescription(Prescription prescription);

    double calculateTotalPrescription(int prescriptionId) throws Exception;

    void confirmPrescription(Prescription prescription) throws Exception;

    void failPrescription(Prescription prescription) throws Exception;

    void waitingStatusPrescription(Prescription prescription) throws Exception;

    List<Item> checkItem(Prescription prescription) throws Exception;

    void checkExistItem(Item item, boolean doesExist) throws Exception;

    void addPriceItem(Item item) throws Exception;
}
