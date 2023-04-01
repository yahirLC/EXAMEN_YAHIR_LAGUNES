package mx.uv.fiee.iinf.poo.primerparcial;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Dictionary<T> implements JSONParser<T> {

    private List<Entry> entries = new ArrayList<>();

    public void parse(T source) {
        if (source instanceof String) {
            System.out.println(source);
            return;
        }

        try {
            // Crear un objeto Gson para analizar el archivo JSON
            Gson gson = new Gson();
            // Crear un objeto FileReader para leer el archivo JSON
            FileReader reader = new FileReader(new File(source.toString()));
            // Convertir el archivo JSON a un objeto JsonElement
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            // Verificar que el objeto es un objeto JSON
            if (json.isJsonObject()) {
                JsonObject jsonObject = json.getAsJsonObject();
                // Recorrer cada propiedad del objeto JSON
                for (String key : jsonObject.keySet()) {
                    // Crear una nueva entrada a partir de la propiedad
                    Entry entry = new Entry();
                    entry.setKey(key);
                    entry.setValue(jsonObject.get(key).getAsString());
                    // Agregar la entrada a la lista de entradas
                    entries.add(entry);
                }
            }
            // Cerrar el objeto FileReader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry[] elements() {
        // Devolver la lista de entradas en forma de arreglo de tipo Entry
        return entries.toArray(new Entry[entries.size()]);
    }

}