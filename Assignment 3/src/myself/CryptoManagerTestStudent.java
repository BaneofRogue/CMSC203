/*
 * 
 *  Class: CMSC203 CRN 31338
 Program: Assignment #3
 Instructor: Ashique Tanveer
 Summary of Description: This program is designed to test the CryptoManager class and its methods. The methods are isStringInBounds, caesarEncryption, bellasoEncryption, caesarDecryption, and bellasoDecryption. The test cases are designed to test the methods with different inputs and outputs.
 Due Date: 03/21/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller

 */

package myself;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.runtime.ObjectMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * This class is the test file I decided to create because of the rubric: " ▪ Provided CryptoManagerTestStudent with test case for every public method"
 */
public class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	 * This test case is designed to test the isStringInBounds method with different inputs and outputs.
	 */
	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("\"JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ\""));
		assertTrue(CryptoManager.isStringInBounds("--2130-)-0-20430-9--12]-\\2[423\\]23[4\\]5"));
		assertFalse(CryptoManager.isStringInBounds("{JAVAum8&(*&#(@#M(lkjjdfksjhUHjm3kh4,2n1```````````````"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FｓｈｈっはああAIL BECAUSE { IS OへっぉUTSIDE THE RANGE😂😂😂😂\""));
	}

	/*
	 * This test case is designed to test the caesarEncryption method with different inputs and outputs.
	 */
	@Test
	void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("yuh_bye", 3));
		assertEquals("ORORORORO", CryptoManager.caesarEncryption("LOLOLOLOL", 3));
		assertEquals("8NJ9L:B<KJ", CryptoManager.caesarEncryption("AWSBUCKETS", 122231));
		assertEquals("&2*1,72B86(5322/", CryptoManager.caesarEncryption("COGNITO_USERPOOL", -213213));
		assertEquals("$Y%Z\\Y7('$![1!]+7($]Y+", CryptoManager.caesarEncryption("LAMBDA_POLICYIES_PLEAS", 1112));
	}

	/*
	 * This test case is designed to test the bellasoEncryption method with different inputs and outputs.
	 */
	@Test
	void testBellasoEncryption() {
		assertEquals("\\N\"ZW$1[%", CryptoManager.bellasoEncryption("YERRRRRRR", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("N&!I$GMR#!", CryptoManager.bellasoEncryption("AWSBUCKETS", "MONGODB"));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("awsbuckets", "MONGODB"));
	}

	/*
	 * This test case is designed to test the caesarDecryption method with different inputs and outputs.
	 */
	@Test
	void testCaesarDecryption() {
		assertEquals("THIS IS TEST", CryptoManager.caesarDecryption("_ST^+T^+_P^_", 203));
		assertEquals("YERRRRRRR", CryptoManager.caesarDecryption(".Z'''''''", 213333333));
	}

	/*
	 * This test case is designed to test the bellasoDecryption method with different inputs and outputs.
	 */
	@Test
	void testBellasoDecryption() {
		assertEquals("YERRRRRRR", CryptoManager.bellasoDecryption("\\N\"ZW$1[%", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("THIS IS TEST", CryptoManager.bellasoDecryption("F8<EP<EPG7CG", "203"));
	}

}
