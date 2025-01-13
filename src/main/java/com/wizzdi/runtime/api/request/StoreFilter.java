package com.wizzdi.runtime.api.request;

import java.util.List;

public class StoreFilter {

  private Integer currentPage;

  private List<String> id;

  private List<String> name;

  private String nameLike;

  private Integer pageSize;

  public StoreFilter() {}

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage to set
   * @return StoreFilter
   */
  public <T extends StoreFilter> T setCurrentPage(Integer currentPage) {
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
   * @return StoreFilter
   */
  public <T extends StoreFilter> T setId(List<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return name
   */
  public List<String> getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return StoreFilter
   */
  public <T extends StoreFilter> T setName(List<String> name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return nameLike
   */
  public String getNameLike() {
    return this.nameLike;
  }

  /**
   * @param nameLike to set
   * @return StoreFilter
   */
  public <T extends StoreFilter> T setNameLike(String nameLike) {
    this.nameLike = nameLike;
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
   * @return StoreFilter
   */
  public <T extends StoreFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
