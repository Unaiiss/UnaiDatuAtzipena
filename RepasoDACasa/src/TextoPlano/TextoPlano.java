package TextoPlano;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextoPlano {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fichero = "src\\TextoPlano\\texto_plano";
		  
		
		try {
			//EJEMPLO SENCILLO DE ESCRITURA CON BUFFEREDWRITER
			FileWriter fw = new FileWriter(fichero, true);	//true NO sobreescribe, false si 
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Esto lo acabo de escribir");
			bw.write("\n");
			bw.close();
			
			//EJEMPLO SENCILLO DE LECTURA CON BUFFEREDREADER
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String lerroa;
            while ((lerroa = br.readLine()) != null) {
                System.out.println(lerroa); // Lerroz lerro irakurtzen du
            }
            br.close();
			
		} catch (IOException e) {
			System.err.println("Errorea gertatu da: " + e.getMessage());
		}

	}

}
