package com.u8.sum.controller;


import com.u8.sum.domain.report.BalanceEntity;
import com.u8.sum.domain.report.BalanceJPA;
import com.u8.sum.domain.report.CmExecuteBillJPA;
import com.u8.sum.domain.report.ExecuteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/JSD")
public class BalanceController {
    @Autowired
    private BalanceJPA balanceJPA;
    @RequestMapping(value = "/inList")
    public Page<BalanceEntity> inList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "cBalanceID",defaultValue = "") String cBalanceID,
                                    @RequestParam(value = "cDefine11",defaultValue = "0") String  cDefine11,
                                    @RequestParam(value = "date1",defaultValue = "1900-01-01") String date1,
                                    @RequestParam(value = "date2",defaultValue = "9999-01-01") String date2){

        //Sort sort=new Sort(Sort.Direction.DESC, "guid").and(new Sort(Sort.Direction.DESC, "cExecID"));

        //Pageable pageable=new PageRequest(pageNum-1,pageSize,sort);
        Pageable pageable=new PageRequest(pageNum-1,pageSize);
        if("1".equals(cDefine11)){
            return balanceJPA.inList2(cBalanceID,date1,date2,pageable);
        }else{
            return balanceJPA.inList(cBalanceID,date1,date2,pageable);
        }

    }

    @RequestMapping(value = "/outList")
    public Page<BalanceEntity> outList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "cBalanceID",defaultValue = "") String cBalanceID,
                                    @RequestParam(value = "cDefine11",defaultValue = "0") String  cDefine11,
                                    @RequestParam(value = "date1",defaultValue = "1900-01-01") String date1,
                                    @RequestParam(value = "date2",defaultValue = "9999-01-01") String date2){

        //Sort sort=new Sort(Sort.Direction.DESC, "guid").and(new Sort(Sort.Direction.DESC, "cExecID"));

        //Pageable pageable=new PageRequest(pageNum-1,pageSize,sort);
        Pageable pageable=new PageRequest(pageNum-1,pageSize);
        if("1".equals(cDefine11)){
            return balanceJPA.outList2(cBalanceID,date1,date2,pageable);
        }else{
            return balanceJPA.outList(cBalanceID,date1,date2,pageable);
        }

    }
}
