package com.ymmihw.springframework.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.ymmihw.springframework.cache.config.ApplicationCacheConfig;
import com.ymmihw.springframework.cache.example.BookService;

@SpringBootTest
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
