package ir.maktab.service.impl;

import ir.maktab.model.dao.ItemDao;
import ir.maktab.model.entity.Item;
import ir.maktab.service.interfaces.PrescriptionService;

import java.util.Calendar;
import java.util.Date;
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

    public boolean expireDate(Date prescriptionDate) {
        Calendar prescriptionExpireDate = Calendar.getInstance();
        prescriptionExpireDate.setTime(prescriptionDate);
        prescriptionExpireDate.add(Calendar.MONTH, 1);
        Date nowDate = new Date();
        if (prescriptionExpireDate.getTime().compareTo(nowDate) >= 0)
            return true;
        return false;
    }

    public List<Item> getItems(int prescriptionId) throws Exception {
        return itemDao.selectItems(prescriptionId);
    }
}
