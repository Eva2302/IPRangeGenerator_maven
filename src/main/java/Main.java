import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";


    public static boolean test(String ip)
    {
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the first IP-address: ");
        //String start = scanner.next(IPADDRESS_PATTERN);
        String start = scanner.next();

        if (!test(start)) {System.out.println("Incorrect format of the IP-address"); return;}

        System.out.print("Input the second IP-address: ");
        //String end = scanner.next(/*IPADDRESS_PATTERN*/); //not working when using 2nd time
        String end = scanner.next();

        if (!test(end)) {System.out.println("Incorrect format of the IP-address"); return;}

        IPRange IPRangeObj = new IPRange(start,end);

        //Making a range of IP-Addresses
        IPRangeObj.go();

    }
}
