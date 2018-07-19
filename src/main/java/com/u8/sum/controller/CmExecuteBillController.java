package com.u8.sum.controller;

import com.u8.sum.domain.report.CmContractBEntity;
import com.u8.sum.domain.report.CmExecuteBillJPA;
import com.u8.sum.domain.report.ExecuteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ZXD")
public class CmExecuteBillController {
    @Autowired
    private CmExecuteBillJPA cmExecuteBillJPA;

    @RequestMapping(value = "/list")
    public Page<ExecuteEntity>   list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "cExecID",defaultValue = "") String cExecID,
                                     @RequestParam(value = "cContractID",defaultValue = "") String cContractID,
                                     @RequestParam(value = "strContractName",defaultValue = "") String strContractName,
                                     @RequestParam(value = "date1",defaultValue = "1900-01-01") String date1,
                                     @RequestParam(value = "date2",defaultValue = "9999-01-01") String date2){

        Sort sort=new Sort(Sort.Direction.DESC, "guid").and(new Sort(Sort.Direction.DESC, "cExecID"));

        //Pageable pageable=new PageRequest(pageNum-1,pageSize,sort);
        Pageable pageable=new PageRequest(pageNum-1,pageSize);
        //return cmExecuteBillJPA.getList(cExecID,pageable);
        return cmExecuteBillJPA.getList(cExecID,cContractID,strContractName,date1,date2,pageable);

    }
}
