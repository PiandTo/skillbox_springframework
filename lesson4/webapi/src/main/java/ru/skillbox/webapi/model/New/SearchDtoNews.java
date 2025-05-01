package ru.skillbox.webapi.model.New;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.webapi.model.User.SearchDtoUser;

@Getter
@Setter
public class SearchDtoNews {
    private String title;
    private String text;
    private SearchDtoUser user;
}
