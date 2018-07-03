import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a city: ");
        String city = reader.next(); // Scans the next token of the input as a String.
        reader.close();
        System.out.println("The weather conditions for the city of "+city+" are:");
        System.out.println(getHTML("http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=imperial&appid=e35a258f7b800b3fa59bada0598aaf9a"));
    }
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}
