package com.u8.sum.domain.report;

import com.u8.sum.domain.report.CmContractBEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public interface CmContractBJPA extends JpaRepository<CmContractBEntity,String>,JpaSpecificationExecutor<CmContractBEntity>,Serializable {
    @Query(value = "SELECT a.GUID,\n" +
            "a.strBisectionUnit,\n" +
            "b.cCusName,\n" +
            "a.strContractID,\n" +
            "a.strContractKind,\n" +
            "a.strContractName,\n" +
            "a.strContractOrderDate,\n" +
            "a.strContractStartDate,\n" +
            "a.strContractEndDate,\n" +
            "a.strCurrency,\n" +
            "a.dblExchange,\n" +
            "a.dblTotalCurrency,\n" +
            "a.strWay,\n" +
            "a.cDefine10 \n" +
            "from CM_Contract_B a\n" +
            "LEFT JOIN Customer b\n" +
            "on a.strBisectionUnit=b.cCusCode " +
            "where a.strContractID LIKE %?1% and a.strContractName like %?2% "+
            "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='收'   ORDER BY a.strContractID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) \n" +
                    "from CM_Contract_B a\n" +
                    "LEFT JOIN Customer b\n" +
                    "on a.strBisectionUnit=b.cCusCode"+
                    "where a.strContractID LIKE %?1% and a.strContractName like %?2% " +
                    "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='收'  ",
            nativeQuery = true)
    public Page<CmContractBEntity> inList(String a, String b, String c, String d, String e, Pageable pageable);


    @Query(value = "SELECT a.GUID,\n" +
            "a.strBisectionUnit,\n" +
            "b.cCusName,\n" +
            "a.strContractID,\n" +
            "a.strContractKind,\n" +
            "a.strContractName,\n" +
            "a.strContractOrderDate,\n" +
            "a.strContractStartDate,\n" +
            "a.strContractEndDate,\n" +
            "a.strCurrency,\n" +
            "a.dblExchange,\n" +
            "a.dblTotalCurrency,\n" +
            "a.strWay,\n" +
            "a.cDefine10 \n" +
            "from CM_Contract_B a\n" +
            "LEFT JOIN Customer b\n" +
            "on a.strBisectionUnit=b.cCusCode " +
            "where a.strContractID LIKE %?1% and a.strContractName like %?2%  "+
            "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='收'   ORDER BY a.strContractID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) \n" +
                    "from CM_Contract_B a\n" +
                    "LEFT JOIN Customer b\n" +
                    "on a.strBisectionUnit=b.cCusCode"+
                    "where a.strContractID LIKE %?1% and a.strContractName like %?2%  " +
                    "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='收'  ",
            nativeQuery = true)
    public Page<CmContractBEntity> inList2(String a, String b, String c, String d, String e, Pageable pageable);


    @Query(value = "SELECT a.GUID,\n" +
            "a.strBisectionUnit,\n" +
            "b.cCusName,\n" +
            "a.strContractID,\n" +
            "a.strContractKind,\n" +
            "a.strContractName,\n" +
            "a.strContractOrderDate,\n" +
            "a.strContractStartDate,\n" +
            "a.strContractEndDate,\n" +
            "a.strCurrency,\n" +
            "a.dblExchange,\n" +
            "a.dblTotalCurrency,\n" +
            "a.strWay,\n" +
            "a.cDefine10 \n" +
            "from CM_Contract_B a\n" +
            "LEFT JOIN Customer b\n" +
            "on a.strBisectionUnit=b.cCusCode " +
            "where a.strContractID LIKE %?1% and a.strContractName like %?2% " +
            "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='付' ORDER BY a.strContractID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) \n" +
                    "from CM_Contract_B a\n" +
                    "LEFT JOIN Customer b\n" +
                    "on a.strBisectionUnit=b.cCusCode"+
                    "where a.strContractID LIKE %?1% and a.strContractName like %?2% " +
                    "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='付' ",
            nativeQuery = true)
    public Page<CmContractBEntity> outList(String a1, String a2, String a3, String a4, String a5,Pageable pageable);

    @Query(value = "SELECT a.GUID,\n" +
            "a.strBisectionUnit,\n" +
            "b.cCusName,\n" +
            "a.strContractID,\n" +
            "a.strContractKind,\n" +
            "a.strContractName,\n" +
            "a.strContractOrderDate,\n" +
            "a.strContractStartDate,\n" +
            "a.strContractEndDate,\n" +
            "a.strCurrency,\n" +
            "a.dblExchange,\n" +
            "a.dblTotalCurrency,\n" +
            "a.strWay,\n" +
            "a.cDefine10 \n" +
            "from CM_Contract_B a\n" +
            "LEFT JOIN Customer b\n" +
            "on a.strBisectionUnit=b.cCusCode " +
            "where a.strContractID LIKE %?1% and a.strContractName like %?2% " +
            "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='付' ORDER BY a.strContractID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) \n" +
                    "from CM_Contract_B a\n" +
                    "LEFT JOIN Customer b\n" +
                    "on a.strBisectionUnit=b.cCusCode"+
                    "where a.strContractID LIKE %?1% and a.strContractName like %?2% " +
                    "and a.strContractOrderDate BETWEEN ?3 AND ?4 and a.strBisectionUnit LIKE %?5% and a.strWay='付' ",
            nativeQuery = true)
    public Page<CmContractBEntity> outList2(String a1, String a2, String a3, String a4, String a5,Pageable pageable);
}
