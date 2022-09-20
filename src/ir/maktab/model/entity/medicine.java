package ir.maktab.model.entity;

import java.util.Objects;

public class medicine {
    private String name;
    private double price;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        medicine medicine = (medicine) o;
        return Double.compare(medicine.price, price) == 0 && Objects.equals(name, medicine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "medicine{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
