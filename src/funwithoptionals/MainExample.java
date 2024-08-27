package funwithoptionals;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * In this example class, we are going to use java.util.Optional's map and filter
 * functionality to extract just the JWT payload from an OKTA token obtained from
 * any given request header.
 *
 * java.util.optional.map takes a Function as input. A function performs logic on the
 * input value.  You can use lambda expressions to create a functional interface
 * implementation on the fly, as we show below.
 *
 * java.util.optional.filter takes a Predicate as input.  A predicate performs logic on
 * the input value that results in a boolean value.  You can use lambda expressions to
 * create a Predicate implementation on the fly, as we show below.
 */
public class MainExample {
    /*
     * This is an expired OKTA token.  It has 3 parts, each separated by a '.' -- JWT Header,
     * JWT Payload, and JWT Signature (in that order).
     */
    private static final String oktaHeaderIn = "Bearer eyJraWQiOiJ1bTVJUmFCLTBocG9vRnVrLU1nWHhVVEFsRDNxckt0UWtyZlZGZm9kcC1nIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULkR0QmczNHlZZmRORFBuV3dhMTB1Ty1jOXZOQU52Y3RrbXFrcjRXcm5WajAub2FyMTBieWJhNTNHMXhBYkMxZDciLCJpc3MiOiJodHRwczovL2F1dGgudGVzdC5zdGF0ZWZhcm0uY29tL29hdXRoMi9hdXMzdzZwZ2o0clpxVkpUVDFkNyIsImF1ZCI6InNmLmIyYzovL2FwaSIsImlhdCI6MTcxMzc5ODM4OCwiZXhwIjoxNzEzNzk5Mjg4LCJjaWQiOiIwb2E4eWVwd3J5TDRucThsOTFkNyIsInVpZCI6IjAwdWR6b3M0NTlKM3djVFQyMWQ3Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwib3BlbmlkIiwic2ZtYTp1c2VyOnByb2ZpbGUucmVhZCJdLCJhdXRoX3RpbWUiOjE3MTM3OTgzODgsInN1YiI6IkNUSUMwNEkzRU4xNSIsImNsaWVudElkIjoiVk1WUFcwRDMwMDEiLCJiMmNpZCI6IjYzNzk2MTgyNzE2OTUyMjkiLCJzbXNFbnJvbGxlZCI6Ik5PVF9FTlJPTExFRCJ9.VP3b9ld7OoLJN9yV2DjPrf3r07acnJesoLdP0fvd2r7pTMUj4DCvIAfwgImRhoci4I94XlTGNZOUOsglZBI_pOutIidfKrj0Tmne7UYRRtNbIuhl4_PtJ2P__5iRb5rawaJfPGiRSwZ66p3gZIhAe1rfhuUQuBVJmvJhjcNOCROdQZ2b_-WD2owY9KcUOCdSMgh555h1PoaeSZq2rhl6nTAX-TKt2WPTELGkUqt9vJFTXTad3X69E5mP-wxp8KbbcT-2A7FTbkSA4sd9M4LnR3M9iAfb01d8IgUM5xqMTUnW6UqPMmCLu20_J0aDTqShSheloWHlzfrfWF2O_jpuyQ";


    /**
     * Here we show several examples of using java.util.optional's map
     * and filter functionality to manipulate a JWT.
     *
     */
    public static void main(String[] args) {
        /*
         * This example takes the complete JWT header value and returns
         * just the encoded 3-part token value. This is done with the
         * map functionality.
         */
        Optional<String> justTheToken = getMeTheToken(oktaHeaderIn);
        System.out.println(justTheToken.get());

        /*
         * This example takes the complete JWT header value and returns
         * just the encoded 3-part token value but ONLY if the input
         * has 3 parts delimited by a '.'.  Otherwise, it will return
         * an empty Optional. This is done with the map and filter
         * functionality.
         *
         * This example will return a value because it's a 3-part JWT
         */
        justTheToken = getMeTheJWTPayload(oktaHeaderIn);
        if (justTheToken.isPresent()){
            System.out.println("Token successfully returned");
        } else {
            System.out.printf("Well this example didn't work like it was supposed to....");
        }


        /*
         * This example takes the complete JWT header value and returns
         * just the encoded 3-part token value but ONLY if the input
         * has 3 parts delimited by a '.'.  Otherwise, it will return
         * an empty Optional. This is done with the map and filter
         * functionality.
         *
         * This example will NOT return a value because it is NOT a 3-part JWT
         */

        justTheToken = getMeTheJWTPayload("Bearer xxxxxxxx");
        if (justTheToken.isEmpty()){
            System.out.println("No token returned");
        } else {
            System.out.printf("Well this example didn't work like it was supposed to....");
        }

    }


    /**
     * This method illustrates the use of Optional's map functionality
     * to strip the 'Bearer ' prefix from an OKTA token obtained from
     * a request header and return just the token value as an Optional.
     *
     * We use Optional in case the token is null.
     *
     * @param String (rawHeaderIn)
     * @return Optional<String> (just the token)
     */
    public static Optional<String> getMeTheToken (String rawHeaderIn){
        return Optional.ofNullable(rawHeaderIn)
                .map(authorization -> StringUtils.removeStartIgnoreCase(authorization,"Bearer "));
    }


    /**
     * This method illustrates the use of Optional's map and filter functionality
     * to strip the 'Bearer ' prefix from an OKTA token obtained from
     * a request header and only return tokens that have 3 parts (each part
     * separated by '.') and returning such tokens as an Optional.
     *
     * The Optional will be empty if this filter criteria is not met
     *
     * @param String (rawHeaderIn)
     * @return Optional<String> (just the 3-part token, delimited by '.')
     */
    public static Optional<String> getMeTheJWTPayload (String rawHeaderIn){
        return Optional.ofNullable(rawHeaderIn)
                .map(authorization -> StringUtils.removeStartIgnoreCase(authorization,"Bearer "))
                .filter(token -> ArrayUtils.getLength(StringUtils.split(token,"."))==3);
    }

}
