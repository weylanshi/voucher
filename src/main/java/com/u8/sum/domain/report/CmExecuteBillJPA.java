package com.u8.sum.domain.report;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
public interface CmExecuteBillJPA extends JpaRepository<ExecuteEntity,String>,JpaSpecificationExecutor<ExecuteEntity>,Serializable {
    @Query(value = "SELECT e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11,sum(es.decRateMoney) as decRateMoney \n" +
            "from CM_ExecuteBill e  \n" +
            "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
            "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
            "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
            "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='收'" +
            "GROUP BY e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11 ORDER BY e.cExecID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) " +
            "from CM_ExecuteBill e  \n" +
            "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
            "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
            "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
                    "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='收' ",
            nativeQuery = true)
    public Page<ExecuteEntity> inList(String cExecID,String cContractID,String strContractName,String date1,String date2,Pageable pageable);

    @Query(value = "SELECT e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11,sum(es.decRateMoney) as decRateMoney \n" +
            "from CM_ExecuteBill e  \n" +
            "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
            "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
            "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
            "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='收'" +
            "GROUP BY e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind ,e.cDefine11 ORDER BY e.cExecID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) " +
                    "from CM_ExecuteBill e  \n" +
                    "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
                    "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
                    "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
                    "and e.dtProduceDate BETWEEN ?4 and ?5 and c.strWay='收' ",
            nativeQuery = true)
    public Page<ExecuteEntity> inList2(String cExecID,String cContractID,String strContractName,String date1,String date2,Pageable pageable);

    @Query(value = "SELECT e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11,sum(es.decRateMoney) as decRateMoney \n" +
            "from CM_ExecuteBill e  \n" +
            "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
            "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
            "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
            "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='付'" +
            "GROUP BY e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11 ORDER BY e.cExecID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) " +
                    "from CM_ExecuteBill e  \n" +
                    "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
                    "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
                    "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
                    "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='付' ",
            nativeQuery = true)
    public Page<ExecuteEntity> outList(String cExecID,String cContractID,String strContractName,String date1,String date2,Pageable pageable);

    @Query(value = "SELECT e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11,sum(es.decRateMoney) as decRateMoney \n" +
            "from CM_ExecuteBill e  \n" +
            "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
            "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
            "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
            "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='付'" +
            "GROUP BY e.GUID,e.cExecID,e.cContractID,e.dtProduceDate,c.strContractName,c.strContractKind,e.cDefine11 ORDER BY e.cExecID DESC \n-- #pageable\n",
            countQuery = "SELECT count(*) " +
                    "from CM_ExecuteBill e  \n" +
                    "LEFT JOIN CM_Contract_B c  on e.cContractID=c.strContractID \n" +
                    "LEFT JOIN CM_ExecuteBills es on e.cExecID=es.cExecID\n" +
                    "where e.cExecID like %?1% and c.strContractName like %?2% and e.cContractID like %?3% " +
                    "and e.dtProduceDate BETWEEN ?4 and ?5  and c.strWay='付' ",
            nativeQuery = true)
    public Page<ExecuteEntity> outList2(String cExecID,String cContractID,String strContractName,String date1,String date2,Pageable pageable);
}
