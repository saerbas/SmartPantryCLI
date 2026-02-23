package org.example;

import org.example.product.Product;
import org.example.product.ProductCategory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter a product");
        var myProduct = inputScanner.nextLine();

        List<Product> products = List.of(
                new Product("Milch", 1.20, ProductCategory.GROCERIES.getDisplayName()),
                new Product("Brot", 2.50, ProductCategory.GROCERIES.getDisplayName()),
                new Product("Spülmittel", 3.99, ProductCategory.HOUSEHOLD.getDisplayName()),
                new Product("Apfel", 0.50, ProductCategory.HOUSEHOLD.getDisplayName()),
                new Product("AA-Batterien", 5.99, ProductCategory.GROCERIES.getDisplayName())
        );


        // Show all products which costs less then 2
        List<String> foodByPrice = products.stream()
                .filter(p -> p.price() > 2.00)
                .map(p -> p.name().toUpperCase())
                .sorted()
                .toList();

        // same as foreach(f -> System.out.println(f))
        foodByPrice.forEach(System.out::println);

        // search fo specific product
        var searchResult = products.stream()
                .filter(p -> p.name().equals(myProduct)).findFirst(); // findFirst() returns a optional

        // option a: check if searchResult is present
        if (searchResult.isPresent()) {
            System.out.println(myProduct + "is present");
        }

        // search if not exist
        var missingResult = products.stream()
                .filter(p -> p.name().equals(myProduct)).findFirst();

        missingResult.ifPresentOrElse(
                p -> System.out.println("Product gefunden" + p),
                () -> System.out.print("Product nicht gefunden")
        );

        try{
            List<String> loadedList = loadShoppingList();
            System.out.println("Loaded list: " + loadedList);
        }catch (IOException e){
            System.out.println("Error on loading the filed " + e.getMessage());
        }


    }

    public static List<String> loadShoppingList() throws IOException {
        return readAllLines(Path.of("einkaufsliste.txt"));
    }
}
