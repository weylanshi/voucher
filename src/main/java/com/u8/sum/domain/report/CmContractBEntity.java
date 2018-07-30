package com.u8.sum.domain.report;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CmContractBEntity {
    private String guid;

    private String strContractId;//合同编码
    private String strContractKind;//合同类型
    private String strBisectionUnit;//客户or供应商编码
    private String cCusName;
    private String strContractName;//合同名称
    private String strContractOrderDate;//合同签订日期
    private String strContractStartDate;//合同开始日期
    private String strContractEndDate;//合同结束日期
    private String strCurrency;//合同币种
    private Double dblExchange;//汇率
    private Double dblTotalCurrency;//合同总金额
    private String strWay;
    private String cDefine10;

    @Basic
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    @Basic
    @Column(name = "strbisectionunit")
    public String getStrBisectionUnit() {
        return strBisectionUnit;
    }

    public void setStrBisectionUnit(String strBisectionUnit) {
        this.strBisectionUnit = strBisectionUnit;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "strcontractid")
    public String getStrContractId() {
        return strContractId;
    }

    public void setStrContractId(String strContractId) {
        this.strContractId = strContractId;
    }

    @Basic
    @Column(name = "strcontractkind")
    public String getStrContractKind() {
        return strContractKind;
    }

    public void setStrContractKind(String strContractKind) {
        this.strContractKind = strContractKind;
    }

    @Basic
    @Column(name = "strcontractname")
    public String getStrContractName() {
        return strContractName;
    }

    public void setStrContractName(String strContractName) {
        this.strContractName = strContractName;
    }
    @Basic
    @Column(name = "strcontractorderdate")
    public String getStrContractOrderDate() {
        return strContractOrderDate;
    }

    public void setStrContractOrderDate(String strContractOrderDate) {
        this.strContractOrderDate = strContractOrderDate;
    }

    @Basic
    @Column(name = "strcontractstartdate")
    public String getStrContractStartDate() {
        return strContractStartDate;
    }

    public void setStrContractStartDate(String strContractStartDate) {
        this.strContractStartDate = strContractStartDate;
    }

    @Basic
    @Column(name = "strcontractenddate")
    public String getStrContractEndDate() {
        return strContractEndDate;
    }

    public void setStrContractEndDate(String strContractEndDate) {
        this.strContractEndDate = strContractEndDate;
    }

    @Basic
    @Column(name = "strcurrency")
    public String getStrCurrency() {
        return strCurrency;
    }

    public void setStrCurrency(String strCurrency) {
        this.strCurrency = strCurrency;
    }

    @Basic
    @Column(name = "dblexchange")
    public Double getDblExchange() {
        return dblExchange;
    }

    public void setDblExchange(Double dblExchange) {
        this.dblExchange = dblExchange;
    }

    @Basic
    @Column(name = "dbltotalcurrency")
    public Double getDblTotalCurrency() {
        return dblTotalCurrency;
    }

    public void setDblTotalCurrency(Double dblTotalCurrency) {
        this.dblTotalCurrency = dblTotalCurrency;
    }
    @Basic
    @Column(name = "ccusname")
    public String getcCusName() {
        return cCusName;
    }

    public void setcCusName(String cCusName) {
        this.cCusName = cCusName;
    }
    @Basic
    @Column(name = "strway")
    public String getStrWay() {
        return strWay;
    }

    public void setStrWay(String strWay) {
        this.strWay = strWay;
    }
    @Basic
    @Column(name = "cdefine10")
    public String getcDefine10() {
        return cDefine10;
    }

    public void setcDefine10(String cDefine10) {
        this.cDefine10 = cDefine10;
    }
}
