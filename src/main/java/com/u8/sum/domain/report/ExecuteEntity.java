package com.u8.sum.domain.report;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExecuteEntity {
    private String guid;
    private String cExecID;
    private String cContractID;
    private String dtProduceDate;
    private String strContractName;
    private String strContractKind;
    private Double decRateMoney;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
    @Column(name = "cexecid")
    public String getcExecID() {
        return cExecID;
    }

    public void setcExecID(String cExecID) {
        this.cExecID = cExecID;
    }
    @Column(name = "ccontractid")
    public String getcContractID() {
        return cContractID;
    }

    public void setcContractID(String cContractID) {
        this.cContractID = cContractID;
    }
    @Column(name = "dtproducedate")
    public String getDtProduceDate() {
        return dtProduceDate;
    }

    public void setDtProduceDate(String dtProduceDate) {
        this.dtProduceDate = dtProduceDate;
    }
    @Column(name = "strcontractname")
    public String getStrContractName() {
        return strContractName;
    }

    public void setStrContractName(String strContractName) {
        this.strContractName = strContractName;
    }
    @Column(name = "strcontractkind")
    public String getStrContractKind() {
        return strContractKind;
    }

    public void setStrContractKind(String strContractKind) {
        this.strContractKind = strContractKind;
    }

    @Column(name = "decratemoney")
    public Double getDecRateMoney() {
        return decRateMoney;
    }

    public void setDecRateMoney(Double decRateMoney) {
        this.decRateMoney = decRateMoney;
    }
}
