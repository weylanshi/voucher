package com.u8.sum.domain.report;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public interface BalanceJPA extends JpaRepository<BalanceEntity,String>,JpaSpecificationExecutor<BalanceEntity>,Serializable {
    @Query(value = "select \n" +
            "js.cBalanceID,\n" +
            "ht.strContractID,\n" +
            "ht.strContractName,\n" +
            "ht.strContractKind,\n" +
            "ty.cTypeName,\n" +
            "ht.strWay,\n" +
            "ht.strBisectionUnit,\n" +
            "cu.cCusName,\n" +
            "ht.strCurrency,\n" +
            "ht.dblTotalCurrency/ht.dblExchange as dblTotalCurrency,\n" +
            "ht.dblExchange/ht.dblExchange as dblExchange,\n" +
            "js.dtCreateTime \n" +
            "from CM_Balance js \n" +
            "LEFT JOIN  CM_Contract_B  ht \n" +
            "on js.cContractID=ht.strContractID\n" +
            "LEFT JOIN CM_Type ty \n" +
            "on ht.strContractType=ty.cTypeCode\n" +
            "LEFT JOIN Customer cu \n" +
            "on ht.strBisectionUnit=cu.cCusCode\n" +
            "where js.cBalanceID like %?1% and js.dtCreateTime BETWEEN ?2 and ?3  ORDER BY js.cBalanceID ASC \n-- #pageable\n",
            countQuery = "select count(*) \n" +
                    "from CM_Balance js \n" +
                    "LEFT JOIN  CM_Contract_B  ht \n" +
                    "on js.cContractID=ht.strContractID\n" +
                    "LEFT JOIN CM_Type ty \n" +
                    "on ht.strContractType=ty.cTypeCode\n" +
                    "LEFT JOIN Customer cu \n" +
                    "on ht.strBisectionUnit=cu.cCusCode\n" +
                    "where js.cBalanceID like %?1% and js.dtCreateTime BETWEEN ?2 and ?3",
            nativeQuery = true)
    public Page<BalanceEntity> getList(String cBalanceID,String date1,String date2,Pageable pageable);
}
