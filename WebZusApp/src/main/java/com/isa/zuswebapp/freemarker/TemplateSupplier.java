package com.isa.zuswebapp.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletContext;
import java.io.IOException;

public class TemplateSupplier {

    public static final String TEMPLATES_DIRECTORY_PATHS = "/freemarker-templates";

    public static Template createTemplate(ServletContext servletContext, String templateName) throws IOException{

        Configuration config = new Configuration(Configuration.VERSION_2_3_28);

        config.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATHS);
        config.setDefaultEncoding("UTF-8");
    }
}
