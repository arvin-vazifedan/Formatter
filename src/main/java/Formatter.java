public class Formatter {

   private Formatter(){
     throw new IllegalStateException("Utility class");
   }

    public static String format(String str) {
        if (textContainsArabic(str)) {
            System.out.println("AR");
            String s = "؟،؛";
            str = str.replaceAll("\\s*(?=[.,!:" + s + "{\\[(<])|(?<=[.,!:" + s + "}\\])>])\\s*", "");
            str = str.replaceAll("(?<=[.," + s + ":}\\])>])", " ");
        } else {
            System.out.println("EN");
            str = str.replaceAll("\\s*(?=[.,?!:;{\\[(<])|(?<=[.,?!:;}\\])>])\\s*", "");
            str = str.replaceAll("(?<=[.,?!;:}\\])>])", " ");
        }
        return str;
    }

    public static boolean textContainsArabic(String text) {
        for (char ch : text.toCharArray())
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.ARABIC)
                return true;
        return false;
    }

}

