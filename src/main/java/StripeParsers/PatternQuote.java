package StripeParsers;

import java.util.regex.Pattern;

public class PatternQuote {

    String[] splitstrings(String input,String pattern){

        return input.split(Pattern.quote(pattern));
    }

}
