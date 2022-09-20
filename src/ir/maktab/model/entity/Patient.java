package ir.maktab.model.entity;

import java.util.List;
import java.util.Objects;

public class Patient {
    private String firstname;
    private String lastname;
    private String nationalCode;
    private String mobilePhone;
    private String username;
    private String password;
    private List<Prescription> prescription;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(firstname, patient.firstname) && Objects.equals(lastname, patient.lastname) && Objects.equals(nationalCode, patient.nationalCode) && Objects.equals(mobilePhone, patient.mobilePhone) && Objects.equals(username, patient.username) && Objects.equals(password, patient.password) && Objects.equals(prescription, patient.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, nationalCode, mobilePhone, username, password, prescription);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", prescription=" + prescription +
                '}';
    }
}
