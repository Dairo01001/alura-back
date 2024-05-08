package models;

import java.util.Map;

public record ExchangeRate(String baseCode, Map<String, Double> conversionRates) {

}
