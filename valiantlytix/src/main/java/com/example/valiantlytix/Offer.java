package com.example.valiantlytix;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Offer
{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String offerName;
    private String offerDescription;
    private BigDecimal numberOfPoints;
    private BigDecimal cashRebate;
    private String startDate;
    private String endDate;

    public boolean isItPending()
    {
        return isItPending;
    }

    public void setItPending(boolean itPending)
    {
        isItPending = itPending;
    }

    private boolean isItPending;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public BigDecimal getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(BigDecimal numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public BigDecimal getCashRebate() {
        return cashRebate;
    }

    public void setCashRebate(BigDecimal cashRebate) {
        this.cashRebate = cashRebate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString()
    {
        return String.format("ID: %s, Offer Name: %s, Offer Description: %s, Cash Rebate: %s, End Date: %s, Number Of Points: %s",getId(),getOfferName(),getOfferDescription(),getCashRebate(),getEndDate(),getNumberOfPoints());
    }
}
