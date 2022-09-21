package ir.pharmacy.service.interfaces;

import ir.pharmacy.model.entity.Item;
import ir.pharmacy.model.entity.Prescription;

import java.util.List;

public interface AdminService {
    boolean confirmPrescription(Prescription prescription) throws Exception;

    boolean failPrescription(Prescription prescription) throws Exception;

    Boolean waitingStatusPrescription(Prescription prescription) throws Exception;

    List<Item> checkItem(Prescription prescription) throws Exception;

    void checkExistItem(Item item, boolean doesExist) throws Exception;

    void addPriceItem(Item item, double price) throws Exception;
}
