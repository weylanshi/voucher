package com.u8.sum.domain.report;

import javax.persistence.*;

@Entity
public class BalanceEntity {
    private String guid;
    private String cBalanceID;//合同结算单ID
    private String strContractId;//合同编码
    private String strContractKind;//合同类型分类
    private String strContractName;//合同名称
    private String cTypeName;//合同类型
    private String strWay;//收支方向
    private String strBisectionUnit;//对方单位编码
    private String cCusName;//对方单位名称
    private String strCurrency;//币种
    private Double dblExchange;//汇率
    private Double dblTotalCurrency;//合同总金额
    private String dtCreateTime;//制单日期
    private String cDefine12;

    @Basic
    @Id
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "cbalanceid")
    public String getcBalanceID() {
        return cBalanceID;
    }

    public void setcBalanceID(String cBalanceID) {
        this.cBalanceID = cBalanceID;
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
    @Column(name = "ctypename")
    public String getcTypeName() {
        return cTypeName;
    }

    public void setcTypeName(String cTypeName) {
        this.cTypeName = cTypeName;
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
    @Column(name = "strbisectionunit")
    public String getStrBisectionUnit() {
        return strBisectionUnit;
    }

    public void setStrBisectionUnit(String strBisectionUnit) {
        this.strBisectionUnit = strBisectionUnit;
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
    @Column(name = "dtcreatetime")
    public String getDtCreateTime() {
        return dtCreateTime;
    }

    public void setDtCreateTime(String dtCreateTime) {
        this.dtCreateTime = dtCreateTime;
    }
    @Basic
    @Column(name = "cdefine12")
    public String getcDefine12() {
        return cDefine12;
    }

    public void setcDefine12(String cDefine12) {
        this.cDefine12 = cDefine12;
    }
}
