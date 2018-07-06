package com.u8.sum.domain.report;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CM_Contract_B", schema = "dbo", catalog = "UFDATA_100_2018")
public class CmContractBEntity {
    private String guid;
    private String strContractId;//合同编码
    private String strContractKind;//合同类型
    private String strContractName;//合同名称
    private String strContractStartDate;//合同开始日期
    private String strContractEndDate;//合同结束日期
    private String strCurrency;//合同币种
    private Double dblExchange;//汇率
    private Double dblTotalCurrency;//合同总金额

    @Basic
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "guid")
    public String getGuid() {
        return guid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CmContractBEntity that = (CmContractBEntity) o;

        if (guid != null ? !guid.equals(that.guid) : that.guid != null) return false;
        if (strContractId != null ? !strContractId.equals(that.strContractId) : that.strContractId != null)
            return false;
        if (strContractKind != null ? !strContractKind.equals(that.strContractKind) : that.strContractKind != null)
            return false;
        if (strContractName != null ? !strContractName.equals(that.strContractName) : that.strContractName != null)
            return false;
        if (strContractStartDate != null ? !strContractStartDate.equals(that.strContractStartDate) : that.strContractStartDate != null)
            return false;
        if (strContractEndDate != null ? !strContractEndDate.equals(that.strContractEndDate) : that.strContractEndDate != null)
            return false;
        if (strCurrency != null ? !strCurrency.equals(that.strCurrency) : that.strCurrency != null) return false;
        if (dblExchange != null ? !dblExchange.equals(that.dblExchange) : that.dblExchange != null) return false;
        if (dblTotalCurrency != null ? !dblTotalCurrency.equals(that.dblTotalCurrency) : that.dblTotalCurrency != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (strContractId != null ? strContractId.hashCode() : 0);
        result = 31 * result + (strContractKind != null ? strContractKind.hashCode() : 0);
        result = 31 * result + (strContractName != null ? strContractName.hashCode() : 0);
        result = 31 * result + (strContractStartDate != null ? strContractStartDate.hashCode() : 0);
        result = 31 * result + (strContractEndDate != null ? strContractEndDate.hashCode() : 0);
        result = 31 * result + (strCurrency != null ? strCurrency.hashCode() : 0);
        result = 31 * result + (dblExchange != null ? dblExchange.hashCode() : 0);
        result = 31 * result + (dblTotalCurrency != null ? dblTotalCurrency.hashCode() : 0);
        return result;
    }
}
