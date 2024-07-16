import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    //MÉTODOS ****************************************************************************
    public String consultar (int inputUsuario) throws IOException, InterruptedException {
        String moneda = null;

        if (inputUsuario == 1) {
            moneda = "USD";
        } else if (inputUsuario == 2) {
            moneda = "ARS";
        } else if (inputUsuario == 3) {
            moneda = "USD";
        } else if (inputUsuario == 4) {
            moneda = "BRL";
        } else if (inputUsuario == 5) {
            moneda = "USD";
        } else if (inputUsuario == 6) {
            moneda = "COP";
        } else {
            moneda = null;
        }

        String direccion = "https://v6.exchangerate-api.com/v6/0b7a7c6bdb2f6c83d66c4aea/latest/" + moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
