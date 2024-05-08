package models;

import java.util.Map;

public class Exchange {
  private String baseCode;
  private Map<String, Double> conversionRate;

  public Exchange(ExchangeRate exchangeRate) {
    this.baseCode = exchangeRate.baseCode();
    this.conversionRate = exchangeRate.conversionRates();
  }

  public String getBaseCode() {
    return this.baseCode;
  }

  public double conversion(String from, String to, double value) {
    return (this.conversionRate.get(to) / this.conversionRate.get(from)) * value; 
  }

    public Map<String, Double> getConversionRates() {
        return conversionRate;
    }
  
  
}
