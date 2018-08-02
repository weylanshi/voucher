package com.u8.sum.domain.report;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public interface AllEntityJPA extends JpaRepository<AllEntity,String>,JpaSpecificationExecutor<AllEntity>,Serializable {
    @Query(value = "select " +
            "ht.strContractID, " +
            "ht.strContractName, " +
            "ht.strCurrency, " +
            "ht.dblTotalCurrency, " +
            "ht.dblExchange, " +
            "ht.strBisectionUnit " +
            "from CM_Contract_B ht "+
            "where ht.GUID=?1 ORDER BY ht.strContractID DESC \n-- #pageable\n",nativeQuery = true)
    public Page<AllEntity>  findHT(String guid,Pageable pageable);

    @Query(value = "select \n" +
            "ht.strContractID,\n" +
            "ht.strContractName,\n" +
            "ht.strCurrency,\n" +
            "ht.dblTotalCurrency,\n" +
            "ht.dblExchange, \n" +
            "ht.strBisectionUnit " +
            "from CM_ExecuteBill e \n" +
            "LEFT JOIN CM_Contract_B ht \n" +
            "on e.cContractID=ht.strContractID  \n" +
            "where e.GUID=?1 ORDER BY ht.strContractID DESC \n-- #pageable\n",nativeQuery = true)
    public Page<AllEntity>  findZXD(String guid,Pageable pageable);

    @Query(value = "select\n" +
            "ht.strContractID,\n" +
            "ht.strContractName,\n" +
            "ht.strCurrency,\n" +
            "ht.dblTotalCurrency,\n" +
            "ht.dblExchange, \n" +
            "ht.strBisectionUnit " +
            "from CM_Balance js \n" +
            "LEFT JOIN  CM_Contract_B  ht \n" +
            "on js.cContractID=ht.strContractID\n" +
            "where BalanceGuid=?1 ORDER BY ht.strContractID DESC \n-- #pageable\n",nativeQuery = true)
    public Page<AllEntity> findJSD(String guid,Pageable pageable);
}
