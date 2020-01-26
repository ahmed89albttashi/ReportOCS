/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magazz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author ahmed
 */
@Entity
public class Report implements Serializable {

    @Id
    @SequenceGenerator(name = "report_seq_gen")
    @GeneratedValue(generator = "report_seq_gen")
    private Long id;

    
    private String customer_code;
    private String customer_name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date posting_date;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date year_date;
    private String document_number;
    private double remaining_amount;
    private String sales_person_code;
    private String sales_person_name;
    private String external_document;
    private String bus_posting_group;
    private String so_no;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the customer_code
     */
    public String getCustomer_code() {
        return customer_code;
    }

    /**
     * @param customer_code the customer_code to set
     */
    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    /**
     * @return the customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * @param customer_name the customer_name to set
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /**
     * @return the posting_date
     */
    public Date getPosting_date() {
        return posting_date;
    }

    /**
     * @param posting_date the posting_date to set
     */
    public void setPosting_date(Date posting_date) {
        this.posting_date = posting_date;
    }

    /**
     * @return the document_number
     */
    public String getDocument_number() {
        return document_number;
    }

    /**
     * @param document_number the document_number to set
     */
    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    /**
     * @return the remaining_amount
     */
    public double getRemaining_amount() {
        return remaining_amount;
    }

    /**
     * @param remaining_amount the remaining_amount to set
     */
    public void setRemaining_amount(double remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    /**
     * @return the sales_person_code
     */
    public String getSales_person_code() {
        return sales_person_code;
    }

    /**
     * @param sales_person_code the sales_person_code to set
     */
    public void setSales_person_code(String sales_person_code) {
        this.sales_person_code = sales_person_code;
    }

    /**
     * @return the sales_person_name
     */
    public String getSales_person_name() {
        return sales_person_name;
    }

    /**
     * @param sales_person_name the sales_person_name to set
     */
    public void setSales_person_name(String sales_person_name) {
        this.sales_person_name = sales_person_name;
    }

    /**
     * @return the external_document
     */
    public String getExternal_document() {
        return external_document;
    }

    /**
     * @param external_document the external_document to set
     */
    public void setExternal_document(String external_document) {
        this.external_document = external_document;
    }

    /**
     * @return the bus_posting_group
     */
    public String getBus_posting_group() {
        return bus_posting_group;
    }

    /**
     * @param bus_posting_group the bus_posting_group to set
     */
    public void setBus_posting_group(String bus_posting_group) {
        this.bus_posting_group = bus_posting_group;
    }

    /**
     * @return the so_no
     */
    public String getSo_no() {
        return so_no;
    }

    /**
     * @param so_no the so_no to set
     */
    public void setSo_no(String so_no) {
        this.so_no = so_no;
    }

    /**
     * @return the year_date
     */
    public Date getYear_date() {
        return year_date;
    }

    /**
     * @param year_date the year_date to set
     */
    public void setYear_date(Date year_date) {
        this.year_date = year_date;
    }
    
    
    @PrePersist
    public void set_default_value(){
        if(so_no==null){
           so_no="";
        }
    }

}
