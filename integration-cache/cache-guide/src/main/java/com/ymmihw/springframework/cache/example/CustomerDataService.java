package com.ymmihw.springframework.cache.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = {"addresses"})
public class CustomerDataService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  // this method configuration is equivalent to xml configuration
  @Cacheable(value = "addresses", key = "#customer.name")
  public String getAddress(final Customer customer) {
    logger.info("exec getAddress");
    return customer.getAddress();
  }

  /**
   * The method returns the customer's address, only it doesn't find it the cache- addresses and
   * directory.
   *
   * @param customer the customer
   * @return the address
   */
  @Cacheable({"addresses", "directory"})
  public String getAddress1(final Customer customer) {
    logger.info("exec getAddress1");
    return customer.getAddress();
  }

  /**
   * The method returns the customer's address, but refreshes all the entries in the cache to load
   * new ones.
   *
   * @param customer the customer
   * @return the address
   */
  @CacheEvict(value = "addresses", allEntries = true)
  public String getAddress2(final Customer customer) {
    logger.info("exec getAddress2");
    return customer.getAddress();
  }

  /**
   * The method returns the customer's address, but not before selectively evicting the cache as per
   * specified paramters.
   *
   * @param customer the customer
   * @return the address
   */
  @Caching(
      evict = {@CacheEvict("addresses"), @CacheEvict(value = "directory", key = "#customer.name")})
  public String getAddress3(final Customer customer) {
    logger.info("exec getAddress3");
    return customer.getAddress();
  }

  /**
   * The method uses the class level cache to look up for entries.
   *
   * @param customer the customer
   * @return the address
   */
  @Cacheable
  // parameter not required as we have declared it using @CacheConfig
  public String getAddress4(final Customer customer) {
    logger.info("exec getAddress4");
    return customer.getAddress();
  }

  /**
   * The method selectively caches the results that meet the predefined criteria.
   *
   * @param customer the customer
   * @return the address
   */
  @CachePut(value = "addresses", condition = "#customer.name=='Tom'")
  // @CachePut(value = "addresses", unless = "#result.length>64")
  public String getAddress5(final Customer customer) {
    logger.info("exec getAddress5");
    return customer.getAddress();
  }
}
