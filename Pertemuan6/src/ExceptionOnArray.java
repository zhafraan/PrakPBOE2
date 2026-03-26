/*  File        : ExceptionOnArray.java 
    Deskripsi   : program penggunaan exception menggunakan class library Java*/

public class ExceptionOnArray {
    public static void main(String[] args) {
        Integer[] arrayInteger = new Integer[4];
        try {
            arrayInteger[2] = 5;
            arrayInteger[4] = 10; // Ini akan menyebabkan ArrayIndexOutOfBoundsException
        } 
        catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        } 
        finally {
            System.out.println("Clean up code.. ");
        }
    }    
}