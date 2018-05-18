package JavaClass;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.security.SecureRandom;

import java.util.regex.Pattern;

public class TestOne {
    public static void main(String[] argv) {
        TestOne testOne = new TestOne();
        String input = "9FF848BC26CF39938CDA5F2DD0B82FB7BDAEF962FB15DEDF0E0E9F56C4BFA7BE1ACCA8046EDBCA10CF5968A62EFF6424C86620DE2B8B85BE994D2927C36082D5122158B37EDF8825C6D6EAE823FE4CC2D01F5B68439604F2F5E59B2E2205CB354CC313549159061EE54744AF795DDA9A542198DC278467FF8E612D3D9AA6EEF287806DE98DDDC66ADE2F2F08D5F2CF0E161C0E7665D0CA79C8F3D771C9DDE81F35A6F22FFB92422BA5FF9304370F5AC65EA6DD7B9F04BB7233328AC2C924523A74D89BDA320625F263C1DF2D7B3A5A5C";
        byte[] b = input.getBytes();


            String netId = "yx1209";
            String expectedText = testOne.decrypt(netId, b);
            String[] expected = expectedText.split(Pattern.quote("\n"));

            System.out.printf(expected[4]);



    }

    private byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(128, sr);
        javax.crypto.SecretKey skey = kgen.generateKey();
        return skey.getEncoded();
    }

    private String decrypt(String seed, byte[] encodedBytes) {
        try {
            byte[] rawKey = getRawKey(seed.getBytes());
            String encoded = new String(encodedBytes, StandardCharsets.UTF_8);
            byte[] encrypted = toByte(encoded);
            SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, skeySpec);
            return new String(cipher.doFinal(encrypted), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    private byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }

    private String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (byte datum : buf) {
            appendHex(result, datum);
        }
        return result.toString();
    }


    private void appendHex(StringBuffer sb, byte b)
    {
        sb.append("0123456789ABCDEF".charAt(b >> 4 & 0xF)).append("0123456789ABCDEF".charAt(b & 0xF));
    }
}
