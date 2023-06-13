import java.io.*;

public class Labirinto {
	char [][] labirinto;
	public char[][] criaLabirinto(String filename) {
		char[][] lab = null;
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader in = new BufferedReader(fr);
			in.mark((int)f.length() + 1);
			int linhas = 1;
			int colunas = in.readLine().length();
			while(in.readLine() != null) {
				linhas++;
			}
			lab = new char[linhas][colunas];
			in.reset();
			for(int i = 0; i < lab.length; i++) {
				for(int j = 0; j < lab[i].length; j++) {
					lab[i][j] = in.readLine().charAt(j);
					in.reset();
				}
				in.readLine();
				in.mark((int)f.length() + 1);
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return lab;
	}
	public void imprimeLab(char[][] lab) {
		for(int i = 0;i < lab.length;i++) {
			for(int j = 0; j < lab[i].length; j++) {
				System.out.print(lab[i][j]);
			}
			System.out.println();
		}
	}
	public boolean percorreLabirinto() throws NullPointerException{
		if(labirinto == null) throw new NullPointerException();
		return percorreLabirinto(labirinto, 0, 0);
	}
	private boolean percorreLabirinto(char [][] labirinto, int linha, int coluna) {
		int linhas = labirinto.length;
        int colunas = labirinto[0].length;

        if (linha < 0 || coluna < 0 || linha >= linhas || coluna >= colunas) {
            return false;
        }
        
        if (labirinto[linha][coluna] == 'D') {
            return true;
        }

        if (labirinto[linha][coluna] == 'X' || labirinto[linha][coluna] == '*') {
            return false;
        }

        labirinto[linha][coluna] = '*';
        if (percorreLabirinto(labirinto, linha - 1, coluna)) { 
            return true;
        }
        if (percorreLabirinto(labirinto, linha + 1, coluna)) { 
            return true;
        }
        if (percorreLabirinto(labirinto, linha, coluna - 1)) { 
            return true;
        }
        if (percorreLabirinto(labirinto, linha, coluna + 1)) { 
            return true;
        }

        labirinto[linha][coluna] = ' ';

        return false;
	}
	public static void main(String args[]) {
		
		Labirinto lab = new Labirinto();
		lab.labirinto = lab.criaLabirinto("Desafio/Etapa 1/labirinto.txt");
		System.out.println(lab.percorreLabirinto());
		lab.imprimeLab(lab.labirinto);
		
		System.out.println();
		
		lab.labirinto = lab.criaLabirinto("Desafio/Etapa 1/labirinto2.txt");
		System.out.println(lab.percorreLabirinto());
		lab.imprimeLab(lab.labirinto);
		/* 
		try{
			FileWriter fr = new FileWriter("Desafio/Etapa 1/labirinto.txt");
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		*/
	}
}

