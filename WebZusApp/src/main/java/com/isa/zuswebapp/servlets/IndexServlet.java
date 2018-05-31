package com.isa.zuswebapp.servlets;

import freemarker.template.Template;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

@WebServlet("index")
public class IndexServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    Template template;

    @Override
    public void init()throws ServletException{
        try {
            template = TemplateProvider.create
        }

    }
}
