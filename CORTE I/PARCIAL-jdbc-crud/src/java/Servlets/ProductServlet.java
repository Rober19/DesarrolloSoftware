package Servlets;

import Controllers.ProductController;
import Entities.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    ProductController productController = new ProductController();
    // private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        String type = req.getParameter("type");

        switch (type) {
            case "getall": {
                Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                String productsListJson = prettyGson.toJson(productController.GetProducts());
                out.print(productsListJson);
                break;
            }
            case "getbyId": {
                Gson gson = new Gson();
                String id = req.getParameter("id");
                String productJson = gson.toJson(productController.GetProducts().get(Integer.parseInt(id) - 1));
                out.print(productJson);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        Gson gson = new Gson();

        try {

            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = req.getReader().readLine()) != null) {
                sb.append(body);
            }

            Product product = (Product) gson.fromJson(sb.toString(), Product.class);
            productController.AddProduct(product);
            String productJson = gson.toJson(product);
            out.print(productJson);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        Gson gson = new Gson();

        try {

            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = req.getReader().readLine()) != null) {
                sb.append(body);
            }

            JsonObject jobj = new Gson().fromJson(sb.toString(), JsonObject.class);

            String result = jobj.get("id").toString();

            try {
                productController.DeleteProduct(result);
            } catch (Exception ex) {
                out.print(gson.toJson(jsres("err", ex.toString())));
            }

            out.print(result);

            // Product product = (Product) gson.fromJson(sb.toString(), Product.class);
            //productController.DeleteProduct(body);
            //String productJson = gson.toJson(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print(gson.toJson(jsres("err", ex.toString())));
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        Gson gson = new Gson();

        try {

            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = req.getReader().readLine()) != null) {
                sb.append(body);
            }            
            //out.print(gson.toJson(jsres("msg", "hello from put")));

            Product product = (Product) gson.fromJson(sb.toString(), Product.class);
            productController.UpdateProduct(product);
            String productJson = gson.toJson(product);
            out.print(productJson);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

         //To change body of generated methods, choose Tools | Templates.
    }

    public JsonObject jsres(String key, String value) {
        JsonObject obj = new JsonObject();
        obj.addProperty(key, value);
        return obj;
    }

}
