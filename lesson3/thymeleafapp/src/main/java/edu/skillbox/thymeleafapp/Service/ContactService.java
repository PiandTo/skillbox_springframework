package edu.skillbox.thymeleafapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.skillbox.thymeleafapp.Contact.Contact;
import edu.skillbox.thymeleafapp.Contact.ContactDto.CreateContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.SearchContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.UpdateContactDto;
import edu.skillbox.thymeleafapp.Repository.ContactRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactService {

	private final ContactRepository contactRepository;
	private final ModelMapper model;

	public ArrayList<SearchContactDto> getContacts() {
		ArrayList<SearchContactDto> list = new ArrayList<SearchContactDto>();
		for (Contact c : contactRepository.findAll()) {
			list.add(model.map(c, SearchContactDto.class));
		}
		return list;
	}

	public SearchContactDto findByEmail(SearchContactDto searchContactDto) {
		return model.map(contactRepository.findByEmail(searchContactDto.getEmail()), SearchContactDto.class);
	}

	public SearchContactDto findById(String id) {
		return model.map(contactRepository.findById(id), SearchContactDto.class);
	}

	public SearchContactDto save(CreateContactDto contactDto) {
		return model.map(contactRepository.save(contactDto), SearchContactDto.class);
	}

	public void update(UpdateContactDto contactDto) {
		contactRepository.update(contactDto);
	}

	public void delete(String id) {
		contactRepository.delete(id);
	}
}
