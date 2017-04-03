package au.com.xyz.exam;

import org.springframework.util.StringUtils;

/**
 * Created by Andy Wu on 31/04/2017.
 */
public class SubscriptionController {
    private final String CONSTANT_STRING = " ... (truncated) ... "; // 21 chars

    public String truncate(String orderDetails, Integer num){
        if(orderDetails == null || StringUtils.isEmpty(orderDetails)){
            return  orderDetails;
        }

        Integer len = orderDetails.length();
        if(len > num){
            if(num > CONSTANT_STRING.length()) {
                int i = num - CONSTANT_STRING.length();
                int j = i / 2;
                String s1 = new String(orderDetails.substring(0, j));
                String s2 = new String(orderDetails.substring(len - (i - j)));

                StringBuilder sb = new StringBuilder();
                sb.append(s1);
                sb.append(CONSTANT_STRING);
                sb.append(s2);
                return sb.toString();
            }else{
                return orderDetails;
            }
        }else {
            return orderDetails;
        }
    }
}
