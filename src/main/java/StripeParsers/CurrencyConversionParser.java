package StripeParsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/*
 **Part 1**: Parse a string in the format "USD:CAD:DHL:5,USD:GBP:FEDX:10",
 * representing currency conversion rates from a source to a target currency
 *  and the associated shipping method. Write a method to convert a given amount
 *  from one currency to another. Only direct conversions are allowed.

 **Part 2:** Write a method that returns the cost and shipping methods involved,
 *  allowing *at most* one hop in the conversion from one currency to another.

 **Part 3**: Write a method that returns the minimum cost and involved shipping methods,
 *   allowing *at most* one hop for the conversion.
 */
public class CurrencyConversionParser {


    public static Map<String, Map<String,ConversionEdge>>  adj = new HashMap<>();

    public static void main(String[] args) {
        String input = "USD:GBP:DHL:0.75,GBP:CAD:FEDX:1.65,USD:CAD:DHL:1.25";
        for(String s:input.split(",")) {
            String[] parts = s.split(":");
            adj.computeIfAbsent(parts[0], k -> new HashMap<>()).put(parts[1], new ConversionEdge(parts[2], new BigDecimal(parts[3])));
        }
    }

    public static double part1(String currency1, String currency2,BigDecimal amount){

        if(!adj.containsKey(currency1)) return -1;

        Map<String,ConversionEdge>  destinations = adj.get(currency1);

        for(Map.Entry<String,ConversionEdge> entry : destinations.entrySet()){
            String destination = entry.getKey();
            ConversionEdge conversionEdge = entry.getValue();
            if(destination.equals(currency2)){
                return amount.multiply(conversionEdge.getPrice()).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return -1;
    }

}

@Getter
@Setter
@AllArgsConstructor
class ConversionEdge{
    String mode;
    BigDecimal price;
}

