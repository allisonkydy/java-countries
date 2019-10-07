package com.lambda.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController
{
//  /names/all
//  return the names of all the countries alphabetically
  @GetMapping(value = "/names/all",
              produces = {"application/json"})
  public ResponseEntity<?> getAllCountryNames()
  {
    // sort the country list
    CountrySearchApplication.countryData.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

    return new ResponseEntity<>(CountrySearchApplication.countryData.countryList, HttpStatus.OK);
  }

//  /names/start/{letter}
//  return the countries alphabetically that begin with the given letter
  @GetMapping(value =  "/names/start/{letter}",
              produces = {"application/json"})
  public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
  {
    // find countries that begin with letter from path
    ArrayList<Country> resCountries = CountrySearchApplication.countryData.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));

    // sort the country list
    resCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

    return new ResponseEntity<>(resCountries, HttpStatus.OK);
  }

//  /names/size/{number}
//  return the countries alphabetically that have a name equal to or longer than the given length

//  /population/size/{people}
//  return the countries that have a population equal to or greater than the given population

//  /population/min
//  return the country with the smallest population

//  /population/max
//  return the country with the largest population

//    Stretch Goal
//  /population/median
//  return the country with the median population

//  /age/age/{age}
//  return the countries that have a median age equal to or greater than the given age

//  /age/min
//  return the country with the smallest median age

//  /age/max
//  return the country the the greatest median age

//    Stretch Goal
//  /age/median
//  return the country with the median median age
}
