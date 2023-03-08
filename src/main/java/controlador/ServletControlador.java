/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import datos.Pais;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author andres
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

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
        String nombres[] = request.getParameterValues("name");
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Pais> paises = new ArrayList<Pais>();
        if (nombres != null) {
            try {
                con = Conexion.getConnection();
                String ordenSQL = "SELECT * FROM COUNTRY WHERE ";
                for (int i = 0; i < nombres.length; i++) {
                    ordenSQL += "name = " + "'"+nombres[i]+"'";
                    if (i != nombres.length - 1) {
                        ordenSQL += " or ";
                    }
                }
                ordenSQL += " AND population > 0 ORDER BY population DESC";
                System.out.println(ordenSQL);
                st = con.prepareStatement(ordenSQL);
                rs = st.executeQuery();
                boolean ejecucionConsulta = st.execute();

                if (ejecucionConsulta) {
                    rs = st.getResultSet();
                    if (rs == null) {
                        System.out.println("nulo");
                    }
                    while (rs.next()) {
                        paises.add(new Pais(rs.getString("NAME"), rs.getString("CONTINENT"), rs.getInt("POPULATION"),rs.getInt("INDEPYEAR")));
                    }
                }
                System.out.println("PAISES SIZE: " + paises.size());
                request.setAttribute("listadoPaises", paises);
                //request.setAttribute("excepcion",Conexion.ayuda());
                request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                String msg = e.getMessage();
                request.setAttribute("excepcion",msg + " " +Conexion.ayuda());
                request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
            } finally {
                if (con != null) {
                    Conexion.close(con);
                }
                if (rs != null) {
                    Conexion.close(rs);
                }
                if (st != null) {
                    Conexion.close(st);
                }
            }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
