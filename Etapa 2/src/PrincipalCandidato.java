import java.io.*;
import java.util.*;

public class PrincipalCandidato {
	private static String sorteioNome() {
		String [] nomes = null;
		try {
			FileReader fr = new FileReader("nomes.txt");
			BufferedReader in = new BufferedReader(fr);
			nomes = new String[100];
			for(int i = 0; i < nomes.length; i++) {
				nomes[i] = in.readLine();
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
		catch(IOException e) {
			System.out.println("IO Exception!");
		}
		return nomes[(int)(Math.random() * 100)];
	}
	private static String sorteioPartido() {
		String [] partidos = null;
		try {
			FileReader fr = new FileReader("partidos.txt");
			BufferedReader in = new BufferedReader(fr);
			partidos = new String[100];
			for(int i = 0; i < partidos.length; i++) {
				partidos[i] = in.readLine();
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}
		catch(IOException e) {
			System.out.println("IO Exception!");
		}
		return partidos[(int)(Math.random() * 100)];
	}
	public static int pesquisaBinariaCandidatos(String nome, Candidato[] candidatos){
		int inicio = 0;
        int fim = candidatos.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            String nomeAtual = candidatos[meio].getNome();
            if (nomeAtual.equals(nome)) {
                if (meio == 0 || !candidatos[meio - 1].getNome().equals(nome)) {
                    return meio;
                } else {
                    fim = meio - 1; 
                }
            } else if (nomeAtual.compareTo(nome) < 0) {
                inicio = meio + 1; 
            } else {
                fim = meio - 1; 
            }
        }
        return -1; 
    }
    public static Candidato [] ordenaCandidatosPorNome(Candidato[] candidatos){
         for (int i = 1; i < candidatos.length; i++) {
        	 int j = i;
        	 String nom = candidatos[i].getNome();
             Candidato cand = candidatos[i];
             while ((j > 0) && (candidatos[j - 1].getNome().compareTo(nom) > 0)) {
                 candidatos[j] = candidatos[j - 1];
                 j--;
             }
             candidatos[j] = cand;
         }
         return candidatos;
    }
        
     public static Candidato [] ordenaCandidatosPorPartido(Candidato[] candidatos){
    	 for (int i = 1; i < candidatos.length; i++) {
    		 int j = i;
    		 String par = candidatos[i].getPartido();
             Candidato cand = candidatos[i];
             while ((j > 0) && (candidatos[j - 1].getPartido().compareTo(par) > 0)) {
                 candidatos[j] = candidatos[j - 1];
                 j--;
             }
             candidatos[j] = cand;
         }
         return candidatos;
    }
     public static Candidato [] ordenaCandidatosPorVotos(Candidato[] candidatos){
    	for(int i = 1; i < candidatos.length; i++) {
    		int j = i;
    		int votos = candidatos[i].getIntencoesVotos();
    		Candidato cand = candidatos[i];
    		while((j > 0) && (candidatos[j - 1].getIntencoesVotos() > votos)) {
    			candidatos[j] = candidatos[j - 1];
    			j--;
    		}
    		candidatos[j] = cand;
    	}
        return candidatos;
    }
	public static void main(String args[]) {
		Candidato [] candidatos = new Candidato[(int)(Math.random() * 100)];
		for(int i = 0; i < candidatos.length; i++) {
			candidatos[i] = new Candidato(PrincipalCandidato.sorteioNome(), 
										  PrincipalCandidato.sorteioPartido(), 
										  (int)(Math.random() * 100));
		}
		
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println(candidatos[i].toString());
		}
		
		PrincipalCandidato.ordenaCandidatosPorPartido(candidatos);
		PrincipalCandidato.ordenaCandidatosPorVotos(candidatos);
		PrincipalCandidato.ordenaCandidatosPorNome(candidatos);
		
		System.out.println("\nAPÓS ORDENAÇÃO!\n");
		
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println(candidatos[i].toString());
		}
		
		Scanner read = new Scanner(System.in);
		System.out.print("\nPesquise o nome de um candidato: ");
		String nome = read.nextLine();
		int index = PrincipalCandidato.pesquisaBinariaCandidatos(nome, candidatos);
		System.out.println("\n" + candidatos[index].toString());
		read.close();
	}
}
