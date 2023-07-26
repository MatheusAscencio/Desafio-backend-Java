package com.challenge.backend.utils;

import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpReq {

    // Makes an HTTP Request
    public static HttpResponse<String> req(String uri) throws IOException, InterruptedException {
        
        HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(uri)).build();

        HttpClient httpCli = HttpClient.newBuilder().build();

        HttpResponse<String> res = httpCli.send(req, BodyHandlers.ofString());

        return res;
    }
    
}
