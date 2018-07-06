package com.u8.sum.controller;

import com.mysql.jdbc.StringUtils;
import com.u8.sum.domain.report.CmContractBEntity;
import com.u8.sum.domain.report.CmContractBJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.awt.print.PageFormat;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/HT")
public class CmContractBController {
    @Autowired
    private CmContractBJPA cmContractBJPA;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Page<CmContractBEntity> list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                        @RequestParam(value = "strContractId",defaultValue = "") String strContractId,
                                        @RequestParam(value = "strContractName",defaultValue = "") String strContractName,
                                        @RequestParam(value = "strContractStartDate",defaultValue = "") String strContractStartDate,
                                        @RequestParam(value = "strContractEndDate",defaultValue = "") String strContractEndDate){

        //筛选条件
        Specification<CmContractBEntity> specification = new Specification<CmContractBEntity>() {
            @Override
            public Predicate toPredicate(Root<CmContractBEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //合同编码赛选
                //Path<Long> $strContractId = root.get("strContractId");
                Predicate _strContractId = criteriaBuilder.equal(root.get("strContractId").as(String.class), strContractId);
                if(!StringUtils.isNullOrEmpty(strContractId)){
                    predicates.add(_strContractId);
                }
                //合同名称筛选
                //Path<Long> $strContractName = root.get("strContractName");
                Predicate _strContractName = criteriaBuilder.like(root.get("strContractName").as(String.class), strContractName);
                if(!StringUtils.isNullOrEmpty(strContractName)){
                    predicates.add(_strContractName);
                }
                //合同开始日期筛选
                Path<Long> $strContractStartDate = root.get("strContractStartDate");
                Predicate _strContractStartDate = criteriaBuilder.equal($strContractStartDate, strContractStartDate);
                if(!StringUtils.isNullOrEmpty(strContractStartDate)){
                    predicates.add(_strContractStartDate);
                }
                //合同结束日期筛选
                Path<Long> $strContractEndDate = root.get("strContractEndDate");
                Predicate _strContractEndDate = criteriaBuilder.equal($strContractEndDate, strContractEndDate);
                if(!StringUtils.isNullOrEmpty(strContractEndDate)){
                    predicates.add(_strContractEndDate);
                }

                return criteriaBuilder.and(predicates
                        .toArray(new Predicate[] {}));
            }
        };

        Sort sort=new Sort(Sort.Direction.DESC, "guid").and(new Sort(Sort.Direction.DESC, "strContractStartDate"));

        Pageable pageable=new PageRequest(pageNum-1,pageSize,sort);

        return cmContractBJPA.findAll(specification,pageable);

        //return cmContractBJPA.findAll();
    }

}
