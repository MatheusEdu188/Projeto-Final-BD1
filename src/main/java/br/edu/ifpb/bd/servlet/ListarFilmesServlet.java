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

@WebServlet("/listarFilmes")
public class ListarFilmesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        FilmeDAO dao = new FilmeDAO();  
        List<Filme> filmes = dao.listar(); 

        req.setAttribute("filmes", filmes); 

       
        req.getRequestDispatcher("listarFilmes.jsp").forward(req, resp);
    }
}
