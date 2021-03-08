package com.company;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        String input;

        Country[] countries = Country.values();
        for (Country country : countries) {
            System.out.println(country);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название страны: ");
        input = scan.nextLine();
        try {
            Country currCountry = Country.valueOf(input);
            if (currCountry.getIsOpen()) {
                System.out.println("Страна [" + currCountry + "] открыта для посещения.");
            } else {
                System.out.println("Страна [" + currCountry + "] закрыта для посещения.");
            }
            return;
        } catch (NullPointerException e) {
            System.out.println("Неверное использование пустой ссылки");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }
        try {
            Country ruCountry = Country.getByRuName(input);
            if (ruCountry.getIsOpen()) {
                System.out.println("Страна [" + ruCountry + "] открыта для посещения.");
            } else {
                System.out.println("Страна [" + ruCountry + "] закрыта для посещения.");
            }

        } catch (NoSuchCountryException e) {
            System.out.println("Страны '" + e.getMessage() + "' не существует.");
        }

    }


}

