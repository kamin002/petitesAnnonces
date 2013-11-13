/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packageServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Aymeric
 */
@WebServlet(name = "ServletAuthentification", urlPatterns = {"/ServletAuthentification"})
public class ServletAuthentification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String login= "kamin002";
    String motDePasse= "loulou";
    String n;
    String m;
    static org.jdom2.Document document;
    static Element racine;
    
    public static void lireFichier()
    {
        SAXBuilder sxb = new SAXBuilder();
        try
        {
           document = sxb.build(new File("D:\\Documents\\GitHub\\petitesAnnonces\\petitesAnnonces\\utilisateurs.xml"));
        }
        catch(JDOMException | IOException e){
        
        System.out.println(e);}

        //On initialise un nouvel élément racine avec l'élément racine du document.
        racine = document.getRootElement();
    }
    
    public static boolean connexionUtilisateur(String id, String mdp)
    {
            lireFichier();
            
            boolean b= false;

            List<Element> listeUtilisateurs= racine.getChildren("utilisateur");

            Iterator<Element> it = listeUtilisateurs.iterator();
            
            while(it.hasNext() && !b)
            {
                   Element courant = it.next();

                   if(id.equals(courant.getChild("id").getText()))
                   {
                            if(mdp.equals(courant.getChild("mdp").getText()))
                                return true;
      
                   }                      
            }

            return b;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
              
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAuthentification</title>");            
            out.println("</head>");
            out.println("<body>");
            /* Question 2
            if((n= request.getParameter("nom")) != null && (m= request.getParameter("mdp")) != null)
            {
                if(login.equals(n) && motDePasse.equals(m))
                    out.println("<h1> Authentification réussie </h1>");
                else
                    out.println("<h1> Tu t'es gouré pélo !</h1>");
            }      
            */    
                
            //Question 3
           if(connexionUtilisateur(request.getParameter("nom"), request.getParameter("mdp")))
                out.println("Tu as réussi !");
            else
                out.println("Y a une couille dans l'authentification pélo !");
            
            out.println("</body>");
            out.println("</html>");
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
