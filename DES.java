import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DES{
   public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
       String  message="My Name is Kaushik Joshi";
       byte[] myMessage =message.getBytes();
       KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
       SecretKey myDesKey = Mygenerator.generateKey();
       Cipher myCipher = Cipher.getInstance("DES");
       myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
       byte[] myEncryptedBytes=myCipher.doFinal(myMessage);
       myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
       byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes);
       String encrypteddata=new String(myEncryptedBytes);
       String decrypteddata=new String(myDecryptedBytes);
       System.out.println("Message : "+ message);
       System.out.println("Encrypted - "+ encrypteddata);
       System.out.println("Decrypted Message - "+ decrypteddata);
   }
}
