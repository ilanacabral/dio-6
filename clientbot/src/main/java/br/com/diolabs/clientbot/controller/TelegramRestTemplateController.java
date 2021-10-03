package br.com.diolabs.clientbot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.clientbot.service.TelegramRestTemplateService;
import br.com.diolabs.clientbot.dto.MensagemSend;
import br.com.diolabs.clientbot.dto.ResultBotTelegramList;

@RestController
@RequestMapping("/v2/telegram")
public class TelegramRestTemplateController {

    @Autowired
    private TelegramRestTemplateService telegramRestTemplateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultBotTelegramList getMensagens() {
        return telegramRestTemplateService.buscarAtualizacoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enviarMensagem(@Valid @RequestBody MensagemSend msg) {
        telegramRestTemplateService.enviarMensagem(msg);
    }
    
}
