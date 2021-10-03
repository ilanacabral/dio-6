package br.com.diolabs.clientbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;


@FeignClient(url="${telegram.api}${telegram.token}",name = "feingClient")
public interface  ClienteFeing {
  
    @GetMapping("/sendMessage")
    public void enviarMensagem(@RequestBody MensagemSend msg);
  
    @PostMapping("/getUpdates")
    public ResultBotTelegramList buscarAtualizacoes();

    
}
