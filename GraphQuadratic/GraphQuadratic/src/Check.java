
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BossLong
 */
public class Check {

    public Check() {

    }

    public static String coeff(String str, String regex) {
        Pattern patt = Pattern.compile(regex);
        Matcher match = patt.matcher(str);
        String coeff = "+0";
        double value = 0;
        if (match.find()) {
            coeff = match.group(1);
        }
        value = Double.parseDouble((coeff.length() == 1) ? coeff + "1"
                : coeff);
        String value2 = String.valueOf(value);
        return (value2.length() == 1) ? (value2 + "1") : value2;
    }

//    public static boolean check(String x, String regex) {
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(x);
//        if (matcher.find()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static double quadParseA(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");
        double a = Double.parseDouble(coeff(str, "([+-][0-9]*)([a-z]\\^2)"));
        return a;
    }

    public static double quadParseB(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");
        double b = Double.parseDouble(coeff(str, "([+-][0-9]*)([a-z](?!\\^))"));
        return b;
    }

    public static double quadParseC(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");
        double c = Double.parseDouble(coeff(str, "([+-][0-9]+)(?![a-z])"));
        return c;
    }
}
