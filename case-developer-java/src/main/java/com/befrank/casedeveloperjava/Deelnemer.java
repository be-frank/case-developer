package com.befrank.casedeveloperjava;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Deelnemer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String emailAddress;
    private String phoneNumber;

    // adresgegevens
    private String adressStreet;
    private Integer addressHousenumber;
    private String addressHousenumberExtra;
    private String addressPostalCode;
    private String addressResidence;
    private String addressCountry;

    // dienstverband
    private LocalDate serviceStartDate;
    private LocalDate serviceEndDate;
    private BigDecimal serviceSalary;
    /**
     * @implSpec Waarde tussen 0 en 100
     */
    private BigDecimal serviceParttimePercentage;
    private BigDecimal serviceFranchise;
    /**
     * @implSpec Waarde tussen 0 en 100
     */
    private BigDecimal servicePremiumPercentage;
    private Long servicePensionAccountNumber;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public Integer getAddressHousenumber() {
        return addressHousenumber;
    }

    public void setAddressHousenumber(Integer addressHousenumber) {
        this.addressHousenumber = addressHousenumber;
    }

    public String getAddressHousenumberExtra() {
        return addressHousenumberExtra;
    }

    public void setAddressHousenumberExtra(String addressHousenumberExtra) {
        this.addressHousenumberExtra = addressHousenumberExtra;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressResidence() {
        return addressResidence;
    }

    public void setAddressResidence(String addressResidence) {
        this.addressResidence = addressResidence;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public LocalDate getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(LocalDate serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public LocalDate getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(LocalDate serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public BigDecimal getServiceSalary() {
        return serviceSalary;
    }

    public void setServiceSalary(BigDecimal serviceSalary) {
        this.serviceSalary = serviceSalary;
    }

    public BigDecimal getServiceParttimePercentage() {
        return serviceParttimePercentage;
    }

    public void setServiceParttimePercentage(BigDecimal serviceParttimePercentage) {
        this.serviceParttimePercentage = serviceParttimePercentage;
    }

    public BigDecimal getServiceFranchise() {
        return serviceFranchise;
    }

    public void setServiceFranchise(BigDecimal serviceFranchise) {
        this.serviceFranchise = serviceFranchise;
    }

    public BigDecimal getServicePremiumPercentage() {
        return servicePremiumPercentage;
    }

    public void setServicePremiumPercentage(BigDecimal servicePremiumPercentage) {
        this.servicePremiumPercentage = servicePremiumPercentage;
    }

    public Long getServicePensionAccountNumber() {
        return servicePensionAccountNumber;
    }

    public void setServicePensionAccountNumber(Long servicePensionAccountNumber) {
        this.servicePensionAccountNumber = servicePensionAccountNumber;
    }
}
