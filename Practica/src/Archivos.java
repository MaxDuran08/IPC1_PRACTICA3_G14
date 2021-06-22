import java.io.*;

public class Archivos {
    public String leerArchivo(String direccion) {
        String lectorTexto = "";
        FileReader FR;
        BufferedReader buffR;
        try {
            FR = new FileReader(direccion);
            buffR = new BufferedReader(FR);
            StringBuilder textoTemporal = new StringBuilder();
            String buffReader;
            while ((buffReader = buffR.readLine()) != null) {

                textoTemporal.append(buffReader).append("#&");
            }
            lectorTexto = textoTemporal.toString();
            FR.close();
            buffR.close();

        } catch (IOException e) {
            System.err.println("No se encontro la ruta del Archivo.");

        }

        return lectorTexto;
    }
}
