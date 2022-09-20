package ir.maktab.model.entity;

import java.util.Objects;

public class Invoice {
    private Patient patient;
    private Prescription prescription;
    private double totalBill;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.totalBill, totalBill) == 0 && Objects.equals(patient, invoice.patient) && Objects.equals(prescription, invoice.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, prescription, totalBill);
    }

    @Override
    public String toString() {
        return "invoice{" +
                "patient=" + patient +
                ", prescription=" + prescription +
                ", totalBill=" + totalBill +
                '}';
    }
}
