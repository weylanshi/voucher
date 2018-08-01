package com.u8.sum.domain.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
public interface FitemJPA extends JpaRepository<Fitem,String>,JpaSpecificationExecutor<Fitem>,Serializable {

    @Transactional
    @Modifying
    @Query(value = "insert into fitemss97(citemcode,citemname,bclose,citemccode) values(?1,?2,?3,?4)",nativeQuery = true)
    int fitem(String citemcode,String citemname,short bclose,String citemccode);

    @Transactional
    @Modifying
    @Query(value = "insert into gl_accvouch(iperiod,csign,isignseq,ino_id,inid,dbill_date,idoc,cbill,ibook,cdigest,ccode,cexch_name,md,mc,md_f,mc_f,nfrat,nd_s,nc_s,dt_date," +
            "ccus_id,cname,ccode_equal,bdelete,doutbilldate,coutsign,coutno_id,bvouchedit,bvouchAddordele,bvouchmoneyhold,bvalueedit,bcodeedit,bPCSedit,bDeptedit,bItemedit," +
            "bCusSupInput,bFlagOut,RowGuid,iyear,iYPeriod,tvouchtime,ccodeexch_equal,cpzchcode) " +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36,?37,?38,?39,?40,?41,?42,?43)",nativeQuery = true)
    int pz1(String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11,String a12,String a13,String a14,String a15,String a16,String a17,String a18,String a19,String a20,String a21,String a22,String a23,String a24,String a25,String a26,String a27,String a28,String a29,String a30,String a31,String a32,String a33,String a34,String a35,String a36,String a37,String a38,String a39,String a40,String a41,String a42,String a43);

    @Transactional
    @Modifying
    @Query(value = "insert into gl_accvouch(iperiod,csign,isignseq,ino_id,inid,dbill_date,idoc,cbill,ibook,cdigest,ccode,cexch_name,md,mc,md_f,mc_f,nfrat,nd_s,nc_s,dt_date," +
            "ccus_id,cname,ccode_equal,bdelete,doutbilldate,coutsign,coutno_id,bvouchedit,bvouchAddordele,bvouchmoneyhold,bvalueedit,bcodeedit,bPCSedit,bDeptedit,bItemedit," +
            "bCusSupInput,bFlagOut,RowGuid,iyear,iYPeriod,tvouchtime,ccodeexch_equal,cpzchcode) " +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36,?37,?38,?39,?40,?41,?42,?43)",nativeQuery = true)
    int pz2(String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11,String a12,String a13,String a14,String a15,String a16,String a17,String a18,String a19,String a20,String a21,String a22,String a23,String a24,String a25,String a26,String a27,String a28,String a29,String a30,String a31,String a32,String a33,String a34,String a35,String a36,String a37,String a38,String a39,String a40,String a41,String a42,String a43);

    @Query(value = "select max(ino_id) from gl_accvouch",nativeQuery = true)
    Integer findMax();

    @Transactional
    @Modifying
    @Query(value = "update CM_Contract_B set cDefine10=?1 where CM_Contract_B.GUID=?2",nativeQuery = true)
    int updateHT(String a,String b);

    @Transactional
    @Modifying
    @Query(value = "update CM_ExecuteBill set cDefine11=?1 where CM_ExecuteBill.GUID=?2",nativeQuery = true)
    int updateZXD(String a,String b);

    @Transactional
    @Modifying
    @Query(value = "update CM_Balance set cDefine12=?1 where CM_Balance.BalanceGuid=?2",nativeQuery = true)
    int updateJSD(String a,String b);



}
