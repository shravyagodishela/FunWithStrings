package StripeParsers;

import java.math.BigDecimal;

public class Dispute {

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
}
