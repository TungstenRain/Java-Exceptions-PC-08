package ch11pc08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Frank
 */
public class Ch11pc08 {

    public static void main(String[] args) {
        // variables
        String encryptName, decryptName;
        boolean fileFound = true;
        
        //instantiate Scanner class keyboard
        Scanner keyboard = new Scanner(System.in);
        
        do {
            try {
                //Request file from user
                System.out.print("Please enter the name of the encrypted file to decrypt: ");
                encryptName = keyboard.nextLine();
                System.out.print("Please enter the name of the file to decrypt to: ");
                decryptName = keyboard.nextLine();
                
                FileDecryptionFilter.decryptFile(encryptName, decryptName);
                
                System.out.println("File successfully decrypted.");
            }
            catch (FileNotFoundException ex) {
                System.out.println("Could not find file.");
                System.out.println(ex.getMessage());
                fileFound = false;
            }
            catch (IOException ex) {
                System.out.println("Error.  File was not decrypted.");
                System.out.println(ex.getMessage());
                fileFound = true;
            }
        } while (!fileFound);
    }
    
}