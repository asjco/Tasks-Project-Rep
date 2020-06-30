package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    private TrelloClient trelloClient;

    public TrelloController(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        try {
            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

            trelloBoards.stream()
                    .filter(trelloBoardDto -> trelloBoardDto.getId() != null & trelloBoardDto.getName() != null)
                    .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Course"))
                    .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        } catch (BoardsNotFoundException e) {
            System.out.println("Boards not found" + e);
        }

    }
}
