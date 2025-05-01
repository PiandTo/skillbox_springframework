package ru.skillbox.webapi.model.User;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.webapi.model.New.CreateNewsDto;

@Getter
@Setter
public class SearchDtoUser {
    String id;
    String name;
    ArrayList<CreateNewsDto> newsArray;
}
