package com.magazz.config;

import com.magazz.controller.ReporterController;
import com.magazz.controller.SecurityController;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.mvc.engine.ViewEngine;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Default JAX-RS application listening on /
 */
@ApplicationScoped
@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                errorPage = "/sec/login/err",
                loginPage = "/sec/login",
                useForwardToLogin = false)
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:global/MyDS",
        callerQuery = "#{'select password from caller where name = ?'}",
        groupsQuery = "select group_name from caller_groups where caller_name = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priorityExpression = "#{100}",
        hashAlgorithmParameters = {
            "Pbkdf2PasswordHash.Iterations=3072",
            "${securityConfig.dyna}"
        }
)
@DeclareRoles({"ReporterRole"})
@ApplicationPath("/reporter")
public class AppConfig extends Application {

//    public static final String PROPERTIES_FILE = "application.properties";
//    public static Properties properties = new Properties();

    @Override
    public Set<Class<?>> getClasses() {


        Set<Class<?>> classes = new HashSet<>();

        classes.add(SecurityController.class);
        classes.add(ReporterController.class);

        return classes;
    }
//
//    private Properties readProperties() {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
//        if (inputStream != null) {
//            try {
//                properties.load(inputStream);
//            } catch (IOException e) {
//                // TODO Add your custom fail-over code here
//                e.printStackTrace();
//            }
//        }
//        return properties;
//    }

    @Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> map = new HashMap<>();
        //map.put(ViewEngine.VIEW_FOLDER, "/views/");
        map.put("jersey.config.server.provider.classnames", 
            "org.glassfish.jersey.media.multipart.MultiPartFeature");
        
        map.put("uploadpath", "/home/ahmed/temp/reporterfilesupload/");
        return map;
    }
}
