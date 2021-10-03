package br.com.diolabs.clientbot.service;

import org.springframework.stereotype.Service;

import br.com.diolabs.clientbot.client.ClienteHttp;
import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;

@Service
public class TelegramHttpService {

    private ClienteHttp clienteHttp;


    public TelegramHttpService(ClienteHttp clienteHttp) {
        this.clienteHttp = clienteHttp;
    }

    public void enviarMensagem(MensagemSend msg){
        clienteHttp.enviarMensagem(msg);
    }

    public ResultBotTelegramList buscarAtualizacoes() {
        return clienteHttp.buscarAtualizacoes();
    }


    
}
