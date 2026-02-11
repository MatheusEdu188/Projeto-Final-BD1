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

@WebServlet("/buscarFilme")
public class BuscarFilmeServlet extends HttpServlet {

    private FilmeDAO filmeDAO = new FilmeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Filme filme = filmeDAO.buscarPorId(id);

                if (filme != null) {
                    request.setAttribute("filme", filme);
                } else {
                    request.setAttribute("mensagem", "Filme não encontrado!");
                }

            } catch (NumberFormatException e) {
                request.setAttribute("mensagem", "ID inválido!");
            }
        } else {
            request.setAttribute("mensagem", "Informe um ID!");
        }

        request.getRequestDispatcher("buscarFilme.jsp").forward(request, response);
    }
}
