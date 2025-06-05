import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Net_Update { // Net-Update v1.0 by Chill-Astro

    private Net_Update() { // Private constructor to prevent instantiation
        throw new UnsupportedOperationException("Net_Update is a utility class and cannot be instantiated.");        
    }

    static void update (String appName, String appVer, String rawGistURL) {
        try {
            URI uri = new URI(rawGistURL); // Use URI to create a URL
            URL url = uri.toURL(); // Convert URI to URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000); // Timeout after 5 seconds
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String latestVersion = reader.readLine().trim();
                reader.close();

                if (latestVersion.compareTo(appVer) > 0) {
                    System.out.println("--- UPDATE AVAILABLE! ---\n" +
                                       "Yaaay! A NEW version of " + appName + " is Available! : " + latestVersion + "\n" +                                  
                                       "-----------------------");
                } else if (latestVersion.equals(appVer)) {
                    System.out.println("Hurrah! " + appName + " is up to date!\n");
                } else {
                    System.out.println("WARNING! This is a DEV. Build of " + appName + "!\n");
                }
            } else {
                System.out.println("--- UPDATE CHECK FAILED! ---\n" +
                                   "WARNING! Could not check for updates. Please check your internet connection.\n" +
                                   "------------------------");
            }
        } catch (Exception e) {
            System.out.println("--- UPDATE CHECK FAILED ---\n" +
                               "WARNING! Error occurred while checking for updates.\n" +
                               "Error: " + e.getMessage() + "\n" +
                               "------------------------");
        }
    }
}
