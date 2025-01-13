package com.wizzdi.runtime.api.response;

public class Store {

  private String id;

  private String name;

  public Store() {}

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id to set
   * @return Store
   */
  public <T extends Store> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return Store
   */
  public <T extends Store> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
