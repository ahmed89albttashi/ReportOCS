///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.magazz.config;
//
//import javax.annotation.sql.DataSourceDefinition;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//
///**
// *
// * @author ahmed
// */
//    
//
//
//@DataSourceDefinition(
//    name = "java:global/MyDS",
//    className = "org.postgresql.xa.PGXADataSource",
//    url="jdbc:postgresql://127.0.0.1:5432/reportocs",
//    password = "oman",
//    user = "postgres",
//    databaseName = "reportocs",
//    serverName = "localhost",
//    portNumber = 5432)
//@Singleton
//@Startup
//public class DBConfig {
// 
//    
//////@DataSourceDefinition(
//////    name = "java:global/MyDS",
//////    className = "org.h2.jdbcx.JdbcDataSource",
//////    url="jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE"
//////)
////
////@DataSourceDefinition(
////    name = "java:global/MyDS",
////    className = "org.postgresql.xa.PGXADataSource",
////    url="jdbc:postgresql://127.0.0.1:5432/reportocs",
////    password = "oman",
////    user = "postgres",
////    databaseName = "reportocs",
////    serverName = "localhost",
////    portNumber = 5432
////)
////@Singleton
////@Startup
////public class DatabaseSetup {
////    
////    @Resource(lookup="java:global/MyDS")
////    private DataSource dataSource;
//}
