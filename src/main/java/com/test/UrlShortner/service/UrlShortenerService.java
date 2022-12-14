package com.test.UrlShortner.service;

import com.test.UrlShortner.model.ErrorResponse;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

     public boolean validateURL(String url) {

         String[] schemes = {"http","https"};
         UrlValidator urlValidator = new UrlValidator(schemes);
         if (urlValidator.isValid(url)) {
             System.out.println("url is valid");
             return true;
         } else {
             return false;
         }
    }

    public String shortenURL(String url) {
          String newURL=getAlphaNumericString(10);
         //check if String present in H2
            return newURL;

    }

    public ErrorResponse buildErrorResponseObject(String url) {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorMessage("Invalid URL" + url);
        return errorResponse;
    }

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}

