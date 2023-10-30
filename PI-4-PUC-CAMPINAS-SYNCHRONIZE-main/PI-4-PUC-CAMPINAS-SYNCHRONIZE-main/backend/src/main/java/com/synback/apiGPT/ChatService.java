package com.synback.apiGPT;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;


@Service
public class ChatService {
    public static String chatGPT(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
        return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");

    }

    public static void main(String[] args) throws Exception {
        chatGPT("Estou com dor de cabeça e enjoo, oque faço?");
    }
}