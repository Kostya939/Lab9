package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ApiClient {

    private String apiKey;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Customer> getCustomers() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://api.recrm.ru/v1/customers?apiKey=" + apiKey);

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Failed to get customers");
        }

        String responseBody = EntityUtils.toString(response.getEntity());

        Type type = new TypeToken<List<Customer>>() {}.getType();
        List<Customer> customers = new Gson().fromJson(responseBody, type);

        return customers;
    }

    public List<Product> getProducts() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://fakestoreapi.com/products?apiKey=" + apiKey);

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Failed to get products");
        }

        String responseBody = EntityUtils.toString(response.getEntity());

        Type type = new TypeToken<List<Product>>() {}.getType();
        List<Product> products = new Gson().fromJson(responseBody, type);

        return products;
    }

    public List<Order> getOrders() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://fakeapi.platzi.com/en/rest/orders?apiKey=" + apiKey);

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Failed to get orders");
        }

        String responseBody = EntityUtils.toString(response.getEntity());

        Type type = new TypeToken<List<Order>>() {}.getType();
        List<Order> orders = new Gson().fromJson(responseBody, type);

        return orders;
    }
}

