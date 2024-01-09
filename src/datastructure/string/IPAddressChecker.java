package datastructure.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressChecker {
    private String input;

    public IPAddressChecker(String input) {
        this.input = input;
    }

    public boolean isIPAddress() {
        String ipAddressRegex = "\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b";
        Pattern pattern = Pattern.compile(ipAddressRegex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public String getInput() {
        return this.input;
    }

    public static void main(String[] args) {
        IPAddressChecker ipChecker = new IPAddressChecker("127.0.0.1");
        System.out.println("Is \"" + ipChecker.getInput() + "\" an IP address? " + ipChecker.isIPAddress());
    }
}
