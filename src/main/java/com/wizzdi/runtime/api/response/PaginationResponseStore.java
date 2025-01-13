package com.wizzdi.runtime.api.response;

import java.util.List;

public class PaginationResponseStore {

  private List<Store> list;

  private Integer totalRecords;

  private Integer totalPages;

  private Integer startPage;

  private Integer endPage;

  public PaginationResponseStore() {}

  /**
   * @return list
   */
  public List<Store> getList() {
    return this.list;
  }

  /**
   * @param list to set
   * @return PaginationResponseStore
   */
  public <T extends PaginationResponseStore> T setList(List<Store> list) {
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
   * @return PaginationResponseStore
   */
  public <T extends PaginationResponseStore> T setTotalRecords(Integer totalRecords) {
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
   * @return PaginationResponseStore
   */
  public <T extends PaginationResponseStore> T setTotalPages(Integer totalPages) {
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
   * @return PaginationResponseStore
   */
  public <T extends PaginationResponseStore> T setStartPage(Integer startPage) {
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
   * @return PaginationResponseStore
   */
  public <T extends PaginationResponseStore> T setEndPage(Integer endPage) {
    this.endPage = endPage;
    return (T) this;
  }
}
