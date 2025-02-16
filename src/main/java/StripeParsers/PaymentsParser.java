package StripeParsers;

import java.util.ArrayList;
import java.util.List;

/*

The question is to compress the string. The rule is that in the result, for each major part, it contains at most<minor_parts>minor parts.
 And for each minor parts, you need to compress it in the format of<heading_letter><letter_count_in_betwee><tailing_letter>.
The edge case is, what if the minor part contains less than 3 letters? Like the first minor part of.stripe.com/checkout
Given a String, split it into major parts separated by special char '/'.

For each major part that’s split by '/', we can further split it into minor parts separated by '.'
# **### Example 1**

# **str = [stripe.com/payments/checkout/customer.john.doe](http://stripe.com/payments/checkout/customer.john.doe)**

# **minor_parts = 2**

# **after Part 1 compression**

# **=>**

# **s4e.c1m/p6s/c6t/c6r.j2n.d1e**

# **after Part 2 compression**

# **=>**

# **s4e.c1m/p6s/c6t/c6r.j5e**

# **### Example 2**

# **Given:**

# **str =[www.api.stripe.com/checkout](http://www.api.stripe.com/checkout)**

# **minor_parts = 3**

# **(after Part 1 compression)**

# **=>**

# **w1w.a1i.s4e.c1m/c6t**

# **(then after Part 2 compression)**

# **=>**

# **w1w.a1i.s7m/c6t**

'''
 */
public class PaymentsParser {

        public static void main(String[] args){

            String input = "stripe.com/payments/checkout/customer.john.doe";
            System.out.println("Result:"+compressString(input,2));
        }

        public static String compressString(String s, int minorcount){

            String[] majorparts = s.split("/");
           List<String> res = new ArrayList<>();
            for(String majorpart: majorparts){

               String majorRes = compressMajorPart(majorpart,minorcount);
               if(getMinorcount(majorRes) > minorcount){
                   majorRes = compressMajorPart(majorRes,minorcount);
               }
               res.add(majorRes);
            }
            return String.join("/",res);
        }

        private static String compressMajorPart(String majorpart,int minorcount){
            List<String> compressedMajorParts = new ArrayList<>();
            String[] minorparts = majorpart.split("\\.");
            for(String minorpart:minorparts){
                if(minorpart.length()<3) {
                    compressedMajorParts.add(minorpart);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(minorpart.charAt(0));
                    sb.append(minorpart.substring(1,minorpart.length()-1).length());
                    sb.append(minorpart.charAt(minorpart.length()-1));
                    compressedMajorParts.add(sb.toString());
                }

            }

            return String.join(".",compressedMajorParts);
        }

        private static int getMinorcount(String s) {
            String[] minorstring  = s.split("\\.");
            return minorstring.length;
        }


}
