public class Formatter {

    public static String format(String str) {
        if (textContainsArabic(str)) {
            //TODO fix non whitespace issue: look,if
            System.out.println("AR");
            str = str.replaceAll("\\s*(?=[.,!:" + "؟،؛" + "{\\[(<])", "");
            str = str.replaceAll("(?<=[.,!:" + "؟،؛" + "}\\])>]\\s)\\s*", "");
        } else {
            System.out.println("EN");
            str = str.replaceAll("\\s*(?=[.,?!:;{\\[(<])", "");
            str = str.replaceAll("(?<=[.,?!:;}\\])>]\\s)\\s*", "");
        }
        // str = str.replaceAll("\\b(?=[+\\-*^/%=])", " ");
        // str = str.replaceAll("(?<=[+\\-*^/%=])\\b", " ");
        return str;
    }

    public static boolean textContainsArabic(String text) {
        for (char ch : text.toCharArray())
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.ARABIC)
                return true;
        return false;
    }
}
