package br.com.bettertech.TO;

public class ResultadoreqTO {
	
	private String Requisicao;
	private String Usuario;
	private String Resultado;
	private int Id;
	public String getRequisicao() {
		return Requisicao;
	}
	public void setRequisicao(String requisicao) {
		Requisicao = requisicao;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getResultado() {
		return Resultado;
	}
	public void setResultado(String resultado) {
		Resultado = resultado;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
