package Prototype;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recommendation fantasyReaders = new Recommendation("Fantasy Readers");
        fantasyReaders.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 1997));
        fantasyReaders.addBook(new Book("Percy Jackson", "The Titan's Curse", "Fantasy", 2007));

        Recommendation romanceReaders = new Recommendation("Romance Readers");
        romanceReaders.addBook(new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813));
        romanceReaders.addBook(new Book("The Notebook", "Nicholas Sparks", "Romance", 1996));

        Recommendation clonedRecommendation = null;

        while (true) {
            System.out.println("\n- Book Recommendation System\n");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone Recommendation");
            System.out.println("3. Modify Recommendations");
            System.out.println("4. Save Recommendations");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n- Recommendations\n");
                    System.out.println(fantasyReaders);
                    System.out.println(romanceReaders);
                    if (clonedRecommendation != null) {
                        System.out.println(clonedRecommendation);
                    }
                    break;

                case 2:
                    System.out.println("\n- Choose a recommendation to clone:\n");
                    System.out.println("1. Fantasy Readers");
                    System.out.println("2. Romance Readers");
                    System.out.print("\nChoose: ");
                    int cloneChoice = scanner.nextInt();
                    scanner.nextLine();
                    clonedRecommendation = (cloneChoice == 1) ? fantasyReaders.clone() : romanceReaders.clone();
                    System.out.println("\nCloned recommendation for " + clonedRecommendation.getTargetAudience());
                    break;

                case 3:
                    if (clonedRecommendation == null) {
                        System.out.println("\nNo cloned recommendations available.");
                        break;
                    }
                    System.out.println("\n--- Modify Cloned Recommendations ---");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. Change Target Audience");
                    System.out.print("\nChoose: ");
                    int modifyChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (modifyChoice == 1) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        clonedRecommendation.getBooks().clear();
                        clonedRecommendation.addBook(new Book(title, author, genre, year));
                        System.out.println("\nBook added.");
                    } else if (modifyChoice == 2) {
                        System.out.println("Books in cloned recommendations:");
                        for (int i = 0; i < clonedRecommendation.getBooks().size(); i++) {
                            System.out.println((i + 1) + ". " + clonedRecommendation.getBooks().get(i));
                        }
                        System.out.print("Enter the number of the book to remove: ");
                        int removeIndex = scanner.nextInt();
                        scanner.nextLine();
                        clonedRecommendation.removeBook(clonedRecommendation.getBooks().get(removeIndex - 1));
                        System.out.println("Book removed.");
                    } else if (modifyChoice == 3) {
                        System.out.print("Enter new target audience: ");
                        String newAudience = scanner.nextLine();
                        clonedRecommendation.setTargetAudience(newAudience);
                        System.out.println("Target audience updated.");
                    }
                    break;

                case 4:
                    if (clonedRecommendation == null) {
                        System.out.println("\nNo cloned recommendation available to save.");
                    } else {
                        System.out.println("\nSaved cloned recommendation for " + clonedRecommendation.getTargetAudience());
                    }
                    break;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }
}

