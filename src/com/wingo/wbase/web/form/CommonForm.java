package com.wingo.wbase.web.form;

import org.apache.struts.action.ActionForm;

public class CommonForm extends ActionForm {

  private static final long serialVersionUID = -630181109078755962L;
  private String code = "";
  private String name = "";

  public String getCode() {

    return code;
  }

  public void setCode(
      String code) {

    this.code = code;
  }

  public String getName() {

    return name;
  }

  public void setName(
      String name) {

    this.name = name;
  }

}
