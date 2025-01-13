package com.wizzdi.runtime.api.response;

import java.util.List;

public class PaginationResponseAppUser {

  private List<AppUser> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseAppUser() {}

  /**
   * @return list
   */
  public List<AppUser> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseAppUser
   */
  public <T extends PaginationResponseAppUser> T setList(List<AppUser> list) {
    this.list = list;
    return (T) this;
  }

  /**
   * @return totalRecords
   */
  public Integer getTotalRecords() {
    return this.totalRecords;
  }

  /**
   * @param totalRecords to set
   * @return PaginationResponseAppUser
   */
  public <T extends PaginationResponseAppUser> T setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
    return (T) this;
  }

  /**
   * @return totalPages
   */
  public Integer getTotalPages() {
    return this.totalPages;
  }

  /**
   * @param totalPages to set
   * @return PaginationResponseAppUser
   */
  public <T extends PaginationResponseAppUser> T setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return (T) this;
  }

  /**
   * @return startPage
   */
  public Integer getStartPage() {
    return this.startPage;
  }

  /**
   * @param startPage to set
   * @return PaginationResponseAppUser
   */
  public <T extends PaginationResponseAppUser> T setStartPage(Integer startPage) {
    this.startPage = startPage;
    return (T) this;
  }

  /**
   * @return endPage
   */
  public Integer getEndPage() {
    return this.endPage;
  }

  /**
   * @param endPage to set
   * @return PaginationResponseAppUser
   */
  public <T extends PaginationResponseAppUser> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
