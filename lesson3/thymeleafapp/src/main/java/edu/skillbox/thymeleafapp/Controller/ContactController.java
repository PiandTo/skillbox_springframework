package edu.skillbox.thymeleafapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.skillbox.thymeleafapp.Service.ContactService;
import jakarta.validation.Valid;
import edu.skillbox.thymeleafapp.Contact.Contact;
import edu.skillbox.thymeleafapp.Contact.ContactDto.CreateContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.SearchContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.UpdateContactDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {

	private final ContactService contactService;

	@GetMapping
	public String listContacts(Model model) {
		model.addAttribute("contacts", contactService.getContacts());
		return "contacts-list";
	}

	@GetMapping("/new")
	public String showAddForm(Model model) {
		// SearchContactDto contact = contactService.findByEmail((SearchContactDto)
		model.addAttribute("contact", new CreateContactDto());
		// model.addAttribute("contact", contact);
		return "contact-form";
	}

	@PostMapping("/new")
	public String addTask(@ModelAttribute("contact") @Valid CreateContactDto contact, BindingResult bindingResult,
			Model model) {
		contactService.save(contact);
		return "redirect:/contact";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") String id, Model model) {
		SearchContactDto searchContactDto = contactService.findById(id);
		model.addAttribute("contact", searchContactDto);
		model.addAttribute("mode", "edit");
		return "contact-form";
	}

	@PostMapping("/edit/{id}")
	public String updateTask(@PathVariable("id") String id, @ModelAttribute("contact") UpdateContactDto contact) {
		contactService.update(contact);
		return "redirect:/contact";
	}

	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") String id) {
		contactService.delete(id);
		return "redirect:/contact";
	}
}
