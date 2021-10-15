package Office;

import com.opencsv.CSVWriter;

import java.io.*;

public class CreateCsvFiles {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fileNumber = 1;
        File file = new File("/Users/rahulagarwal/files/jmeter/listingStage" + fileNumber +".csv");
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);
        for (int i=1;i<=200;i++) {
            int k=0;
            String[] data = new String[10];
            while (k<10) {
                String tuin = br.readLine().trim();
                data[k] = tuin;
                k++;
            }
            writer.writeNext(data);
        }
        writer.close();
    }
}
