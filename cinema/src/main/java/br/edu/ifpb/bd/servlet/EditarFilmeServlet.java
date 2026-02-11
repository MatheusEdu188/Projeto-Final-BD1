package br.edu.ifpb.bd.servlet;

import java.io.IOException;

import br.edu.ifpb.bd.dao.FilmeDAO;
import br.edu.ifpb.bd.model.Filme;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editarFilme")
public class EditarFilmeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String id = req.getParameter("id");

            if (id == null || id.isEmpty()) {
                resp.sendRedirect("listarFilmes");
                return;
            }

            FilmeDAO filmeDao = new FilmeDAO();
            Filme filme = filmeDao.buscarPorId(Integer.parseInt(id));

            if (filme != null) {
                req.setAttribute("filme", filme);
                req.getRequestDispatcher("editarFilme.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("listarFilmes");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String id = req.getParameter("id");

            if (id != null && !id.isEmpty()) {
                Filme filme = new Filme();
                filme.setId(Integer.parseInt(id));
                filme.setTitulo(req.getParameter("titulo"));
                filme.setDuracao(Integer.parseInt(req.getParameter("duracao")));
                filme.setClassificacao(req.getParameter("classificacao"));
                filme.setGenero(req.getParameter("genero"));

                new FilmeDAO().updateFilme(filme);
            }

            resp.sendRedirect("listarFilmes");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
