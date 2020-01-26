/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magazz.controller;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author ahmed.b
 */
@Controller
@Path("/sec")
public class SecurityController {

    private final static Logger logger = Logger.getLogger(SecurityController.class.getName());

    @Inject
    private Models models;

    @Context
    private SecurityContext securityContext;

    @GET
    @Path("/login")
    @View("security/login.jsp")
    public void login(@QueryParam("auth") int status) {

    }

    @GET
    @Path("/login/err")
    @View("security/login.jsp")
    public void login_err(@QueryParam("auth") int status) {

    }

    @GET
    @Path("/logout")
    public String logout(@Context HttpServletRequest request) throws ServletException {

        logger.warning("before :" + request.getSession().toString());
        request.logout();
        request.getSession().invalidate();
        logger.warning("after  :" + request.getSession().toString());

        return "redirect:/sec/login";
    }

    //unAutherized
    @GET
    @Path("/err_401permission")
    @View("security/login.jsp")
    public void err_401() {
        logger.warning("401 :" );
        //logger.warning( request.getSession().toString());

    }

    //not found
    @GET
    @Path("/err_404")
    @View("security/err_404.jsp")
    public void err_404(@Context HttpServletRequest request) {
        logger.warning("404 :" + request.getSession().toString());

    }

    @GET
    @Path("/mainnn")
    @View("template/main1.xhtml")
    public void mainn() {

    }

}
