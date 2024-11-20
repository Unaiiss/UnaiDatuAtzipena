package Bitarra;

import java.io.*;

public class Bitarra {
    public static void main(String[] args) {
        String file_byte = "src\\Bitarra\\bitarra_byte.dat";
        String file_datu_primitibo = "src\\\\Bitarra\\\\bitarra_datu_primitibo.dat";
        String file_objektu = "src\\\\Bitarra\\\\bitarra_objektu.dat";

        // Fitxategian datuak idaztea
        try {
            // 1. FileOutputStream: Byte gordinen idazketa
            FileOutputStream fos = new FileOutputStream(file_byte);
            fos.write(65); // 'A' karakterearen byte-a idazten du
            fos.close();

            // 2. DataOutputStream: Datu primitiboen idazketa
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file_datu_primitibo));
            dos.writeInt(123); // Zenbaki oso bat idazten du
            dos.writeDouble(45.67); // Zenbaki hamartar bat idazten du
            dos.writeUTF("Kaixo mundua!"); // Kate bat idazten du
            dos.close();

            // 3. ObjectOutputStream: Objektu serializagarriak idaztea
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_objektu));
            oos.writeObject(new Pertsona("Jon", 30)); // Objektu bat idazten du
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fitxategian datuak irakurtzea
        try {
            // 1. FileInputStream: Byte gordinen irakurketa
            FileInputStream fis = new FileInputStream(file_byte);
            int byteData = fis.read(); // Lehenengo byte-a irakurtzen du
            System.out.println("FileInputStream: " + (char) byteData);
            fis.close();

            // 2. DataInputStream: Datu primitiboen irakurketa
            DataInputStream dis = new DataInputStream(new FileInputStream(file_datu_primitibo));
            int intData = dis.readInt();
            double doubleData = dis.readDouble();
            String utfData = dis.readUTF();
            System.out.println("DataInputStream: Int=" + intData + ", Double=" + doubleData + ", String=" + utfData);
            dis.close();

            // 3. ObjectInputStream: Objektu serializagarriak irakurtzea
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_objektu));
            Pertsona person = (Pertsona) ois.readObject();
            System.out.println("ObjectInputStream: " + person);
            ois.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Adibideko klasea, serializagarria
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
}
