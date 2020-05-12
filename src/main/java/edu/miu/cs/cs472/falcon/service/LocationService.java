package edu.miu.cs.cs472.falcon.service;

import edu.miu.cs.cs472.falcon.repository.LocationRepo;
import edu.miu.cs.cs472.falcon.utils.FactoryMethod;

import java.util.List;

public class LocationService {
    private static LocationRepo locationRepo = new LocationRepo();

    public static List<String> getCities(String search) {
        return locationRepo.getCities(search);
    }

    public static String getShortState(String state) {
        if (state == null)
            return "";

        String st = locationRepo.getShortState(state);

        return st == null ? FactoryMethod.capitalizeFirstLetter(state) : st;
    }
}
