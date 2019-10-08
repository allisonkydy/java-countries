package com.lambda.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CountrySearchApplication
{
  static CountryList countryData;

  public static void main(String[] args)
  {
    countryData = new CountryList();
    SpringApplication.run(CountrySearchApplication.class, args);
  }

}
