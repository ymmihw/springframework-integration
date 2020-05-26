package com.ymmihw.springframework.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.ymmihw.springframework.cache.config.ApplicationCacheConfig;
import com.ymmihw.springframework.cache.example.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, ApplicationCacheConfig.class},
    loader = AnnotationConfigContextLoader.class)
public class SpringCachingIntegrationTest {
  @Autowired
  private BookService service;

  @Test
  public void whenGettingAddress_thenCorrect() {
    service.getBooks();
  }
}
