package br.com.diolabs.clientbot.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegram;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;

@Component
public class ClienteRestTemplate {

    @Value("${telegram.api}")
    private String BASE_PATH;

    @Value("${telegram.token}")
    private String TOKEN;

    @Autowired
    private RestTemplate restTemplate;

    public ClienteRestTemplate() {

    }

    public ResultBotTelegramList buscarAtualizacoes() {

        return restTemplate.getForObject(BASE_PATH + TOKEN + "/getUpdates", ResultBotTelegramList.class);

    }

    public void enviarMensagem(MensagemSend msg) {
        
        //Variás formas de submeter uma requisção

        restTemplate.postForLocation(BASE_PATH + TOKEN + "/sendMessage", msg);

        restTemplate.postForObject(BASE_PATH + TOKEN + "/sendMessage", msg, ResultBotTelegram.class);

        restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage", msg, ResultBotTelegram.class);
      
        restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage", new HttpEntity<>(msg), ResultBotTelegram.class);

        restTemplate.exchange(BASE_PATH + TOKEN + "/sendMessage", HttpMethod.POST, new HttpEntity<>(msg), ResultBotTelegram.class);
    }

}
