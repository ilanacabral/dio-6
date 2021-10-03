package br.com.diolabs.clientbot.service;

import org.springframework.stereotype.Service;
import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;
import br.com.diolabs.clientbot.client.ClienteFeing;

@Service
public class TelegramFeingService {
    
    private ClienteFeing clienteFeing;


    public TelegramFeingService(ClienteFeing clienteFeing) {
        this.clienteFeing = clienteFeing;
    }

    public void enviarMensagem(MensagemSend msg){
        clienteFeing.enviarMensagem(msg);
    }

    public ResultBotTelegramList buscarAtualizacoes() {
        return clienteFeing.buscarAtualizacoes();
    }
}
