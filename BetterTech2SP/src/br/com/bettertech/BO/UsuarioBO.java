package br.com.bettertech.BO;

import br.com.bettertech.DAO.UsuarioDAO;
import br.com.bettertech.TO.UsuarioTO;

public class UsuarioBO {
	UsuarioDAO ud = null;

	public UsuarioTO validacao(UsuarioTO u) {
		ud = new UsuarioDAO();
		return ud.loginDAO(u);
	}
}