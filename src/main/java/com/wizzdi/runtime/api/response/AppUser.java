package com.wizzdi.runtime.api.response;

public class AppUser {

  private String id;

  private String username;

  public AppUser() {}

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return AppUser
   */
  public <T extends AppUser> T setId(String id) {
    this.id = id;
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
   * @return AppUser
   */
  public <T extends AppUser> T setUsername(String username) {
    this.username = username;
    return (T) this;
  }
}
