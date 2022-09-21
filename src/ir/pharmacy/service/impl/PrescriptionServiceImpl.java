package ir.pharmacy.service.impl;

import ir.pharmacy.model.dao.ItemDao;
import ir.pharmacy.model.dao.PrescriptionDao;
import ir.pharmacy.model.entity.Item;
import ir.pharmacy.service.interfaces.PrescriptionService;

import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {
    ItemDao itemDao = ItemDao.getInstance();
    private static PrescriptionServiceImpl instance;

    private PrescriptionServiceImpl() {
    }

    public static PrescriptionServiceImpl getInstance() {
        if (instance == null)
            return new PrescriptionServiceImpl();
        return instance;
    }

    public void addItem(Item item) throws Exception {
        itemDao.insertItem(item);
    }

    public void deleteItem(int prescriptionId, String drugName) throws Exception {
        itemDao.deleteItem(prescriptionId, drugName);
    }

    public void editItemExist(Item item) throws Exception {
        itemDao.updateItemExist(item);
    }

    public void editItemPrice(Item item) throws Exception {
        itemDao.updateItemPrice(item);
    }

    public List<Item> getItems(int prescriptionId) throws Exception {
        return itemDao.selectItems(prescriptionId);
    }
}
