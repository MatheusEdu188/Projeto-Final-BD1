package br.edu.ifpb.bd.servlet;

import java.io.IOException;

import br.edu.ifpb.bd.dao.FilmeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removerFilme")
public class RemoverFilmeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
            try {
                String id = req.getParameter("id");

                if(id != null && !id.isEmpty()){
                    int idFilme = Integer.parseInt(id);
                    FilmeDAO dao = new FilmeDAO();
                    dao.remover(idFilme);
                }
                resp.sendRedirect("listarFilmes");
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }    
}
