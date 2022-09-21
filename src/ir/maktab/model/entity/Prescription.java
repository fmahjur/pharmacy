package ir.maktab.model.entity;

import java.util.Date;
import java.util.Objects;

public class Prescription {
    private int id;
    private Patient patient;
    private String doctorName;
    private Date date;
    private boolean checkStatus;
    private boolean approvalStatus;

    public Prescription() {
    }

    public Prescription(int id) {
        this.id = id;
    }

    public Prescription(int patientId, String doctorName, Date date) {
        this.patient = new Patient(patientId);
        this.doctorName = doctorName;
        this.date = date;
    }

    public Prescription(int id, int patientId, String doctorName, Date date) {
        this.id = id;
        this.patient = new Patient(patientId);
        this.doctorName = doctorName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return id == that.id && checkStatus == that.checkStatus && approvalStatus == that.approvalStatus && Objects.equals(patient, that.patient) && Objects.equals(doctorName, that.doctorName) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctorName, date, checkStatus, approvalStatus);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                ", checkStatus=" + checkStatus +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}
