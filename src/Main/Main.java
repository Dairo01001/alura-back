package Main;

import java.util.Scanner;
import models.Exchange;
import models.ExchangeRate;
import models.FetchCurrencyExeption;
import models.Json;
import models.Services;
import models.Utils;

public class Main {

    public static void main(String[] args) {
        Json json = Json.getInstance();
        try {
            ExchangeRate exchangeRate = json.ExchangeRateFromJson(Services.getExchangeRate("USD"));
            Exchange exchange = new Exchange(exchangeRate);

            try (Scanner sc = new Scanner(System.in)) {
                while (true) {
                    Utils.PaintMenu(exchange.getConversionRates());
                    String op = sc.nextLine();
                    
                    if (op.equalsIgnoreCase("salir")) {
                        break;
                    }
                    
                    System.out.print("From: ");
                    String from = sc.nextLine();
                    System.out.print("To: ");
                    String to = sc.nextLine();
                    System.out.print("Value: ");
                    String value = sc.nextLine();
                    
                    System.out.format("Value: %s --> from [%s] to [%s] = %s\n", value, from, to, exchange.conversion(from, to, Double.valueOf(value))); 
                    System.out.println();
                }
            }
        } catch (FetchCurrencyExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
