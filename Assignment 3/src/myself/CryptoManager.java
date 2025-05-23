package myself;
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
        for (int index = 0; index < plainText.length(); index++) {
            char character = plainText.charAt(index);
            if (character < LOWER_RANGE || character > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {

        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";// the test will fail because doesn't return the expected.
        }

        String encryptedText = "";
        while (key < 0) {
	        key += RANGE; // make sure the key is positive
	    }

	    // If key is larger than the range; manually wrap
	    while (key >= RANGE) {
	        key -= RANGE;
	    }

        for (int letter = 0; letter < plainText.length(); letter++) {
        	
            char encryptedChar = (char) (plainText.charAt(letter) + key);
            
            if (encryptedChar > UPPER_RANGE) {
            	encryptedChar -= RANGE;
            }
            
            encryptedText += encryptedChar;
        }

        return encryptedText;
    }
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
	    if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }

	    String encryptedText = "";
	    int bellasoLength = bellasoStr.length();
	    
	    int keyIndex = 0;
	    

	    for (int letter = 0; letter < plainText.length(); letter++) {
	    	int key = bellasoStr.charAt(keyIndex);
	        char encryptedChar = (char) (plainText.charAt(letter) + key);
	        
	        while (encryptedChar > UPPER_RANGE) {
	            encryptedChar -= RANGE;
	        }
	        while (encryptedChar < LOWER_RANGE) {
	            encryptedChar += RANGE;
	        }

	        encryptedText += encryptedChar;
	        
	        // Increment keyIndex, and if exceed length of bellasoStr, reset to 0.
	        keyIndex++;
	        if (keyIndex >= bellasoStr.length()) {
	            keyIndex = 0;
	        }
	    }

	    return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
	    // Initialize empty string to store decrypted text
	    String decryptedText = "";

	    // make sure key stays within valid range by adjusting manually
	    while (key < 0) {
	        key += RANGE; // make sure the key is positive
	    }

	    // If key is larger than the range; manually wrap
	    while (key >= RANGE) {
	        key -= RANGE;
	    }

	    // Loop through each char in encryptedText
	    for (int index = 0; index < encryptedText.length(); index++) {
	        // Decrypt the character by subtracting the key
	        char character = (char) (encryptedText.charAt(index) - key);

	        // If char is below LOWER_RANGE; wrap around by adding RANGE
	        if (character < LOWER_RANGE) {
	            character += RANGE;
	        }

	        // Append decrypted character to decryptedText string
	        decryptedText += character;
	    }

	    // Return fully decrypted string
	    return decryptedText;
	}

	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	    String decryptedText = "";
	    int keyIndex = 0;
	    
	    int bellasoLength = bellasoStr.length();

	    for (int index = 0; index < encryptedText.length(); index++) {
	    	int key = bellasoStr.charAt(keyIndex);
	    	
	    	char character = (char) (encryptedText.charAt(index) - key);
	        
	        while (character < LOWER_RANGE) {
	            character += RANGE;
	        }
	        while (character > UPPER_RANGE) {
	            character -= RANGE;
	        }

	        decryptedText += character;
	        
	        // Increment keyIndex, and if exceed length of bellasoStr, reset to 0.
	        keyIndex++;
	        if (keyIndex >= bellasoStr.length()) {
	            keyIndex = 0;
	        }
	    }

	    return decryptedText;
	}
}
