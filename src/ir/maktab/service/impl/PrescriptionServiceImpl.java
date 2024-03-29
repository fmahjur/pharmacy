package ir.maktab.service.impl;

import ir.maktab.model.dao.ItemDao;
import ir.maktab.model.entity.Item;
import ir.maktab.service.interfaces.PrescriptionService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {
    private static PrescriptionServiceImpl instance = new PrescriptionServiceImpl();

    private PrescriptionServiceImpl() {
    }

    public static PrescriptionServiceImpl getInstance() {
        return instance;
    }

    ItemDao itemDao = ItemDao.getInstance();

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
        return prescriptionExpireDate.getTime().compareTo(nowDate) >= 0;
    }

    public double calculateTotal(int prescriptionId) throws Exception{
        double prescriptionTotal = 0;
        for (Item item: getItems(prescriptionId))
            prescriptionTotal += item.getPrice();
        return prescriptionTotal;
    }

    public List<Item> getItems(int prescriptionId) throws Exception {
        return itemDao.selectItems(prescriptionId);
    }
}
