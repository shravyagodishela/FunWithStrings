package StripeParsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Part 1:
You are given a string representing application IDs in the following format:

Each application ID is prefixed by its length (number of characters in the ID).
The format is: lengthOfApplicationId + APPLICATION_ID + ... + 0 (ends with a 0).
Example:
Input: 10A13414124218B124564356434567430
Output: ["A134141242", "B12456435643456743"]

Part 2:
Filter the application IDs obtained from Part 1 to return only the "whitelisted" application IDs.

Example:
Input: 10A13414124218B124564356434567430, ["A134141242"]
Output: ["A134141242"]
 */
public class WhitelistApplicationParser {
    public static void main(String[] args) {

        String input = "10A13414124218B124564356434567430";
        List<String> whitelist = Arrays.asList("A134141242");

        parseIds(input,whitelist);

    }

    static void parseIds(String input, List<String> whitelist){

        List<String> allIds = new ArrayList<>();

        int i=0;
        int n=input.length();

        while(i<n-1){

            int start = i;
            while(Character.isDigit(input.charAt(i))) i++;
            int appIdlength = Integer.parseInt(input.substring(start,i));
            String appid = input.substring(i,i+appIdlength);
            System.out.println(appid);
            allIds.add(appid);
            i+=appIdlength;
            if(i==n-1) break;
        }
        allIds.stream().filter(k->whitelist.contains(k)).forEach(System.out::println);

    }
}
