package br.edu.ifpb.bd.servlet;

import br.edu.ifpb.bd.dao.FilmeDAO;
import br.edu.ifpb.bd.model.Filme;
import br.edu.ifpb.bd.dto.FilmeDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrarFilme")
public class CadastrarFilmeServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    req.getRequestDispatcher("formFilme.jsp").forward(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    try {
        Filme filme = new Filme();
        filme.setTitulo(req.getParameter("titulo"));
        filme.setDuracao(Integer.parseInt(req.getParameter("duracao")));
        filme.setClassificacao(req.getParameter("classificacao"));
        filme.setGenero(req.getParameter("genero"));

        FilmeDAO dao = new FilmeDAO();

        dao.salvar(filme);

        resp.sendRedirect("listarFilmes");
    } catch (Exception e) {
        throw new ServletException(e);
    }
}
}