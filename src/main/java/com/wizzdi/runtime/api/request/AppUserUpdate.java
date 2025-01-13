package com.wizzdi.runtime.api.request;

public class AppUserUpdate {

  private String password;

  private String roles;

  private String username;

  private String id;

  public AppUserUpdate() {}

  /**
   * @return password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * @param password to set
   * @return AppUserUpdate
   */
  public <T extends AppUserUpdate> T setPassword(String password) {
    this.password = password;
    return (T) this;
  }

  /**
   * @return roles
   */
  public String getRoles() {
    return this.roles;
  }

  /**
   * @param roles to set
   * @return AppUserUpdate
   */
  public <T extends AppUserUpdate> T setRoles(String roles) {
    this.roles = roles;
    return (T) this;
  }

  /**
   * @return username
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * @param username to set
   * @return AppUserUpdate
   */
  public <T extends AppUserUpdate> T setUsername(String username) {
    this.username = username;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return AppUserUpdate
   */
  public <T extends AppUserUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
