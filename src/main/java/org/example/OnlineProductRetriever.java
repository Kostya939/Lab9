package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OnlineProductRetriever {

    private static final String API_ENDPOINT = "https://fakestoreapi.com/products";

    public static List<Product> fetchProducts() throws IOException {
        URL url = new URL(API_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (var reader = connection.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JsonNode jsonArray = objectMapper.readTree(reader);
                return parseProducts(jsonArray, objectMapper);
            }
        } else {
            throw new IOException("Failed to fetch products. HTTP error code: " + connection.getResponseCode());
        }
    }

    private static List<Product> parseProducts(JsonNode jsonArray, ObjectMapper objectMapper) throws IOException {
        List<Product> products = new ArrayList<>();
        if (jsonArray.isArray()) {
            for (JsonNode productNode : jsonArray) {
                products.add(objectMapper.treeToValue(productNode, Product.class));
            }
        }
        return products;
    }
}
