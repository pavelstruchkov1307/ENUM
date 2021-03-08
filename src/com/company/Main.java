package com.company;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        String input;
        Country ruCountry;
        Country[] countries = Country.values();
        for (Country country : countries) {
            System.out.println(country);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название страны: ");
        input = scan.nextLine();
        try {
            System.out.println("Страна [" + Country.valueOf(input) + "] открыта для посещения.");
            return;
        } catch (NullPointerException e) {
            System.out.println("Неверное использование пустой ссылки");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
        }
        try {
            ruCountry = Country.getByRuName(input);
        } catch (NoSuchCountryException e) {
            System.out.println();
            return;
        }
        System.out.println("Страна [" + ruCountry + "] открыта для посещения.");
    }


}

