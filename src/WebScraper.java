import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        String urlText = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(urlText));
        System.out.println(sameWordCount(urlText, "a"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String text) {
        String[] wordArray = text.split(" ");
        return wordArray.length;
    }

    public static int sameWordCount(String text, String textToFind) {
        String[] wordArray = text.split(" ");
        int sameWordCounter = 0;
        for (String word : wordArray) {
            if (word.equalsIgnoreCase(textToFind)) {
                sameWordCounter++;
            }
        }
        return sameWordCounter;
    }
}
