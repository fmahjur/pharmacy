package ir.pharmacy.model.entity;

import java.util.Objects;

public class Item {
    private int prescriptionId;
    private String name;
    private double price;
    private boolean doesExist;

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDoesExist() {
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
        return prescriptionId == item.prescriptionId && Double.compare(item.price, price) == 0 && doesExist == item.doesExist && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, name, price, doesExist);
    }

    @Override
    public String toString() {
        return "item{" +
                "prescriptionId=" + prescriptionId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", doesExist=" + doesExist +
                '}';
    }
}
