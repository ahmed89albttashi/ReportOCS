/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magazz.controller;

import com.magazz.config.AppConfig;
import com.magazz.entity.Upload;
import com.magazz.service.ReportService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.View;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author ahmed
 */
@Controller
@Path("/report")
@RolesAllowed("ReporterRole")
public class ReporterController {

    @Context
    private Configuration configuration;

    private final static Logger logger = Logger.getLogger(ReporterController.class.getName());

    @Inject
    private MvcContext mvc;

    @Inject
    Models model;

    @Inject
    ReportService reportService;

    @GET
    @Path("/main")
    @View("report/main.xhtml")
    public void report() {

    }

    @GET
    @Path("/sheet/add")
    @View("report/sheet_add.xhtml")
    public void sheet_add() {

    }

    @POST
    @Path("/sheet/add")
    @View("report/sheet_add.xhtml")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void sheet_add_post(
            @FormDataParam("xlsfile") InputStream uploadedInputStream,
            @FormDataParam("xlsfile") FormDataContentDisposition fileDetails,
            @FormDataParam("filename") String filename,
            @FormDataParam("reported_on_input") String reported_on,
            @FormDataParam("description") String description) throws Exception {
        logger.info("XLSPATH = " + (String) configuration.getProperty("uploadpath"));
        String xlspath = (String) configuration.getProperty("uploadpath");

        logger.info(fileDetails.toString());

        String uploadedFileLocation = xlspath + System.currentTimeMillis() + fileDetails.getFileName();

        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        Upload upload = new Upload();
        System.out.println("REPORT  :X" + reported_on);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        upload.setReported_on(formatter.parse(reported_on));
        upload.setDescription(description);
        upload.setFilename(filename);
        upload.setFilepath(uploadedFileLocation);
        //report.setCreated_on(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        reportService.upload(upload);
        reportService.read(uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

    }
    // save uploaded file to new location

    private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {
        try {
            OutputStream out = new FileOutputStream(new File(
                    uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
