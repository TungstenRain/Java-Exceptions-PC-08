package ch11pc08;
import java.io.*;

/**
 *
 * @author Frank
 */
public class FileDecryptionFilter {
    
    /**
     * 
     * This decrypts an encrypted file
     * 
     * @param encryptedFile the file that was encrypted
     * @param decryptedFile the file that will be decrypted
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void decryptFile (String encryptedFile, String decryptedFile) throws FileNotFoundException, IOException {
        //instantiate File class
        File inputFile = new File(encryptedFile);
        File outputFile = new File(decryptedFile);
        
        //instantiate FileInputStream class and DataInputStream class
        FileInputStream fstream = new FileInputStream(inputFile);
        DataInputStream inputFileStream = new DataInputStream(fstream);
        
        //instantiate FileOutputStream and DataOutputStream classes
        FileOutputStream fileStream = new FileOutputStream(outputFile);
        DataOutputStream outputFileStream = new DataOutputStream(fileStream);
        
        //begin encryption of existing file
        byte[] b = new byte[inputFileStream.available()];
        
        inputFileStream.read(b);
        
        inputFileStream.close();
        
        //encrypt
        for (int i = 0; i < b.length; i++) {
            outputFileStream.write(b[i] - 1);
        }
        
        outputFileStream.close();
    }
}