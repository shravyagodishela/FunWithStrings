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
import java.util.Objects;

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

class Dispute {

    String transactionId;
    String network;
    String reason;
    BigDecimal amount;
    String date;

    public Dispute(String transactionid, String network, String reason, BigDecimal amount, String date) {
        this.transactionId=transactionid;
        this.network = network;
        this.reason = reason;
        this.amount = amount;
        this.date =date;
    }

    @Override
    public String toString(){
        return transactionId + " | " + network + " | " + reason + " | " + amount + " | " + date;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o ==null || getClass() !=o.getClass()) return false;

        Dispute dispute = (Dispute) o;
        return Objects.equals(transactionId, dispute.transactionId) &&
                Objects.equals(network, dispute.network) &&
                Objects.equals(reason, dispute.reason) &&
                Objects.equals(date, dispute.date) &&
                Objects.equals(amount, dispute.amount);

    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, network, reason, date, amount);
    }
}
