/**
 * Class for hashing MD5
 *
 * @WolfDroid
 * @version 28/02/2020
 */

//External Library for Hashing
import java.math.BigInteger;                    //Math Library for Converting into BigInteger
import java.security.MessageDigest;             //Security Library for Message Digest Hashing
import java.security.NoSuchAlgorithmException;  //Security Library for Exception Input

//Hashing Class
public class md5Hashing{
    //Accessor Class
    public static String md5Input(String input) {
        // Looping and testing the input for the Hashing
        try{
            // Instance of the object from Message Digest 
            MessageDigest MD = MessageDigest.getInstance("MD5");
            
            // Calulate the message digest using digest() from input and returning in array bytes.
            byte[] messageDigest = MD.digest(input.getBytes()); 
            
            // Converting array of bytes into Big Integer or Signum Representation
            BigInteger num = new BigInteger(1, messageDigest); 
            
            // Converting the message digest into hex
            String hashing = num.toString(16); 
            while (hashing.length() < 32) { 
                hashing = "0" + hashing; 
            } 
            
            //Returning the value of the message digest in hex
            return hashing; 
        }
        // Catching the errors from the message the input
        catch (NoSuchAlgorithmException e){
            // Throwing the error
            throw new RuntimeException(e); 
        }
    }
    
    // Main class 
    public static void main(String args[]) throws NoSuchAlgorithmException { 
        String input1 = "SecureCommunication"; 
        System.out.println("Your HashCode Generated by MD5 is: " + md5Input(input1));
        String input2 = "Computer_Security"; 
        System.out.println("Your HashCode Generated by MD5 is: " + md5Input(input2)); 
    } 
}
