package com.belloda.dto;

public class ResponseError extends ResponseMaintenance{
  
    public ResponseError(){
        super();
        this.code="0001";
        this.description="Ocurrió un error";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
