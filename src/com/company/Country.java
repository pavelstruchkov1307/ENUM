package com.company;

public enum Country {

    Russia("Россия", true),
    USA("США", true),
    Germany("Германия", true),
    Canada("Канада", true);
    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public String getRuName() {
        return ruName;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public static Country getByRuName(final String input) throws NoSuchCountryException {
        Country[] countries = Country.values();
        for (Country country : countries) {
            if (country.getRuName().equals(input) && country.getIsOpen()) {
                return country;
            }
        }
        throw new NoSuchCountryException(input);
    }

    @Override
    public String toString() {
        return name() + " (" + ruName + ")";
    }
}

class NoSuchCountryException extends Exception {
    NoSuchCountryException(final String input) {
        System.out.println("Страны '" + input + "' не существует.");
    }
}

