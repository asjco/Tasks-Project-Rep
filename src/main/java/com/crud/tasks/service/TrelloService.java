package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    private TrelloClient trelloClient;
    private SimpleEmailService emailService;
    private AdminConfig adminConfig;
    private static final String SUBJECT = "Tasks: New Trello card";

    public TrelloService(TrelloClient trelloClient, SimpleEmailService emailService, AdminConfig adminConfig) {
        this.trelloClient = trelloClient;
        this.emailService = emailService;
        this.adminConfig = adminConfig;
    }

    public List<TrelloBoardDto> fetchTrelloBoards(){
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto){
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(card -> emailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "New card: "+ card.getName()+"has been created on your Trello account",
                null)));

        return newCard;
    }
}
