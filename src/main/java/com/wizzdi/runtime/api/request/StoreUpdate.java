package com.wizzdi.runtime.api.request;

public class StoreUpdate {

  private String name;

  private String id;

  public StoreUpdate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return StoreUpdate
   */
  public <T extends StoreUpdate> T setName(String name) {
    this.name = name;
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
   * @return StoreUpdate
   */
  public <T extends StoreUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
