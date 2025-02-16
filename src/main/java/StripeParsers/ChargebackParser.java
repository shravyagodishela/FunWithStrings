package StripeParsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ChargebackParser {

    public static void main(String[] args){
       try {
           parseFileAndComputeDispute();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void parseFileAndComputeDispute() throws IOException {
        String filename = "/Users/shravya/IdeaProjects/FunWithStrings/src/main/resources/chargebacks.csv";  // Change this


        if (!Files.exists(Paths.get(filename))) {
            System.err.println("File not found at: " + filename);
            System.exit(1);
        }

        List<Dispute> res = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String headerline  = bufferedReader.readLine();
        String line;
        while( (line = bufferedReader.readLine()) !=null){

            String[] disputearray = line.split("\\,");
            String transactionid = disputearray[0];
            String network = disputearray[1];
            String reason = disputearray[2];
            System.out.println(reason);
            String date = disputearray[3];
            BigDecimal amount = new BigDecimal(disputearray[4]);

            if(reason.equals("chargeback")) res.add(new Dispute(transactionid,network,reason,amount,date));
        }
       res.forEach(System.out::println);

    }
}
