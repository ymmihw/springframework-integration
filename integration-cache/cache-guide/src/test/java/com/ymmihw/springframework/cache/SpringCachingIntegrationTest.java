package com.ymmihw.springframework.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.ymmihw.springframework.cache.config.CachingConfig;
import com.ymmihw.springframework.cache.example.Customer;
import com.ymmihw.springframework.cache.example.CustomerDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CachingConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SpringCachingIntegrationTest {

  @Autowired
  private CustomerDataService service;

  @Test
  public void whenGettingAddress_thenCorrect() {
    final Customer cust = new Customer("Tom", "67-2, Downing Street, NY");
    service.getAddress(cust);
    service.getAddress(cust);

    service.getAddress1(cust);
    service.getAddress1(cust);

    service.getAddress2(cust);
    service.getAddress2(cust);

    service.getAddress3(cust);
    service.getAddress3(cust);

    service.getAddress4(cust);
    service.getAddress4(cust);

    service.getAddress5(cust);
    service.getAddress5(cust);
  }

}
