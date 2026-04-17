package main.application.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class HashUtil {
    public static String calcularHash(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[1024];
            int numBytes;

            while ((numBytes = fis.read(bytes)) != -1) {
                digest.update(bytes, 0, numBytes);
            }

            StringBuilder sb = new StringBuilder();
            for (byte b : digest.digest()) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            Logger.log("Erro ao calcular hash: " + e.getMessage());
            return "";
        }
    }
}

