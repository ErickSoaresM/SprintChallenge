package br.com.bettertech.teste;

import br.com.bettertech.BO.UsuarioBO;
import br.com.bettertech.TO.UsuarioTO;


public class Teste {

	public static void main(String[] args) {
		
		//UsuarioDAO ud = new UsuarioDAO();
		UsuarioBO ub = new UsuarioBO();
		UsuarioTO ut = new UsuarioTO("4","4");
		
		System.out.println("RESPOSTA : " + ub.validacao(ut).getLogin());

	}

}
