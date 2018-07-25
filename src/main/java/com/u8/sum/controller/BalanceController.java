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
    @RequestMapping(value = "/list")
    public Page<BalanceEntity> list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "cBalanceID",defaultValue = "") String cBalanceID,
                                    @RequestParam(value = "date1",defaultValue = "1900-01-01") String date1,
                                    @RequestParam(value = "date2",defaultValue = "9999-01-01") String date2){

        //Sort sort=new Sort(Sort.Direction.DESC, "guid").and(new Sort(Sort.Direction.DESC, "cExecID"));

        //Pageable pageable=new PageRequest(pageNum-1,pageSize,sort);
        Pageable pageable=new PageRequest(pageNum-1,pageSize);
        //return cmExecuteBillJPA.getList(cExecID,pageable);
        return balanceJPA.getList(cBalanceID,date1,date2,pageable);

    }
}
