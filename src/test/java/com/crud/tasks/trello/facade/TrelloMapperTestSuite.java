package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("list test id", "list test name", true);
        List<TrelloListDto> trelloListDtoSuite = new ArrayList<>();
        trelloListDtoSuite.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test id", "test name", trelloListDtoSuite);
        List<TrelloBoardDto> trelloBoardDtoSuite = new ArrayList<>();
        trelloBoardDtoSuite.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoSuite);

        //Then
        Assert.assertEquals(1, trelloBoards.size());
        Assert.assertEquals("test name", trelloBoards.get(0).getName());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList("list test id", "list test name", true);
        List<TrelloList> trelloListSuite = new ArrayList<>();
        trelloListSuite.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("test id", "test name", trelloListSuite);
        List<TrelloBoard> trelloBoardSuite = new ArrayList<>();
        trelloBoardSuite.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoardSuite);

        //Then
        Assert.assertEquals(1, trelloBoardsDto.size());
        Assert.assertEquals("test name", trelloBoardsDto.get(0).getName());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("list test id", "list test name", true);
        List<TrelloListDto> trelloListDtoSuite = new ArrayList<>();
        trelloListDtoSuite.add(trelloListDto);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDtoSuite);

        //Then
        Assert.assertEquals(1, trelloList.size());
        Assert.assertEquals("list test name", trelloList.get(0).getName());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("list test id", "list test name", true);
        List<TrelloList> trelloListSuite = new ArrayList<>();
        trelloListSuite.add(trelloList);

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloListSuite);

        //Then
        Assert.assertEquals(1, trelloListDto.size());
        Assert.assertEquals("list test name", trelloListDto.get(0).getName());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test card name", "test card description", "test pos", "test list id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals("test pos", trelloCardDto.getPos());
        Assert.assertEquals("test card name", trelloCardDto.getName());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test card name", "test card description", "test pos", "test list id");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals("test pos", trelloCard.getPos());
        Assert.assertEquals("test card name", trelloCard.getName());
    }

}
