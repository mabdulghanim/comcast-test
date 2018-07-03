import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.out.println(getHTML("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22"));
    //    System.out.println(getHTML("https://api.darksky.net/forecast/01dd46203f644ffc0d6f327082216511/37.8267,-122.4233"));
     //   System.out.println(getHTML("http://maps.googleapis.com/maps/api/geocode/json?address=chicago"));
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a city: ");
        String city = reader.next(); // Scans the next token of the input as a String.
        reader.close();
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
