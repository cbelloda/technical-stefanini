package com.belloda.dto;

public class ResponseOk extends ResponseMaintenance{
    
    Object data;

    public ResponseOk(String code, String description, Object data) {
        super();
        this.code = code;
        this.description = description;
        this.data = data;
    }
    public ResponseOk(String description,Object data){
        this.code = "000";
        this.description = description;
        this.data = data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    
    
}
