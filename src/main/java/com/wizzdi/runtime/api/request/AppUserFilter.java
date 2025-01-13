package com.wizzdi.runtime.api.request;

import java.util.List;

public class AppUserFilter {

  private Integer currentPage;

  private List<String> id;

  private Integer pageSize;

  private List<String> roles;

  private String rolesLike;

  private List<String> username;

  private String usernameLike;

  public AppUserFilter() {}

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return id
   */
  public List<String> getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * @return roles
   */
  public List<String> getRoles() {
    return this.roles;
  }

  /**
   * @param roles to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setRoles(List<String> roles) {
    this.roles = roles;
    return (T) this;
  }

  /**
   * @return rolesLike
   */
  public String getRolesLike() {
    return this.rolesLike;
  }

  /**
   * @param rolesLike to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setRolesLike(String rolesLike) {
    this.rolesLike = rolesLike;
    return (T) this;
  }

  /**
   * @return username
   */
  public List<String> getUsername() {
    return this.username;
  }

  /**
   * @param username to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setUsername(List<String> username) {
    this.username = username;
    return (T) this;
  }

  /**
   * @return usernameLike
   */
  public String getUsernameLike() {
    return this.usernameLike;
  }

  /**
   * @param usernameLike to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setUsernameLike(String usernameLike) {
    this.usernameLike = usernameLike;
    return (T) this;
  }
}
