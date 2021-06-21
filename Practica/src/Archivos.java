import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivos {
    public String leerArchivo(String direccion) {
        String lectorTexto = "";
        FileReader FR;
        BufferedReader buffR;
        try {
            FR = new FileReader(direccion);
            buffR = new BufferedReader(FR);
            String textoTemporal = "";
            String buffReader;
            while ((buffReader = buffR.readLine()) != null) {

                textoTemporal = textoTemporal + buffReader + "#&";
            }
            lectorTexto = textoTemporal;
            FR.close();
            buffR.close();

        } catch (IOException e) {
            System.err.println("No se encontro la ruta del Archivo.");

        }

        return lectorTexto;
    }
}
