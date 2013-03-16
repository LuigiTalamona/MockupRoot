package org.talamona.mockup;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Hello world!
 *
 */
public class Cripter {

    private final String keySpecSeed = "glamdring";
    private DESKeySpec keySpec;
    private SecretKey secretKey;
    private BASE64Encoder base64encoder;
    private BASE64Decoder base64decoder;

    public Cripter() {
        try {
            keySpec = new DESKeySpec(keySpecSeed.getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            secretKey = keyFactory.generateSecret(keySpec);
            base64encoder = new BASE64Encoder();
            base64decoder = new BASE64Decoder();
        } catch (Exception ex) {
        }
    }

    public String encriptString(String plain) {
        String retValue = null;
        if (plain != null) {
            try {
                byte[] cleartext = plain.getBytes("UTF8");

                Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
                cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
                retValue = base64encoder.encode(cipher.doFinal(cleartext));

            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return retValue;
    }

    public String decriptString(String cripted) {
        String retValue = null;
        if (cripted != null) {
            try {
                byte[] encryptedPwdBytes = base64decoder.decodeBuffer(cripted);
                Cipher cipher = Cipher.getInstance("DES"); 
                cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
                byte[] plainTextPwdBytes = (cipher.doFinal(encryptedPwdBytes));

                retValue = new String(plainTextPwdBytes, "UTF8");

            } catch (IOException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Cripter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return retValue;
    }

}
