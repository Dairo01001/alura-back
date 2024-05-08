package models;

public class FetchCurrencyExeption extends RuntimeException {
  
  private String msg;

  public FetchCurrencyExeption(String msg) {
    this.msg = msg;
  }

  @Override
  public String getMessage() {
    return this.msg;
  }
}
