package br.edu.ifpb.bd.servlet;

import br.edu.ifpb.bd.dao.FilmeDAO;
import br.edu.ifpb.bd.model.Filme;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/consultaGenero")
public class ConsultaGeneroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String genero = req.getParameter("genero");

        FilmeDAO dao = new FilmeDAO();
        req.setAttribute("resultado", dao.listarSessoesPorGenero(genero));

        req.getRequestDispatcher("consultaGenero.jsp").forward(req, resp);
    }
}
