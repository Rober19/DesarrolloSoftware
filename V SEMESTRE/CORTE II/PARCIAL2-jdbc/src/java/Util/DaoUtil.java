/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;

/**
 *
 * @author Rober19
 */
public class DaoUtil {

    public static int absl(int i) {
        return Math.abs(i);
    }

    public static <T> boolean NotNullOrEmpty(T str) {

        if (str.getClass().toString().equals("class java.util.ArrayList")) {
            List<T> arr = (ArrayList) str;
            if (arr.size() > 0) {
                return true;
            } else {
                return false;
            }
        }
        if (str != null) {
            return true;
        }
        return false;
    }

        public static Connection getConnection() {
        return DbUtil.getConnection();
    }

    public static String Fields_Query(String params) {
        String[] parts = params.split(",");
        String total_params = "";
        for (String data : parts) {
            total_params += "?,";
        }
        return total_params.substring(0, total_params.length() - 1);
    }

    public static String DB_ID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
