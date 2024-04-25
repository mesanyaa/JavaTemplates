package ru.sejapoe;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Base64;

@Component
public class FileHashingService {

    private final String inputFile;
    private final String outputFile;

    public FileHashingService(FileProperties fileProperties) {
        this.inputFile = fileProperties.inputFile();
        this.outputFile = fileProperties.outputFile();
    }

    @SneakyThrows
    public void hashFile() {
        File inputFileObj = new File(inputFile);
        if (!inputFileObj.exists()) {
            createEmptyOutputFile();
            return;
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(inputFileObj);
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesRead);
        }
        fis.close();

        byte[] hashBytes = digest.digest();
        writeHashToFile(hashBytes);
    }

    public void deleteInputFile() {
        File inputFileObj = new File(inputFile);
        if (inputFileObj.exists()) {
            inputFileObj.delete();
        }
    }

    @SneakyThrows
    private void createEmptyOutputFile() {
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write("null".getBytes());
        fos.close();
    }

    @SneakyThrows
    private void writeHashToFile(byte[] hashBytes) {
        FileOutputStream fos = new FileOutputStream(outputFile);
        var base64 = Base64.getEncoder().encode(hashBytes);
        fos.write(base64);
        fos.close();
    }
}