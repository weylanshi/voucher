package com.u8.sum;

import com.u8.sum.domain.report.CmExecuteBill;
import com.u8.sum.repository.report.CmExecuteBillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SumApplicationTests {

	@Autowired
	private  CmExecuteBillRepository cmExecuteBillRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindAll(){
		List<CmExecuteBill> all = cmExecuteBillRepository.findAll();
		System.out.println(all);
	}



}
