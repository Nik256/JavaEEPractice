package com.epam.converter.web;

import com.epam.converter.bean.ConverterBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/converter")
public class ConverterServlet extends HttpServlet {
    @EJB
    ConverterBean converterBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        if (amount != null && amount.length() > 0) {
            // convert the amount to a BigDecimal from the request parameter
            BigDecimal d = new BigDecimal(amount);
            // call the ConverterBean.dollarToYen() method to get the amount
            // in Yen
            BigDecimal yenAmount = converterBean.dollarToYen(d);

            // call the ConverterBean.yenToEuro() method to get the amount
            // in Euros
            BigDecimal euroAmount = converterBean.yenToEuro(yenAmount);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print("Euro amount: " + euroAmount.toString());
            out.flush();
        }
    }

}
