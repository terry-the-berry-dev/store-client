package com.wizzdi.runtime.api.request;

public class StoreCreate {

  private String name;

  public StoreCreate() {}

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name to set
   * @return StoreCreate
   */
  public <T extends StoreCreate> T setName(String name) {
    this.name = name;
    return (T) this;
  }
}
