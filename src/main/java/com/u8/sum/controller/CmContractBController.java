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
    @RequestMapping(value = "/list")
    public Page<CmContractBEntity> list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                        @RequestParam(value = "strContractId",defaultValue = "") String strContractId,
                                        @RequestParam(value = "strContractName",defaultValue = "") String strContractName,
                                        @RequestParam(value = "date1",defaultValue = "1900-01-01") String date1,
                                        @RequestParam(value = "date2",defaultValue = "9999-01-01") String date2,
                                        @RequestParam(value = "customerCode",defaultValue = "") String customerCode,
                                        @RequestParam(value = "supplierCode",defaultValue = "") String supplierCode){

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
                //合同签订日期筛选
                Path<Long> $strContractOrderDate = root.get("strContractOrderDate");
                //Predicate _strContractOrderDate = criteriaBuilder.equal($strContractOrderDate, strContractOrderDate);
                Predicate _strContractOrderDate = criteriaBuilder.between(root.get("strContractOrderDate").as(String.class),date1,date2);
                if(!StringUtils.isNullOrEmpty(date1)&!StringUtils.isNullOrEmpty(date2)){
                   predicates.add(_strContractOrderDate);
                }

                //客户编码筛选
                //Path<Long> $strContractName = root.get("strContractName");

                if(!StringUtils.isNullOrEmpty(customerCode)){
                    Predicate _strBisectionUnit = criteriaBuilder.equal(root.get("strBisectionUnit").as(String.class), customerCode);
                    Predicate _strContractKind = criteriaBuilder.equal(root.get("strContractKind").as(String.class), "应收类合同");
                    Predicate pr = criteriaBuilder.and(_strBisectionUnit,_strContractKind);
                    predicates.add(pr);
                }

                //供应商编码筛选
                //Path<Long> $strContractName = root.get("strContractName");

                if(!StringUtils.isNullOrEmpty(supplierCode)){
                    Predicate _strBisectionUnit = criteriaBuilder.equal(root.get("strBisectionUnit").as(String.class), supplierCode);
                    Predicate _strContractKind = criteriaBuilder.equal(root.get("strContractKind").as(String.class), "应付类合同");
                    Predicate pr = criteriaBuilder.and(_strBisectionUnit,_strContractKind);
                    predicates.add(pr);
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
