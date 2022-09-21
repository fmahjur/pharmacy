package ir.maktab.service.interfaces;

import ir.maktab.model.entity.Item;

import java.util.Date;
import java.util.List;

public interface PrescriptionService {
    void addItem(Item item) throws Exception;

    void deleteItem(int prescriptionId, String drugName) throws Exception;

    void editItemExist(Item item) throws Exception;

    void editItemPrice(Item item) throws Exception;

    boolean expireDate(Date prescriptionDate);

    List<Item> getItems(int prescriptionId) throws Exception;
}
