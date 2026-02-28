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




@WebServlet("/consultaSubconsulta")
public class ConsultaSubconsultaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        FilmeDAO dao = new FilmeDAO();
        req.setAttribute("resultado", dao.filmeComMaisSessoes());

        req.getRequestDispatcher("consultaSubconsulta.jsp").forward(req, resp);
    }
}