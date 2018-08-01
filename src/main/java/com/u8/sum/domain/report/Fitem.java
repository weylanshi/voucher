package com.u8.sum.domain.report;

import javax.persistence.*;

@Entity
public class Fitem {
    private int id;
    private String citemcode;
    private String citemname;
    private Short bclose;
    private String citemccode;
    private Integer iotherused;
    private String dEndDate;

    @Basic
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "i_id")
    public int getId() {
        return id;
    }
    @Basic
    @Column(name = "citemcode")
    public String getCitemcode() {
        return citemcode;
    }
    @Basic
    @Column(name = "citemname")
    public String getCitemname() {
        return citemname;
    }
    @Basic
    @Column(name = "bclose")
    public Short getBclose() {
        return bclose;
    }
    @Basic
    @Column(name = "citemccode")
    public String getCitemccode() {
        return citemccode;
    }
    @Basic
    @Column(name = "iotherused")
    public Integer getIotherused() {
        return iotherused;
    }
    @Basic
    @Column(name = "denddate")
    public String getdEndDate() {
        return dEndDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCitemcode(String citemcode) {
        this.citemcode = citemcode;
    }

    public void setCitemname(String citemname) {
        this.citemname = citemname;
    }

    public void setBclose(Short bclose) {
        this.bclose = bclose;
    }

    public void setCitemccode(String citemccode) {
        this.citemccode = citemccode;
    }

    public void setIotherused(Integer iotherused) {
        this.iotherused = iotherused;
    }

    public void setdEndDate(String dEndDate) {
        this.dEndDate = dEndDate;
    }
}
