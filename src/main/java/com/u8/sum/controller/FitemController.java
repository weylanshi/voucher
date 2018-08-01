package com.u8.sum.controller;


import com.u8.sum.domain.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/PZ")
public class FitemController {
    @Autowired
    private FitemJPA fitemJPA;

    @Autowired
    private AllEntityJPA allEntityJPA;

    @RequestMapping(value = "/inList")
    public Integer inList(@RequestParam(value = "a",defaultValue = "0") String a,
                          @RequestParam(value = "b",defaultValue = "0") String  b,
                          @RequestParam(value = "c",defaultValue = "0") short c,
                          @RequestParam(value = "d",defaultValue = "0") String d){

            return fitemJPA.fitem(a,b,c,d);

    }

//    @RequestMapping(value = "/pz1")
//    public Integer pz1(@RequestParam(value = "a",defaultValue = "0") String a,
//                          @RequestParam(value = "b",defaultValue = "0") String  b,
//                          @RequestParam(value = "c",defaultValue = "0") short c,
//                          @RequestParam(value = "d",defaultValue = "0") String d,
//                        @RequestParam(value = "e",defaultValue = "0") String e){
//
//        return fitemJPA.pz1(a,b,c,d,e);
//
//    }
@RequestMapping(value = "/pzAdd")
public String pzAdd(@RequestParam(value = "guid",defaultValue = "0") String guid,
                      @RequestParam(value = "type",defaultValue = "0") String  type){

    Date now=new Date();
    SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy-MM-dd");
    String dateStr=myFmt2.format(now);
    String dateStr2=myFmt3.format(now);
    String yyyy=dateStr.substring(0,4);
    String MM=dateStr.substring(5,7);
    String M=dateStr.substring(5,7);
    String hhmmss=dateStr.substring(11,19);
    if(M.startsWith("0")){
        M=M.substring(1,2);
    }

    String ccode1="";
    String ccode2="";
    String cexch_name1="";
    String cexch_name2="";
    String md1="0";
    String mc1="0";
    String md_f1="0";
    String mc_f1="0";
    String nfrat1="0";
    String md2="0";
    String mc2="0";
    String md_f2="0";
    String mc_f2="0";
    String nfrat2="0";

    String bCusSupInput1="";
    String bCusSupInput2="";

    String ccodeexch_equal1="6001";
    String ccodeexch_equal2="12201";





    Integer i= fitemJPA.findMax()+1;

    String gl="GL0000000000001";
    gl=gl.substring(0,15-i.toString().length())+i;
    
    String uuid= UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        Page<AllEntity> page;
        System.out.println(i);


        Pageable pageable=new PageRequest(1-1,10);
        if("1".equals(type)){//如果是合同凭证
            page=allEntityJPA.findHT(guid,pageable);
            AllEntity allEntity=page.getContent().get(0);
            if(allEntity.getStrCurrency().equals("美元")){
                ccode2="6001";
                ccode1="112202";
                cexch_name1="美元";
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1= new BigDecimal(allEntity.getDblTotalCurrency()).divide(new BigDecimal(allEntity.getDblExchange())).toString();
                mc_f1="0";
                nfrat1=allEntity.getDblExchange();
                md2="0";
                mc2="0";
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="1";
                bCusSupInput2="1";

                ccodeexch_equal1="6001";
                ccodeexch_equal2="112202|美元";
            }else{
                ccode2="6001";
                ccode1="112202";
                cexch_name1=null;
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1="0";
                mc_f1="0";
                nfrat1="0";
                md2="0";
                mc2=allEntity.getDblTotalCurrency();
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="0";
                bCusSupInput2="0";
                ccodeexch_equal1="6001";
                ccodeexch_equal2="112201";
            }
            fitemJPA.pz1(M,"记","1",i.toString(),"1",dateStr,"-1","demo","0","暂估合同款",
                    ccode1,cexch_name1,md1,mc1,md_f1,"0",nfrat1,"0","0",dateStr2,allEntity.getStrBisectionUnit()+"",
                    "-",ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
                    "0","CCDDE5B049144B6E813818ADAC1989B200000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal1,uuid);
            fitemJPA.pz2(M,"记","1",i.toString(),"2",dateStr,"-1","demo","0","暂估合同款",
                    ccode2,cexch_name2,md2,mc2,md_f2,"0",nfrat2,"0","0",null,null,
                    null,ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
                    "0","7315CD7342FA1918033CDDB15DFBEBDD00000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal2,uuid);
            //fitemJPA.fitem();
            short a = 0;
            fitemJPA.fitem(allEntity.getStrContractID(),allEntity.getStrContractName(),a,"1");

            fitemJPA.updateHT(i+"",guid);


        }else if("2".equals(type)){//如果是合同执行单
            page=allEntityJPA.findZXD(guid,pageable);
            AllEntity allEntity=page.getContent().get(0);
            if(allEntity.getStrCurrency().equals("美元")){
                ccode2="6001";
                ccode1="112202";
                cexch_name1="美元";
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1= new BigDecimal(allEntity.getDblTotalCurrency()).divide(new BigDecimal(allEntity.getDblExchange())).toString();
                mc_f1="0";
                nfrat1=allEntity.getDblExchange();
                md2="0";
                mc2="0";
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="1";
                bCusSupInput2="1";
                ccodeexch_equal1="6001";
                ccodeexch_equal2="112202|美元";

            }else{
                ccode2="6001";
                ccode1="112202";
                cexch_name1=null;
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1="0";
                mc_f1="0";
                nfrat1="0";
                md2="0";
                mc2=allEntity.getDblTotalCurrency();
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="0";
                bCusSupInput2="0";
                ccodeexch_equal1="6001";
                ccodeexch_equal2="112201";
            }
            fitemJPA.pz1(M,"记","1",i.toString(),"1",dateStr,"-1","demo","0","暂估合同款",
                    ccode1,cexch_name1,md1,mc1,md_f1,"0",nfrat1,"0","0",dateStr2,allEntity.getStrBisectionUnit()+"",
                    "-",ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
                    "0","CCDDE5B049144B6E813818ADAC1989B200000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal1,uuid);
            fitemJPA.pz2(M,"记","1",i.toString(),"2",dateStr,"-1","demo","0","暂估合同款",
                    ccode2,cexch_name2,md2,mc2,md_f2,"0",nfrat2,"0","0",null,null,
                    null,ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
                    "0","7315CD7342FA1918033CDDB15DFBEBDD00000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal2,uuid);
            //fitemJPA.fitem();
            short a = 0;
            fitemJPA.fitem(allEntity.getStrContractID(),allEntity.getStrContractName(),a,"1");
            fitemJPA.updateZXD(i+"",guid);

        }else if("3".equals(type)){//如果是合同结算单
            page=allEntityJPA.findJSD(guid,pageable);
            AllEntity allEntity=page.getContent().get(0);
            if(allEntity.getStrCurrency().equals("美元")){
                ccode2="6001";
                ccode1="112202";
                cexch_name1="美元";
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1= new BigDecimal(allEntity.getDblTotalCurrency()).divide(new BigDecimal(allEntity.getDblExchange())).toString();
                mc_f1="0";
                nfrat1=allEntity.getDblExchange();
                md2="0";
                mc2="0";
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="1";
                bCusSupInput2="1";
                ccodeexch_equal1="6001";
                ccodeexch_equal2="112202|美元";
            }else{
                ccode2="6001";
                ccode1="112202";
                cexch_name1=null;
                cexch_name2=null;
                md1=allEntity.getDblTotalCurrency();
                mc1="0";
                md_f1="0";
                mc_f1="0";
                nfrat1="0";
                md2="0";
                mc2=allEntity.getDblTotalCurrency();
                md_f2="0";
                mc_f2="0";
                nfrat2="0";
                bCusSupInput1="0";
                bCusSupInput2="0";
                ccodeexch_equal1="6001";
                ccodeexch_equal2="112201";
            }
            fitemJPA.pz1(M,"记","1",i.toString(),"1",dateStr,"-1","demo","0","暂估合同款",
                    ccode1,cexch_name1,md1,mc1,md_f1,"0",nfrat1,"0","0",dateStr2,allEntity.getStrBisectionUnit()+"",
                    "-",ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
            "0","CCDDE5B049144B6E813818ADAC1989B200000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal1,uuid);
            fitemJPA.pz2(M,"记","1",i.toString(),"2",dateStr,"-1","demo","0","暂估合同款",
                    ccode2,cexch_name2,md2,mc2,md_f2,"0",nfrat2,"0","0",null,null,
                    null,ccode1,"0",dateStr2,"",gl,"1","0","0","1","1","1","1","0",bCusSupInput1,
                    "0","7315CD7342FA1918033CDDB15DFBEBDD00000000",yyyy,yyyy+MM,dateStr,ccodeexch_equal2,uuid);

            short a = 0;
            fitemJPA.fitem(allEntity.getStrContractID(),allEntity.getStrContractName(),a,"1");
            fitemJPA.updateJSD(i+"",guid);

        }else{
            return "{\"pzId\":\"0\"}";
        }

        return "{\"pzId\":\""+i+"\"}";

    }

}
