 package com.link.trial.DTO;

public class OrderDTO {
    private String oid;
    private String payment_method;
    private String nid; 

    public OrderDTO(String oid, String payment_method, String nid) {
        this.oid = oid;
        this.payment_method = payment_method;
        this.nid = nid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}