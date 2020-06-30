package com.crud.tasks.trello.client;

import com.crud.tasks.controller.BoardsNotFoundException;
import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.username}")
    private String trelloUsername;

    private RestTemplate restTemplate;

    public TrelloClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private URI buildUrl() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name, id").build().encode().toUri();
    }

    public List<TrelloBoardDto> getTrelloBoards() throws BoardsNotFoundException {

        TrelloBoardDto[] boardResponse = restTemplate.getForObject(buildUrl(), TrelloBoardDto[].class);

        return Optional.of(Arrays.asList(boardResponse)).orElseThrow(BoardsNotFoundException::new);
    }

}
