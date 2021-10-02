package br.com.diolabs.clientbot.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegram;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;

@Component
public class ClienteHttp {

    @Value("${telegram.api}")
    private String BASE_PATH;

    @Value("${telegram.token}")
    private String TOKEN;

    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    public ClienteHttp(ObjectMapper objectMapper) {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = objectMapper;
    }

    public ResultBotTelegramList buscarAtualizacoes() {

        ResultBotTelegramList retorno = null;

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_PATH + TOKEN + "/getUpdates")).GET()
                    .build();
            HttpResponse<String> response = sendRequest(request);

            if (response != null) {
                retorno = objectMapper.readValue(response.body(), ResultBotTelegramList.class);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return retorno;
    }

    public void enviarMensagem(MensagemSend msg) {
        try {
            String mensagem = objectMapper.writeValueAsString(msg);

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_PATH + TOKEN + "/sendMessage"))
                    .header("Content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(mensagem))
                    .build();
            HttpResponse<String> response = sendRequest(request);
            if (response != null) {
                objectMapper.readValue(response.body(), ResultBotTelegram.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpResponse<String> sendRequest(HttpRequest request) {
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {

            e.printStackTrace();

        }

        return response;
    }

}
