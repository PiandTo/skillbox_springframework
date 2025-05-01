package ru.skillbox.webapi.model.New;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewsDto {
    private String title;
    private String text;
}
