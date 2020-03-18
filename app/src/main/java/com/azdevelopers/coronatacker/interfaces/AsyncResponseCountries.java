package com.azdevelopers.coronatacker.interfaces;


import com.azdevelopers.coronatacker.models.CountryData;

import java.util.List;

public interface AsyncResponseCountries {
    void processFinish(List<CountryData> countryData);
}