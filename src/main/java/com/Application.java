package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.persistence.repository.AddressRepository;
import com.persistence.repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.service", "com.persistence.repository", "com.rest.controller"})
public class Application {

  @Autowired
  private UserRepository repository;

  @Autowired
  private AddressRepository addressRepository;


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /*
   * @Override public void run(String... args) throws Exception {
   * 
   * repository.deleteAll();
   * 
   * Address address = new Address(); address.setStreet1("PKL");
   * 
   * addressRepository.save(address);
   * 
   * User user = new User("Mukesh", "Kumar","mkamboj"); user.getAddresses().add(address);
   * user.setPrimaryAddress(address); repository.save(user);
   * 
   * user.setLastName("Khera");
   * 
   * repository.save(user);
   * 
   * for (User customer : repository.findAll()) { System.out.println(customer); }
   * 
   * System.out.println();
   * 
   * }
   */
}
