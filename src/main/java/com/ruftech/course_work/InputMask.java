package com.ruftech.course_work;

import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMask {

    private static final String DATE_TIME_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    public static boolean isValidDate(String dateTimeString) {
        Pattern pattern = Pattern.compile(DATE_TIME_REGEX);
        Matcher matcher = pattern.matcher(dateTimeString);
        return matcher.matches();
    }

    public static boolean isValidTimestmap(String timestamp) {
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(.\\d)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(timestamp);
        return matcher.matches();
    }
    public static boolean isValidReady(String ready) {
        String regex = "^[0-1]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ready);
        return matcher.matches();
    }
    private static final String ICAO_REGEX = "^[A-Z0-9]{0,4}$";

    public static boolean isValidICAO(String icaoCode) {
        Pattern pattern = Pattern.compile(ICAO_REGEX);
        Matcher matcher = pattern.matcher(icaoCode);
        return ((Matcher) matcher).matches();
    }

    private static final String NAME_REGEX = "^[A-Za-z-'`]+$";

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }


    public static boolean isValidDouble(String doubleNumber) {
        String regexForDouble = "^-?\\d+(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regexForDouble);
        Matcher matcher = pattern.matcher(doubleNumber);
        return matcher.matches();
    }


    public static boolean isValidInt(String intNumber) {
        // Регулярное выражение для int (только целые числа)
        String regexForInt = "^[-+]?\\d+$";
        Pattern pattern = Pattern.compile(regexForInt);
        Matcher matcher = pattern.matcher(intNumber);
        return matcher.matches();
    }

    public static boolean isValidRouteNumber(String routeNumber) {
        String regex = "^[A-Z0-9]{0,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(routeNumber);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        String regex = "^7[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidAddress(String address) {
        String regex = "^(\\p{L}+),\\s*(\\p{L}+),\\s*(\\d+),\\s*(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
    public static boolean isValidRoute(String routeNumber, String departure, String arrival, String price, String duration) {
        return InputMask.isValidRouteNumber(routeNumber) && InputMask.isValidICAO(departure) && InputMask.isValidICAO(arrival) && InputMask.isValidDouble(price) &&
                InputMask.isValidInt(duration);
    }

    public static boolean isValidCommander(String personalNumber, String lastname, String firstname, String address, String phone, String flyingHours) {
        return isValidInt(personalNumber) && isValidName(lastname) && isValidName(firstname) && isValidPhone(phone) && isValidDouble(flyingHours);
    }

    public static boolean isValidPassenger(String passport, String lastname, String firstname, String address, String phone) {
        return isValidName(lastname) && isValidName(firstname) && isValidPhone(phone);
    }
    public static boolean isValidAircraft(String tailNumber, String model, String manufactureDate, String lifetime, String isReady, String commanderNumber) {
        return isValidDate(manufactureDate) && isValidInt(lifetime) && isValidReady(isReady) && isValidInt(commanderNumber);
    }
    public static boolean isValidFlight(String number, String departureTime, String isCanceled, String routeNumber, String aircraftTailNumber) {
//        System.out.println(departureTime + " " + isCanceled);
        return isValidTimestmap(departureTime) && isValidReady(isCanceled);
    }
    public static boolean isValidYear(String year) {
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(year);
        return matcher.matches();
    }
}
//  && isValidAddress(address)