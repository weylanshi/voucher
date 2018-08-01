package com.u8.sum.domain.report;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AllEntity {
    private String strContractID;
    private String strContractName;
    private String strCurrency;
    private String dblTotalCurrency;
    private String dblExchange;
    private String strBisectionUnit;

    @Basic
    @Id
    @Column(name = "strcontractid")
    public String getStrContractID() {
        return strContractID;
    }
    @Basic
    @Column(name = "strcontractname")
    public String getStrContractName() {
        return strContractName;
    }
    @Basic
    @Column(name = "strcurrency")
    public String getStrCurrency() {
        return strCurrency;
    }
    @Basic
    @Column(name = "dbltotalcurrency")
    public String getDblTotalCurrency() {
        return dblTotalCurrency;
    }
    @Basic
    @Column(name = "dblexchange")
    public String getDblExchange() {
        return dblExchange;
    }
    @Basic
    @Column(name = "strbisectionunit")
    public String getStrBisectionUnit() {
        return strBisectionUnit;
    }

    public void setStrContractID(String strContractID) {
        this.strContractID = strContractID;
    }

    public void setStrContractName(String strContractName) {
        this.strContractName = strContractName;
    }

    public void setStrCurrency(String strCurrency) {
        this.strCurrency = strCurrency;
    }

    public void setDblTotalCurrency(String dblTotalCurrency) {
        this.dblTotalCurrency = dblTotalCurrency;
    }

    public void setDblExchange(String dblExchange) {
        this.dblExchange = dblExchange;
    }

    public void setStrBisectionUnit(String strBisectionUnit) {
        this.strBisectionUnit = strBisectionUnit;
    }
}
