package books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti libri vuoi inserire?");
        int numLibri = Integer.parseInt(scanner.nextLine());
        Book[] books = new Book[numLibri];
        int i = 0;
        while (i < books.length){
            try {
                System.out.println("Inserisci il titolo del libro:");
                String title = scanner.nextLine().trim();
//                Controllo il titolo
                if (title.isEmpty()){
                    throw new Exception("Non puoi mettere un titolo vuoto");
                }
                System.out.println("Inserisci numero di pagine");
                int pageNumber = Integer.parseInt(scanner.nextLine().trim());
//                Controllo che il numero sia positivo
                if(pageNumber <=0 ){
                    throw new Exception("Il numero di pagine non può essere 0 o negativo");
                }
                System.out.println("Inserisci l'autore");
//                Controllo l'autore
                String author = scanner.nextLine().trim();
                if (author.isEmpty()){
                    throw new Exception("Non puoi mettere un autore vuoto");
                }
                System.out.println("Inserisci l'editore");
//                Controllo l'editore
                String editor = scanner.nextLine().trim();
                if (editor.isEmpty()){
                    throw new Exception("Non puoi mettere un editore vuoto");
                }
                books[i] = new Book(title, pageNumber, author, editor);
            }catch(NumberFormatException e){
//                Recupero l'errore del parseInt
                System.out.println("Devi inserire un numero senza virgola");
            }catch (SecurityException e){
//                Recupero possibili errori nel modello
                System.out.println(e.getMessage());
            }catch (Exception e){
//                Recupero possibili errori nel main
                System.out.println(e.getMessage());
            }finally {
                i++;
            }
        }
        scanner.close();
//        Scrivo il nel file
        try {
            FileWriter myData = new FileWriter("./resources/data.txt");
            for (Book book : books) {
                myData.write(book.toString()+"\n");
            }
            myData.close();
        } catch (IOException e) {
            System.out.println("Errore nella scrittura");
        }
//        Leggo il file
        System.out.println("************ LEGGO IL FILE *************** \n");
        File libri = new File("./resources/data.txt");
        Scanner reader = null;
        try {
            reader = new Scanner(libri);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Non trovo il file");
        }
        reader.close();
    }
}
