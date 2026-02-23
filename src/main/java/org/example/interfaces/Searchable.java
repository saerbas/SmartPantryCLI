package org.example.interfaces;

import org.example.product.Product;

import java.util.List;

public interface Searchable {
    // create abstract method
    List<Product> search(String query);

    // default method
    default void printHelp(){
        System.out.println("For search a product please enter the Name...");
    }
}
