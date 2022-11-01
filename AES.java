import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AES {
   private static final String ALGO = "AES";
   public static String encrypt(String Data, String secret) throws Exception {
       Key key = generateKey(secret);
       Cipher c = Cipher.getInstance(ALGO);
       c.init(Cipher.ENCRYPT_MODE, key);
       byte[] encVal = c.doFinal(Data.getBytes());
       String encryptedValue = Base64.getEncoder().encodeToString(encVal);
       return encryptedValue;
   }
   public static String decrypt(String strToDecrypt, String secret) {
       try {
           Key key = generateKey(secret);
           Cipher cipher = Cipher.getInstance(ALGO);
           cipher.init(Cipher.DECRYPT_MODE, key);
           return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
       } catch (Exception e) {
           System.out.println("Error while decrypting: " + e.toString());
       }
       return null;
   }
   private static Key generateKey(String secret) throws Exception {
       byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
       Key key = new SecretKeySpec(decoded, ALGO);
       return key;
   }
   public static String decodeKey(String str) {
       byte[] decoded = Base64.getDecoder().decode(str.getBytes());
       return new String(decoded);
   }
   public static String encodeKey(String str) {
       byte[] encoded = Base64.getEncoder().encode(str.getBytes());
       return new String(encoded);
   }
   public static void main(String a[]) throws Exception {
       String secretKey = "InfoSecurityGCEK";
       String encodedBase64Key = encodeKey(secretKey);
       System.out.println("EncodedBase64Key = " + encodedBase64Key);
       String toEncrypt = "My Name is Kaushik Joshi";
       System.out.println("Plain text = " + toEncrypt);
       String encrStr = AES.encrypt(toEncrypt, encodedBase64Key);
       System.out.println("Cipher Text: Encryption of str = " + encrStr);
       String decrStr = AES.decrypt(encrStr, encodedBase64Key);
       System.out.println("Decryption of str = " + decrStr);
   }
}