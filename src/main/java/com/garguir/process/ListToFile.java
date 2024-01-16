package com.garguir.process;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ListToFile {
    private static final Logger LOGGER = Logger.getLogger("ListToFile");
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String PATH_CSV = USER_DIR+"\\src\\main\\resources\\repos.csv";
    private static final String LINE_BREAK = "\n";
    public void saveUrls(List<String> reposList){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_CSV));

            for(String line : reposList) {
                stringBuilder.append(line);
                stringBuilder.append(LINE_BREAK);
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
            LOGGER.info("Archivo .csv guardado");
        }catch (IOException ioException){
            LOGGER.warning("Error: Fallo de escritura del archivo .csv " + ioException);
        }
    }
}
