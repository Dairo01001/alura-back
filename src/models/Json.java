package models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
  private static volatile Json instance;
  private final Gson gson;

  public Json() {
    this.gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .create();
  }

  public static Json getInstance() {
    Json result = instance;
    if(result != null) return result;

    synchronized(Json.class) {
      if(instance == null) {
        instance = new Json();
      }
      return instance;
    }
  }

  public ExchangeRate ExchangeRateFromJson(String jsonElement) {
    return this.gson.fromJson(jsonElement, ExchangeRate.class);
  }
}
