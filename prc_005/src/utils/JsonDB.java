package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonDB {

	public static List<List<String>> cargarDatos() {
        List<List<String>> datos = new ArrayList<>();
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/database/BaseDeDatos.json")));
            JSONObject baseDeDatosJson = new JSONObject(jsonData);

            JSONArray gradosJson = baseDeDatosJson.getJSONArray("grados");
            for (int i = 0; i < gradosJson.length(); i++) {
                JSONObject gradoJson = gradosJson.getJSONObject(i);
                String nombreGrado = gradoJson.getString("nombre");
                List<String> grado = new ArrayList<>();
                grado.add("Grado: " + nombreGrado);

                JSONArray juegosJson = gradoJson.getJSONArray("juegos");
                for (int j = 0; j < juegosJson.length(); j++) {
                    JSONObject juegoJson = juegosJson.getJSONObject(j);
                    String tituloJuego = juegoJson.getString("titulo");
                    String imagen = juegoJson.getString("imagen");
                    String ruta = juegoJson.getString("ruta");
                    String descripcionJuego = juegoJson.getString("descripcion");
                    grado.add(tituloJuego);
                    grado.add(imagen);
                    grado.add(ruta);
                    grado.add(descripcionJuego);
                }
                datos.add(grado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }
}
