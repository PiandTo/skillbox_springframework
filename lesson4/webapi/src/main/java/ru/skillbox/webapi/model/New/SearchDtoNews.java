package ru.skillbox.webapi.model.New;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import ru.skillbox.webapi.model.User.SearchDtoUser;

@Getter
@Setter
public class SearchDtoNews {
    private String title;
    private String text;
    @JsonIgnore
    private SearchDtoUser user;
}
