package StripeParsers;

import java.math.BigDecimal;
import java.util.Objects;

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
