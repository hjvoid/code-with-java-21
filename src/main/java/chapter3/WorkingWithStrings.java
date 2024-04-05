package chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkingWithStrings {

    public static void main(String[] args) {

        String email = "victoria.ploetz@largecorp.com";

        // get string positions
        int dotPos = email.indexOf('.');
        int atPos = email.indexOf('@');
        int dot2Pos = email.indexOf('.', email.indexOf('.') + 1);
        // Phone numbers
        String phoneNumber = "444-867-5309";
        String phoneNumber2 = "444-188-2300";
        // Phone number matchers
        Pattern phone188Pattern = Pattern.compile("[0-9]{3}\\-[0-9]{3}\\-[0-9{4]");
        Matcher phone188Matcher = phone188Pattern.matcher(phoneNumber);
        Matcher phone188Matcher2 = phone188Pattern.matcher(phoneNumber2);
        // Name positions
        String firstName = email.substring(0, dotPos);
        String lastName = email.substring(dotPos + 1, atPos);
        String company = email.substring(atPos + 1, dot2Pos);
        // Nicknames
        String nickname = "Toria";
        String nickname2 = "Vicky";
        String robert = "Robert";
        String nickname3 = "Rob";
        String nickname4 = "Bob";

        System.out.println("First name: " + properCase(firstName));
        System.out.println("Last name: " + properCase(lastName));
        System.out.println("Company: " + company);

        if (isBusinessEmail(email)) {
            System.out.println("******************************************");
            System.out.println("Congrats - you've got a business email!!!");
        } else {
            System.out.println("Sorry - no business email for you :-(");
        }

        if(phone188Matcher.find()) {
            System.out.println(phoneNumber + " is a valid 188 number. (regex)");
        }

        if (phone188Matcher2.find()) {
            System.out.println(phoneNumber2 + " is a valid 188 number. (regex)");
        }

        System.out.println("\nBob pattern:");
        Pattern bobPattern = Pattern.compile("(B|R)ob");
        Pattern victoriaPattern = Pattern.compile("^(Vic|).*(oriaky)$");

        matchName(bobPattern, nickname);
        matchName(bobPattern, nickname2);
        matchName(bobPattern, nickname3);
        matchName(bobPattern, nickname4);
        matchName(bobPattern, robert);
        matchName(bobPattern, firstName);

        matchName(victoriaPattern, nickname);
        matchName(victoriaPattern, nickname2);
        matchName(victoriaPattern, nickname3);
        matchName(victoriaPattern, nickname4);
        matchName(victoriaPattern, robert);
        matchName(victoriaPattern, firstName);
    }

    private static String properCase(String name) {
        char firstLetter = Character.toUpperCase(name.charAt(0));

        return firstLetter + name.substring(1);
    }

    private static boolean isBusinessEmail(String email) {
        return !email.endsWith("@gmail.com") && !email.endsWith(".edu");
    }

    private static void matchName(Pattern pattern, String name){

        Matcher matcher = pattern.matcher(name);

        if (matcher.find()) {
            System.out.println("Match found! Welcome " + name + "!");
        } else {
            System.out.println("Sorry " + name + ", no match found.");
        }
    }
}
