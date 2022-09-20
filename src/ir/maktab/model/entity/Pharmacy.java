package ir.maktab.model.entity;

import java.util.List;
import java.util.Objects;

public class Pharmacy {
    private String pharmacyName;
    private Admin admin;
    private List<medicine> medicineList;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<medicine> medicineList) {
        this.medicineList = medicineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(pharmacyName, pharmacy.pharmacyName) && Objects.equals(admin, pharmacy.admin) && Objects.equals(medicineList, pharmacy.medicineList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacyName, admin, medicineList);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyName='" + pharmacyName + '\'' +
                ", admin=" + admin +
                ", medicineList=" + medicineList +
                '}';
    }
}
