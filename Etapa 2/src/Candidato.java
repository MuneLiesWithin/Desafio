public class Candidato {
	private String nome;
	private String partido;
	private int intencoesVotos;
	public Candidato(String n, String p, int v) {
		nome = n;
		partido = p;
		intencoesVotos = v;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getIntencoesVotos() {
		return intencoesVotos;
	}
	public void setIntencoesVotos(int intencoesVotos) {
		this.intencoesVotos = intencoesVotos;
	}
	@Override
	public String toString() {
		return "Candidato [nome=" + nome + ", partido=" + partido + ", intencoesVotos=" + intencoesVotos + "]";
	}
}
