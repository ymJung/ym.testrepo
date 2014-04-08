package com.tistory.metalbird0.ymStudy;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.tistory.metalbird0.ymStudy.util.Base64;


public class BlockVerifier {

    public boolean makeHash(byte[] blob) {
        if (blob == null) {
            return false;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(blob, 0, blob.length);
            byte[] digest = md.digest();
            String hash = Base64.encodeBytes(digest, Base64.URL_SAFE);
            String blockHash = hash.substring(0, hash.length() - 1);
            System.out.println("SHA-256 Hash is : " + blockHash + " Size : " + blob.length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String hash1 = "v8lDw2oedBjbUnahw0fGK0UcXuXktfraNnB4BxzgV7g";
        String hash2= "rwPE-tpzKdeU_yb00ZwVZLAkZVAKQr7xept-vj70dPM";
        HttpRestFul rest = new HttpRestFul();
        rest.blockDownloadTest(hash1, hash2);

        InputStream is = null;
        try {
            BlockVerifier verifier = new BlockVerifier();
            Path path = Paths.get(HttpRestFul.DEFAULT_PATH + hash1);
            byte[] buff = new byte[1766858];
            is = Files.newInputStream(path);
            is.read(buff);
            verifier.makeHash(buff);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
