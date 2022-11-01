class VigenereCipher{
   static String generateKey(String str, String key)
   {
       int x = str.length();
       for (int i = 0; ; i++)
       {
           if (x == i)
               i = 0;
           if (key.length() == str.length())
               break;
           key+=(key.charAt(i));
       }
       return key;
   }
   static String Encrypt(String str, String key)
   {
       String cipher_text="";
       for (int i = 0; i < str.length(); i++)
       {
           int x = (str.charAt(i) + key.charAt(i)) %26;
           x += 'A';
           cipher_text+=(char)(x);
       }
       return cipher_text;
   }
   static String Decrypt(String cipher_text, String key)
   {
       String orig_text="";
       for (int i = 0 ; i < cipher_text.length() &&
               i < key.length(); i++)
       {
           int x = (cipher_text.charAt(i) -
                   key.charAt(i) + 26) %26;
           x += 'A';
           orig_text+=(char)(x);
       }
       return orig_text;
   }
   public static void main(String[] args)
   {
       String PlainText = "kaushik";
       String Keyword = "joshi";
       String key = generateKey(PlainText.toUpperCase(), Keyword.toUpperCase());
       String cipher_text = Encrypt(PlainText.toUpperCase(), key);
       System.out.println("Plaintext : " + PlainText);
       System.out.println("Ciphertext : " + cipher_text);
       System.out.println("Original/Decrypted Text : " + Decrypt(cipher_text, key));
   }
}
