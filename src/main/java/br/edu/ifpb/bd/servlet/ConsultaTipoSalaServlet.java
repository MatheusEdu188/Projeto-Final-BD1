package br.edu.ifpb.bd.servlet;

import br.edu.ifpb.bd.dao.SessaoDAO;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/consultaTipoSala")
public class ConsultaTipoSalaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SessaoDAO dao = new SessaoDAO();
        req.setAttribute("resultado", dao.quantidadePorTipoSala());

        req.getRequestDispatcher("consultaTipoSala.jsp").forward(req, resp);
    }
}