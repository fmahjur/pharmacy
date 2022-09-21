package ir.maktab.model.entity;

import java.util.Objects;

public class Item {
    private int prescriptionId;
    private String drugName;
    private double price;
    private boolean doesExist;

    public Item() {
    }

    public Item(int prescriptionId, String drugName) {
        this.prescriptionId = prescriptionId;
        this.drugName = drugName;
    }

    public Item(int prescriptionId, String drugName, double price, boolean doesExist) {
        this.prescriptionId = prescriptionId;
        this.drugName = drugName;
        this.price = price;
        this.doesExist = doesExist;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return prescriptionId == item.prescriptionId && Double.compare(item.price, price) == 0 && doesExist == item.doesExist && Objects.equals(drugName, item.drugName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, drugName, price, doesExist);
    }

    @Override
    public String toString() {
        return "item{" +
                "prescriptionId=" + prescriptionId +
                ", name='" + drugName + '\'' +
                ", price=" + price +
                ", doesExist=" + doesExist +
                '}';
    }
}
