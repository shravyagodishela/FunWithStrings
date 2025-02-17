package StripeParsers;

import java.math.BigDecimal;
import java.util.*;

public class LexographicalParsers {

    public static void main(String[] args){
        List<String> transactions = Arrays.asList(
                "Visa,Jan,50.50,USD,open",
                "MasterCard,Feb,40.00,EUR,closed",
                "Amex,Mar,70.20,USD,defaulted",
                "Visa,Apr,30.00,GBP,closed",
                "MasterCard,Jan,20.50,USD,open"
        );

        List<Transaction> transactionList = new ArrayList<>();
        for(String s:transactions){
            String[] parts = s.split(",");
            if(parts.length==5){
                String cardCompany = parts[0];
                String transactionMonth = parts[1];
                BigDecimal transactionFee = new BigDecimal(parts[2]); // Using BigDecimal
                String currency = parts[3];
                String queryStatus = parts[4];

                transactionList.add(new Transaction(cardCompany, transactionMonth, transactionFee, currency, queryStatus));
            }
        }

        transactionList.removeIf((t)->t.queryStatus.equals("defaulted"));
        Collections.sort(transactionList);
        transactionList.forEach(System.out::println);

    }



}

class Transaction implements Comparable<Transaction>{

    String cardCompany;
    String transactionMonth;
    BigDecimal transactionFee; // Using BigDecimal for precise financial calculations
    String currency;
    String queryStatus;

    public Transaction(String cardCompany, String transactionMonth, BigDecimal transactionFee, String currency, String queryStatus) {
        this.cardCompany = cardCompany;
        this.transactionMonth = transactionMonth;
        this.transactionFee = transactionFee;
        this.currency = currency;
        this.queryStatus = queryStatus;
    }
    @Override
    public int compareTo(Transaction o){
        return this.cardCompany.compareTo(o.cardCompany);
    }


    @Override
    public String toString() {
        return cardCompany + "," + transactionMonth + "," + transactionFee.toPlainString() + "," + currency + "," + queryStatus;
    }
}
