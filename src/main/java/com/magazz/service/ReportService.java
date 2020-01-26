/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magazz.service;

import com.magazz.entity.Report;
import com.magazz.entity.Upload;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ahmed
 */
@Stateless
public class ReportService {
    
    @PersistenceContext
    EntityManager entityManager;
    
   public void upload(Upload upload) {
       System.out.println(upload.getReported_on().toString());
       entityManager.persist(upload);
       
   }
   
   
    public void read(String filepath) throws IOException{
        System.out.println("com.magazz.service.ReaderService.read()");

        FileInputStream inputStream = new FileInputStream(new File(filepath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        //Sheet sheet = workbook.getSheetAt(0);

        for (Sheet sheet : workbook) {

            for (Row row : sheet) {
                Report report = new Report();
                report.setCustomer_code(row.getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setCustomer_name(row.getCell(1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setPosting_date(new Date());
                report.setYear_date(new Date());
                report.setDocument_number(row.getCell(4,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setRemaining_amount(66.6);
                report.setSales_person_code(row.getCell(6,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setSales_person_name(row.getCell(7,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setExternal_document(row.getCell(8,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setBus_posting_group(row.getCell(9,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                report.setSo_no(row.getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                System.out.println("cus_cpode"+row.getCell(1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString());
                //row.getCell(0,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                try{
                    entityManager.persist(report);
                }catch(Exception e){
                    System.out.println("OUT "+e.toString());
                }
                

                
                for (Cell cell : row) {
                    System.out.println("com.magazz.service.ReaderService.read()"+cell);
                    // Do something here
                }

            }

        }
        

    }
   
}
