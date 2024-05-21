package books;

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
                String title = scanner.nextLine();
                if (title.isEmpty()){
                    throw new Exception("Non puoi mettere un titolo vuoto");
                }
                System.out.println("Inserisci numero di pagine");
                int pageNumber = Integer.parseInt(scanner.nextLine());
                if(pageNumber <=0 ){
                    throw new Exception("Il numero di pagine non può essere 0 o negativo");
                }
                System.out.println("Inserisci l'autore");
                String author = scanner.nextLine();
                if (author.isEmpty()){
                    throw new Exception("Non puoi mettere un autore vuoto");
                }
                System.out.println("Inserisci l'editore");
                String editor = scanner.nextLine();
                if (editor.isEmpty()){
                    throw new Exception("Non puoi mettere un editore vuoto");
                }
                books[i] = new Book(title, pageNumber, author, editor);
            }catch(NumberFormatException e){
                System.out.println("Devi inserire un numero senza virgola");
            }catch (SecurityException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                i++;
            }
        }
        scanner.close();
    }
}
