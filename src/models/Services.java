package models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Services {
  private static final String URL = "https://v6.exchangerate-api.com/v6/ba4cc68a690ac7f21b81f04f/latest/";


  static public String getExchangeRate(String currencyCode) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      URI url = new URI(URL + currencyCode);
      HttpRequest request = HttpRequest.newBuilder().uri(url).build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
      return response.body();
    } catch (URISyntaxException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }

    throw new FetchCurrencyExeption("Error al intentar obtener los datos");
  }
}
