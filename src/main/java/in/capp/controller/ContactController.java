package in.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.capp.command.ContactCommand;
import in.capp.domain.Contact;
import in.capp.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping("/contact_form")
	public String contactForm(Model m) {
		ContactCommand cmd = new ContactCommand();
		m.addAttribute("command", cmd);
		return "contact_form"; // JSP Page

	}

	@RequestMapping("/contact_save")
	public String contactSave(@ModelAttribute("command") ContactCommand cmd, Model m, HttpSession session) {
		Integer contactId = (Integer) session.getAttribute("contactId");
		if (contactId == null) {
			try {
				Contact contact = cmd.getContact();
				contact.setUserId((Integer) session.getAttribute("userId"));
				contactService.save(contact);
				return "redirect:clist?act=sv";
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to Save Contact");
			}

			return "contact_form";
		} else {
			try {
				Contact contact = cmd.getContact();
				contact.setUserId((Integer) session.getAttribute("userId"));
				contact.setContactId(contactId);
				cmd.setContact(contact);
				Contact contac = cmd.getContact();
				contactService.update(contac);
				session.removeAttribute("contactId");
				return "redirect:clist?act=ed";
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to Edit Contact");
				return "contact_form";
			}
		}

	}

	@RequestMapping("/clist")
	public String contactList(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.UserContacts(userId));
		return "clist"; // JSP Page
	}

	@RequestMapping("/delete_contact")
	public String deletecontact(@RequestParam("cid") Integer contactId) {
		contactService.delete(contactId);
		return "redirect:clist?act=del"; // JSP Page
	}

	@RequestMapping("/edit_contact")
	public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
		session.setAttribute("contactId", contactId);
		Contact contact = contactService.findbyId(contactId);
		ContactCommand cmd = new ContactCommand();
		cmd.setContact(contact);
		m.addAttribute("command", cmd);

		return "contact_form";
	}

	@RequestMapping("/contact_search")
	public String searchContact(@RequestParam("freetext") String freetext, HttpSession session, Model m) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("contactList", contactService.SearchUserContact(userId, freetext));
		 return"clist";
	}
	
	@RequestMapping("/bulk_delete")
	public String bulkdelete(@RequestParam("cid") Integer[] contactIds, Model m) {
		contactService.delete(contactIds);
		 return"redirect:clist?act=del";
	}
}
