/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.CalculadoraController;
import Entities.Operacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rober19
 */
@WebServlet(name = "CalcuServlet", urlPatterns = {"/CalcuServlet"})
public class CalcuServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        CalculadoraController clc = new CalculadoraController();

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String productsListJson = prettyGson.toJson(clc.sumar(12, 23));
        out.print(productsListJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        CalculadoraController clc = new CalculadoraController();

        try {

            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = req.getReader().readLine()) != null) {
                sb.append(body);
            }

            Operacion op_valores = gson.fromJson(sb.toString(), Operacion.class);
            String productJson = gson.toJson(op_valores);
            double resultado = 0;
            //productController.AddProduct(product);
            switch (op_valores.getOperacion()) {
                case "sumar":
                    resultado = clc.sumar(op_valores.getValor1(), op_valores.getValor2());
                    productJson = gson.toJson(resultado);
                    out.print(resultado);
                    break;
                case "restar":
                    resultado = clc.restar(op_valores.getValor1(), op_valores.getValor2());
                    productJson = gson.toJson(resultado);
                    out.print(resultado);
                    break;
                case "multiplicar":
                    resultado = clc.multiplicar(op_valores.getValor1(), op_valores.getValor2());
                    productJson = gson.toJson(resultado);
                    out.print(resultado);
                    break;
                case "dividir":
                    resultado = clc.dividirReal(op_valores.getValor1(), op_valores.getValor2());
                    productJson = gson.toJson(resultado);
                    out.print(resultado);
                    break;
                default:
                    productJson = gson.toJson(op_valores);
                    out.print(productJson);
                    break;
            }

            System.out.println(
                    op_valores.getValor1()
                    + " " + op_valores.getValor2()
                    + " " + op_valores.getOperacion());

        } catch (Exception ex) {
            String err = gson.toJson(ex);
            out.print(err);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
