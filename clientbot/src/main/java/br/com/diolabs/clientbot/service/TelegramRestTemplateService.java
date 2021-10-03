package br.com.diolabs.clientbot.service;

import org.springframework.stereotype.Service;

import br.com.diolabs.clientbot.client.ClienteRestTemplate;
import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;

@Service
public class TelegramRestTemplateService {

    private ClienteRestTemplate clienteRestTemplate;


    public TelegramRestTemplateService(ClienteRestTemplate clienteRestTemplate) {
        this.clienteRestTemplate = clienteRestTemplate;
    }

    public void enviarMensagem(MensagemSend msg){
        clienteRestTemplate.enviarMensagem(msg);
    }

    public ResultBotTelegramList buscarAtualizacoes() {
        return clienteRestTemplate.buscarAtualizacoes();
    }
    
}
