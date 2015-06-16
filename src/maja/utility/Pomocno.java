/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author Maja
 */
public class Pomocno {
    
       public static String generirajMD5(char[] ulaz){
         //zadatak je uneseni niz znakova lozinke
        //prebaciti u md5
        String lozinkaString=new String(ulaz);
     String hashtext="";
 try { 
MessageDigest m = MessageDigest.getInstance("MD5");
m.reset();
m.update(lozinkaString.getBytes());
byte[] digest = m.digest();
BigInteger bigInt = new BigInteger(1,digest);
hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
while(hashtext.length() < 32 ){
  hashtext = "0"+hashtext;
}
 } catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
 }
        
 
 //sada hashtext ima md5 vrijedno unesene lozinka
    return hashtext;
    }
       
       public static String generirajLozinku(){
           
           StringBuilder sb= new StringBuilder();
           int n=8;
           String set = "1234567890'+qwertzuiopasdfghjklyxcvbnm,.-";
           Random r= new Random();
           int i;
           for (i=0; i<n; i++){
               int k= r.nextInt(set.length()-1);
               sb.append(set.charAt(i));
           }
           return sb.toString();
       }
    
    
}
