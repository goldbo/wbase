package com.wingo.wbase.model;

public class Item  implements java.io.Serializable {
    /**
   * ID
   */
  private static final long serialVersionUID = -2672601316182347L;
  
    private java.lang.String key = "";
    private java.lang.String value = "";

    public Item() {
    }

    
    public java.lang.String getKey() {
    
      return key;
    }

    
    public void setKey(
        java.lang.String key) {
    
      this.key = key;
    }

    
    public java.lang.String getValue() {
    
      return value;
    }

    
    public void setValue(
        java.lang.String value) {
    
      this.value = value;
    }
}
