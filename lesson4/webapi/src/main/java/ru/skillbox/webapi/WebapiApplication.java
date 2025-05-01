package ru.skillbox.webapi;

import java.util.UUID;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ru.skillbox.webapi.model.New.News;
import ru.skillbox.webapi.model.New.CreateNewsDto;
import ru.skillbox.webapi.model.User.User;
import ru.skillbox.webapi.model.User.CreateUserDto;
import ru.skillbox.webapi.repository.NewsRepository;
import ru.skillbox.webapi.repository.UserRepository;

@SpringBootApplication
public class WebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapiApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(UserRepository userRepository, NewsRepository newsRepository) {
		return args -> {
			// TODO Auto-generated method stub
			CreateUserDto user = new CreateUserDto();
			user.setName("Vasya");
			// User user1 = 

			CreateNewsDto news = new CreateNewsDto();
			news.setTitle("Title");
			news.setText("Text");

			// user.addNews(news);
			// newsRepository.save(news);
			// userRepository.save(user);
			// userRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	public ModelMapper mapper() {
		ModelMapper mapper = new ModelMapper();
		Converter<UUID, String> uuidConverter = new AbstractConverter<UUID, String>() {
			protected String convert(UUID source) {
				return source.toString();
			}

		};
		Converter<String, UUID> uuidToConverter = new AbstractConverter<String, UUID>() {
			protected UUID convert(String source) {
				return UUID.fromString(source);
			}

		};
		mapper.addConverter(uuidConverter);
		mapper.addConverter(uuidToConverter);
		return mapper;
	}

}
