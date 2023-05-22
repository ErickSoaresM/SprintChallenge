package br.com.bettertech.BO;

import br.com.bettertech.DAO.ResultadoreqDAO;
import java.util.List;

public class ResultadoreqBO {
    private ResultadoreqDAO resultadoreqDAO;

    public ResultadoreqBO() {
        resultadoreqDAO = new ResultadoreqDAO();
    }

    public void adicionarResultadoreq(Resultadoreq resultadoreq) {
        resultadoreqDAO.adicionar(resultadoreq);
    }

    public Resultadoreq buscarResultadoreqPorId(int id) {
        return resultadoreqDAO.buscarPorId(id);
    }

    public List<Resultadoreq> buscarTodosResultadoreqs() {
        return resultadoreqDAO.buscarTodos();
    }

    public void atualizarResultadoreq(Resultadoreq resultadoreq) {
        resultadoreqDAO.atualizar(resultadoreq);
    }

    public void excluirResultadoreq(int id) {
        resultadoreqDAO.excluir(id);
    }
}
