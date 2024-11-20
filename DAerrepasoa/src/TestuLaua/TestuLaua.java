package TestuLaua;

import java.io.*;

public class TestuLaua {
    public static void main(String[] args) {
        String fitxategiIzena = "src\\TestuLaua\\testu_laua.txt";

        try {
            // **1. FileWriter erabiliz idaztea**
            System.out.println("=== FileWriter erabiliz idazten ===");
            FileWriter fileWriter = new FileWriter(fitxategiIzena);
            fileWriter.write("Hau FileWriter erabiliz idatzitako adibidea da.\n");
            fileWriter.write("Idazketa bakoitza zuzenean fitxategira doa.\n");
            fileWriter.close();

            // **2. BufferedWriter erabiliz idaztea**
            System.out.println("\n=== BufferedWriter erabiliz idazten ===");
            FileWriter fwForBuffered = new FileWriter(fitxategiIzena, true); // 'append' modua
            BufferedWriter bufferedWriter = new BufferedWriter(fwForBuffered);
            bufferedWriter.write("Hau BufferedWriter erabiliz idatzitako adibidea da.\n");
            bufferedWriter.write("Eraginkortasuna hobetzeko bufer bat erabiltzen du.\n");
            bufferedWriter.close();

            // **3. FileReader erabiliz irakurtzea**
            System.out.println("\n=== FileReader erabiliz irakurtzen ===");
            FileReader fileReader = new FileReader(fitxategiIzena);
            int karakterea;
            while ((karakterea = fileReader.read()) != -1) {
                System.out.print((char) karakterea); // Karakterez karaktere irakurtzen du
            }
            fileReader.close();

            // **4. BufferedReader erabiliz irakurtzea**
            System.out.println("\n=== BufferedReader erabiliz irakurtzen ===");
            FileReader frForBuffered = new FileReader(fitxategiIzena);
            BufferedReader bufferedReader = new BufferedReader(frForBuffered);
            String lerroa;
            while ((lerroa = bufferedReader.readLine()) != null) {
                System.out.println(lerroa); // Lerroz lerro irakurtzen du
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Errorea gertatu da: " + e.getMessage());
        }
    }
}
