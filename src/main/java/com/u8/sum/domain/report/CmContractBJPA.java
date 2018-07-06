package com.u8.sum.domain.report;

import com.u8.sum.domain.report.CmContractBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public interface CmContractBJPA extends JpaRepository<CmContractBEntity,String>,JpaSpecificationExecutor<CmContractBEntity>,Serializable {

}
