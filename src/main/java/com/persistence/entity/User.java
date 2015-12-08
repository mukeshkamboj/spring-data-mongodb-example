package com.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Reference;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends Persistence {

  @Version
  private Long versionId;

  private String firstName;
  private String lastName;
  private String userName;

  @Reference
  private Address primaryAddress;

  @DBRef
  private Set<Address> addresses = new HashSet<Address>();

  public User() {}

  public User(String firstName, String lastName, String userName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Address getPrimaryAddress() {
    return primaryAddress;
  }

  public void setPrimaryAddress(Address primaryAddress) {
    this.primaryAddress = primaryAddress;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  @Override
  public String toString() {
    return "User [versionId=" + versionId + ", firstName=" + firstName + ", lastName=" + lastName
        + ", userName=" + userName + ", primaryAddress=" + primaryAddress + ", addresses="
        + addresses + "]";
  }

}
