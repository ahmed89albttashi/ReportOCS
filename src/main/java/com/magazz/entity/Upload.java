/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magazz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ahmed
 */
@Entity
public class Upload implements Serializable {

    @Id
    @SequenceGenerator(name = "upload_seq_gen")
    @GeneratedValue(generator = "upload_seq_gen")
    private String id;

    private Date reported_on;
    private String filename;
    private String description;
    private User Uploaded_by;
    private Date created_on;
    private String filepath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the reported_on
     */
    public Date getReported_on() {
        return reported_on;
    }

    /**
     * @param reported_on the reported_on to set
     */
    public void setReported_on(Date reported_on) {
        this.reported_on = reported_on;
    }

    /**
     * @return the Uploaded_by
     */
    public User getUploaded_by() {
        return Uploaded_by;
    }

    /**
     * @param Uploaded_by the Uploaded_by to set
     */
    public void setUploaded_by(User Uploaded_by) {
        this.Uploaded_by = Uploaded_by;
    }

    /**
     * @return the created_on
     */
    public Date getCreated_on() {
        return created_on;
    }

    /**
     * @param created_on the created_on to set
     */
    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return "id " + id + " desc" + description;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath the filepath to set
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    //set default values if not defined 
    @PrePersist
    public void setDeafaultvalues() {
        if (created_on == null) {
            created_on = new Date(System.currentTimeMillis());
            
        }
    }

}
