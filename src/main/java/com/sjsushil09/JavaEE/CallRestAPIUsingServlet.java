package com.sjsushil09.JavaEE;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;

public class CallRestAPIUsingServlet {
    public static void main(String[] args) throws IOException, InterruptedException {


        // Create an HttpClient with a connection timeout
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10)) // Set a connection timeout of 10 seconds
                .build();

        // Create an HttpRequest with a request timeout
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.restful-api.dev/objects"))
                .GET()
                .timeout(Duration.ofSeconds(2)) // Set a request timeout of 5 seconds
                .build();

        try {
            // Send the request and receive the response synchronously
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (HttpTimeoutException e) {
            System.err.println("Request timed out: " + e.getMessage()); // Handle request timeout
        } catch (ConnectException e) {
            System.err.println("Connection failed: " + e.getMessage()); // Handle connection failure
        } catch (IOException e) {
            System.err.println("IO error occurred: " + e.getMessage()); // Handle IO exceptions
        } catch (InterruptedException e) {
            System.err.println("Request interrupted: " + e.getMessage()); // Handle interruption
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage()); // Handle any other exceptions
        }


//        String newPhone  = "{\n" +
//                "   \"name\": \"Apple MacBook Pro 16\",\n" +
//                "   \"data\": {\n" +
//                "      \"year\": 2019,\n" +
//                "      \"price\": 1849.99,\n" +
//                "      \"CPU model\": \"Intel Core i9\",\n" +
//                "      \"Hard disk size\": \"1 TB\"\n" +
//                "   }\n" +
//                "}";
//
//        HttpRequest request2 = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.restful-api.dev/objects"))
//                .POST(HttpRequest.BodyPublishers.ofString(newPhone))
//                .header("Content-Type", "application/json") // Set the Content-Type header
//                .build();
//
//HttpResponse<String> response = client.send(request2, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.statusCode());
//        System.out.println(response.body());


    }
}
