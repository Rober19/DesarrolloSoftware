/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Persona;
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

public class PersonaController {

    private Connection connection = DaoUtil.getConnection();
    PreparedStatement ps;

    public PersonaController() {

    }

    public void AddPersona(Persona product) {
        postMySQL(product);
    }

    public void DeleteProduct(String id) {
//        deleteMySQL(id);
    }

    public void UpdateProduct(Persona product) {
//        updateMySQL(product);
    }
    
       public ArrayList<Persona> GetPersonas() {
        ArrayList<Persona> products = new ArrayList<>();
        GetMySQL(products);
        return products;
    }
    
    protected void GetMySQL(ArrayList<Persona> arr) {
        try {
            String query = "SELECT * FROM persona";

            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String programming_language = rs.getString("programming_language");
                String hobbies = rs.getString("hobbies");

                String[] arr_string = hobbies.split(";");
                ArrayList<String> hobbies_arr = new ArrayList();

                for (String item : arr_string) {
                    hobbies_arr.add(item);
                }

                System.out.println(name);
                Persona p1 = new Persona(id, name, lastname, email, programming_language, hobbies_arr);

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


    protected void postMySQL(Persona person) {
        try {

            String TblParams = "name, lastname, email, programming_language, hobbies ";
            ps = connection
                    .prepareStatement("insert into "
                            + "persona(" + TblParams + ")"
                            + " values "
                            + "(" + DaoUtil.Fields_Query(TblParams) + ");"
                    );
            // Parameters start with 1
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastname());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getProgramming_language());
            String listHobbies = "";
            for (String item : person.getHobbies()) {
                listHobbies += item + ";";
            }
            ps.setString(5, listHobbies);

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

//    protected void deleteMySQL(String id) {
//        try {
//            ps = connection.prepareStatement("delete from jsp_react_project.products where id=?");
//            ps.setString(1, id);
//            int i = ps.executeUpdate();
//            if (i != 0) {
//                System.out.println("deleted");
//            } else {
//                System.out.println("not deleted");
//            }
//        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
//            System.err.println(e);
//        } catch (java.sql.SQLSyntaxErrorException e) {
//            System.err.println(e);
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.err.println(e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println(e);
//            e.printStackTrace();
//        }
//    }

//    protected void updateMySQL(Persona newProd) {
//        try {
//            ps = connection.prepareStatement("update jsp_react_project.products set name=?,imageurl=?, price=? where id=?");
//            ps.setString(1, newProd.getName());
//            ps.setString(2, newProd.getImageURL());
//            ps.setDouble(3, newProd.getPrice());
//            ps.setInt(4, newProd.getId());
//
//            int i = ps.executeUpdate();
//            if (i != 0) {
//                System.out.println("updated");
//            } else {
//                System.out.println("not updated");
//            }
//        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
//            System.err.println(e);
//        } catch (java.sql.SQLSyntaxErrorException e) {
//            System.err.println(e);
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.err.println(e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println(e);
//            e.printStackTrace();
//        }
//    }


}
