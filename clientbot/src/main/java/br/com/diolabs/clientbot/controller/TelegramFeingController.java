package br.com.diolabs.clientbot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;
import br.com.diolabs.clientbot.service.TelegramFeingService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v3/telegram")
public class TelegramFeingController {

    @Autowired
    private TelegramFeingService telegramFeingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultBotTelegramList getMensagens() {
        return telegramFeingService.buscarAtualizacoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enviarMensagem(@Valid @RequestBody MensagemSend msg) {
        telegramFeingService.enviarMensagem(msg);
    }

}
