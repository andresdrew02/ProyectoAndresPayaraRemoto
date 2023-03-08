<%-- 
    Document   : index
    Created on : 27-feb-2023, 20:26:47
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleccionar paises</title>
        <link rel="stylesheet" href="./global.css"/>
    </head>
    <body>
    <c:out value="${excepcion}"></c:out>
    <h1>Elige paises</h1>
        <form method="get" action="ServletControlador">
            <div class="wrapper">
                <div class="form-control">
                <p>España: </p>
                <label class="checkBox">
                    <input type="checkbox" name="name" value="Spain"/>
                    <div class="transition"></div>
                </label>
            </div>
            <div class="form-control">
                <p>Ucrania: </p>
                <label class="checkBox">
                   <input type="checkbox" name="name" value="Ukraine"/>
                    <div class="transition"></div>
                </label>
            </div>
            <div class="form-control">
                <p>Portugal:</p>
                <label class="checkBox">
                   <input type="checkbox" name="name" value="Portugal"/>
                    <div class="transition"></div>
                </label>
                
            </div>
            <div class="form-control">
                <p>
                    Malta: 
                </p>
                <label class="checkBox">
                   <input type="checkbox" name="name" value="Malta"/>
                    <div class="transition"></div>
                </label>
            </div>
            </div>
            <input type="submit" value="Seleccionar"/>
        </form>
    </body>
</html>
