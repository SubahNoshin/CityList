package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }
    @Test
    public void testdelete()
    {
        CityList cityList=new CityList();
        City city=new City("jesoore","khulna");
        City city1=new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testDeleteException()
    {
        CityList cityList=new CityList();
        City city=new City("jessore","khulna");
        City city1=new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2,cityList.count());
        cityList.delete(city);
        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);//city dile exception throw korbe,city1 dile exception throw korbe na mane run korbe na,failed
        });

    }
    @Test
    public void counttest()//ekhane count city test korsi,koyta city ase ta dekhabe
    {
        CityList cityList=new CityList();
        City city=new City("jessore","khulna");
        City city1=new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2,cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));


    }
    @Test
    public void testsort() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);


        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
        assertEquals(0,mockCity().compareTo(cityList.getCities(2).get(0)));//province name onujayi mock age thkbbe
        assertEquals(0,city.compareTo(cityList.getCities(2).get(1)));

    }

}

