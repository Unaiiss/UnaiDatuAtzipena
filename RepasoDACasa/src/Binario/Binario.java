package Binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Binario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String fichero_byte = "src\\Binario\\fichero_byte";
        String fichero_primitivo = "src\\Binario\\fichero_datoPrimitivo";
        String fichero_objeto = "src\\Binario\\fichero_objeto";
        
		
        //============ ESCRIBIR DATOS ============
		try {
			//ESCRIBIR BYTE (NUMERICO) CON FILE OUTPUT STREAM
			FileOutputStream fos = new FileOutputStream(fichero_byte);
	        fos.write(65); // 'A' karakterearen byte-a idazten du
	        fos.close();
	        
	        //ESCRIBIR DATOS PRIMITIVOS (INT, DOUBLE, STRING...) CON DATA OUTPUT STREAM
	        
	        //EN LOS DOS SIGUIENTES SE NECESITA COMO ARGUMENTO UN FILE OUTPUT STREAM
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero_primitivo));
            dos.writeInt(8);
            dos.writeDouble(1.5);
            dos.writeUTF("HOLA");
            dos.close();
	        
            //ESCRIBIR OBJETOS EN SÍ MISMOS. LA CLASE DEL OBJETO TIENE QUE TENER IMPLEMENTADO "SERIALIZABLE" (OBJECT OUTPUT STREAM)
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero_objeto));
            oos.writeObject(new Pertsona("Jon", 30));
            oos.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//============ LEER DATOS ============
        try {
            //LEER DE FICHEROS ESCRITOS CON BYTES CON FILE INPUT STREAM
            FileInputStream fis = new FileInputStream(fichero_byte);
            int byteData = fis.read(); // Lehenengo byte-a irakurtzen du
            System.out.println("FileInputStream: " + (char) byteData);
            fis.close();

            //LEER DATOS PRIMITIVOS CON DATA INPUT STREAM
            DataInputStream dis = new DataInputStream(new FileInputStream(fichero_primitivo));
            int intData = dis.readInt();
            double doubleData = dis.readDouble();
            String utfData = dis.readUTF();
            System.out.println("DataInputStream: Int=" + intData + ", Double=" + doubleData + ", String=" + utfData);
            dis.close();

            //LEER OBJETOS UTILIZANDO OBJECT INPUT STREAM
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero_objeto));
            Pertsona person = (Pertsona) ois.readObject();
            System.out.println("ObjectInputStream: " + person);
            ois.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	//CLASE PERSONA CON "SERIALIZABLE" IMPLEMENTADO
    static class Pertsona implements Serializable {
        private String name;
        private int age;

        public Pertsona(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    //EJEMPLO DE BUCLE UTILIZANDO FILE OUTPUT STREAM, MIENTRAS LA POSICION DEL BYTE SEA MENOR AL TOTAL DE BYTES SE RECORRERA EL FICHERO
//	while (fic.getChannel().position() < fic.getChannel().size()) {
//		// Leer los datos del archivo
//		equipoLocal = dis.readUTF();
//		equipoVisitante = dis.readUTF();
//		golesLocal = dis.readInt();
//		golesVisitante = dis.readInt();
//		lugar = dis.readUTF();
//		fecha = dis.readUTF();
//
//		// Crear el objeto Partido y añadirlo a la lista
//		Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante, lugar, fecha);
//		partidoArray.add(partido);
//	}

}
