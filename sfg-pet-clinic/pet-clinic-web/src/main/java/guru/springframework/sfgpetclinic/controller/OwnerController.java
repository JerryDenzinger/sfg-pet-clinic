package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({ "/owner", "owner/index", "owner/index.html" })
	public String listOfOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "/owners/ownersindex";
	}
}
