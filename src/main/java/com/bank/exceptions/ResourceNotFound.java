package com.bank.exceptions;

public class ResourceNotFound extends RuntimeException{
    String resourceName;
    String feildName;
    Object feildValue;
    public ResourceNotFound(String resourceName, String feildName, Object feildValue) {
        super(String.format("%s not found with %s : %s",resourceName,feildName,feildValue));
        this.resourceName = resourceName;
        this.feildName = feildName;
        this.feildValue = feildValue;
    }
}
