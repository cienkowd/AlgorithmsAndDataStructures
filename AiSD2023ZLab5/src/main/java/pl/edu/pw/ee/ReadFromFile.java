package pl.edu.pw.ee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {

    private static final byte[] charactersQuantity = new byte[256];
    public ReadFromFile(File inputFile) throws IOException {
        try (InputStream inputStream = new FileInputStream(inputFile)) {
            int n = inputStream.read();
            while (n != -1) {
                charactersQuantity[n]++;
                n = inputStream.read();
            }
        }
    }

    public byte[] getCharactersQuantity() {
        return charactersQuantity;
    }
}
