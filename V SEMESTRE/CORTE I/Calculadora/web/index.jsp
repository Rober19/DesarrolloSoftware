<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <% String title = "Calculadora Rober19";%>
        <title><%=title%></title>
        <link rel="stylesheet" href="libraries/bootstrap4.3.1.min.css" >

        <link rel="stylesheet" href="https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.css" >
    </head>
    <body>
        <div id="root"></div>


        <script src="https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.min.js"></script>
        <script src='libraries/react16.8.1.min.js'></script>
        <script src='libraries/react16.8.1-dom.min.js'></script>
        <script src='libraries/react4.3.0-router-dom.js'></script>
        <script src="libraries/babel6.26.0.min.js"></script>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <!-- Styles -->
        <style>
            @import './react/styles.css';
            @import './react/components/Calculadora/Calculadora.css';
            @import './react/components/Calculadora/Calculadora.css';
        </style>
        <!-- Components -->
        <script src="react/components/Calculadora/Calculadora.js" type="text/babel"></script>   

        <script src="react/App.js" type="text/babel"></script>
        <script src="react/index.js" type="text/babel"></script>
    </body>
</html>
