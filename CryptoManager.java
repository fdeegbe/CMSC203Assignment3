/*
* Class: CMSC203
* Instructor: Khandan Vahabzadeh Monshi
* Description: Method descriptions are provided above their respective headers
* Due: 10/25/2021
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming assignment
independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Frank Deegbe
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		int count = 0;
		boolean result = true;
		for (int i = 0; i < plainText.length(); i++) {
			if ( plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND) {
				continue;
			}
			else
				count++;
		}
			if (count > 0) 
				result = false;
			
			return result;
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String result = "";
		
		int temp;
		for(int i = 0; i < plainText.length(); i++) {
			temp = ((int) plainText.charAt(i) + key);
			
			while(temp < 32)
				temp += 64;
			while(temp > 95)
				temp-= 64;
			
			result += (char)temp;
		}
		return result;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String key = ""; //Cyber key
		
		int j; //accumulator to get our key
		
		String code = "";
		
		int sum = 0;
		
		for(int i = 0; i< plainText.length(); i++) { // this is to get the correct string to add the values
			j = 0;
			while(key.length() < plainText.length() && j < bellasoStr.length()) {
				key += bellasoStr.charAt(j);
				j++;
			}
		
		}
		
		for (int i = 0; i < plainText.length(); i++) {
			sum = ( (int) plainText.charAt(i) + key.charAt(i) );
			
			while (sum > 95)
				sum -= 64;
			
			code += (char) sum;
			
		}
		
		return code;
		
	}
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		int temp;
		String result = "";
		for(int i = 0; i < encryptedText.length(); i++) {
			temp = ((int) (encryptedText.charAt(i) - key));
			
			
			while(temp < 32)
				temp += 64;
			while(temp > 95)
				temp-= 64;
			
			result += (char)temp;
		}
		return result;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		int j;
		String code = "";
		String key = "";
		int sum = 0;
		for(int i = 0; i< encryptedText.length(); i+=0) { // this is to get the correct string to add the values
			j = 0;
			while(key.length() < encryptedText.length() && j < bellasoStr.length()) {
				
				key += (char)bellasoStr.charAt(j);
				i++;
				j++;
					
			}
			
			
		}
		
		for (int i = 0; i < encryptedText.length(); i++) {
				sum = (int) encryptedText.charAt(i);
				sum -= (int)key.charAt(i);
				
				while(sum < 32)
					sum += 64;
				if(sum > 95)
					sum-= 64;
				
				code += (char)sum;
	}
	
		return code;
}
	
}