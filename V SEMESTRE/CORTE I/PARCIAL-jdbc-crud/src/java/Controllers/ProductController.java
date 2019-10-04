/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Product;
import Util.DaoUtil;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ProductController {

    private Connection connection = DaoUtil.getConnection();
    PreparedStatement ps;

    public ProductController() {

    }

    public void AddProduct(Product product) {
        postMySQL(product);
    }
    
    public void DeleteProduct(String id){
        deleteMySQL(id);
    }
    
    public void UpdateProduct(Product product){
        updateMySQL(product);
    }
    
     public ArrayList<Product> GetProducts() {
        ArrayList<Product> products = new ArrayList<>();
        GetMySQL(products);
        return products;
    }

    protected void postMySQL(Product product) {
        try {

            String TblParams = "Name, imageurl, price ";
            ps = connection
                    .prepareStatement("insert into "
                            + "jsp_react_project.products(" + TblParams + ")"
                            + " values "
                            + "(" + DaoUtil.Fields_Query(TblParams) + ");"
                    );
            // Parameters start with 1
            ps.setString(1, product.getName());
            ps.setString(2, product.getImageURL());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.err.println(e);
        } catch (java.sql.SQLSyntaxErrorException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    protected void deleteMySQL(String id) {
        try {
            ps = connection.prepareStatement("delete from jsp_react_project.products where id=?");
            ps.setString(1, id);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("deleted");
            } else {
                System.out.println("not deleted");
            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.err.println(e);
        } catch (java.sql.SQLSyntaxErrorException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    protected void updateMySQL(Product newProd) {
        try {
            ps = connection.prepareStatement("update jsp_react_project.products set name=?,imageurl=?, price=? where id=?");
            ps.setString(1, newProd.getName());
            ps.setString(2, newProd.getImageURL());
            ps.setDouble(3, newProd.getPrice());
            ps.setInt(4, newProd.getId());

            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("updated");
            } else {
                System.out.println("not updated");
            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.err.println(e);
        } catch (java.sql.SQLSyntaxErrorException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    protected void GetMySQL(ArrayList<Product> arr) {
        try {
            String query = "SELECT * FROM products";

            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String imageurl = rs.getString("imageurl");
                double price = rs.getDouble("price");

                System.out.println(name);
                Product p1 = new Product(id, name, imageurl, price);

                arr.add(p1);
            }
            st.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.err.println(e);
        } catch (java.sql.SQLSyntaxErrorException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

   

}
