package ir.pharmacy.service.interfaces;

import ir.pharmacy.model.entity.Item;

import java.util.List;

public interface PrescriptionService {
    void addItem(Item item) throws Exception;
    void deleteItem(int prescriptionId, String drugName) throws Exception;

    void editItemExist(Item item) throws Exception;
    public void editItemPrice(Item item) throws Exception;

    List<Item> getItems(int prescriptionId) throws Exception;
}
