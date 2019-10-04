<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="icon" type="image/png" href="https://static.thenounproject.com/png/544325-200.png"/>
    <% String title = "Parcial 2";%>
    <title><%=title%></title>
    <link rel="stylesheet" href="libraries/bootstrap4.3.1.min.css" />
  </head>
  <body>
    <div id="root"></div>
    <script src="libraries/react16.8.1.min.js"></script>
    <script src="libraries/react16.8.1-dom.min.js"></script>
    <script src="libraries/react4.3.0-router-dom.js"></script>
    <script src="libraries/babel6.26.0.min.js"></script>

    <!-- Styles -->
    <style>
      @import './react/styles.css';
      @import './react/components/ProductList/ProductList.css';
      @import './react/components/ProductCreate/ProductCreate.css';
    </style>
    <!-- Components -->
    <script src="react/components/ProductList/ProductList.js" type="text/babel"></script>
    <script src="react/components/ProductList/ProductController.js" type="text/babel"></script>
    <script src="react/services/http.js" type="text/babel"></script>
    <script src="react/components/ProductCreate/ProductCreate.js" type="text/babel"></script>
    <!-- sweetalert2 -->
    <script src="libraries/sweetalert2.min.js"></script>
    <!-- <link rel="stylesheet" href="sweetalert2.min.css" /> -->

    <script src="react/App.js" type="text/babel"></script>
    <script src="react/index.js" type="text/babel"></script>
  </body>
</html>
