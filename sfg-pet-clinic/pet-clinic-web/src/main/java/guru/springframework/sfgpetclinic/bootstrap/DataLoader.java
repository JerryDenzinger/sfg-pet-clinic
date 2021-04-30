package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;

	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes........");

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Sesamee Street");
		owner1.setCity("Wonderland");
		owner1.setTelephone("123456789");
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Bolillo");
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("321 Sesamee Street");
		owner2.setCity("Tomorrowland");
		owner2.setTelephone("987654321");
		Pet fionaPet = new Pet();
		fionaPet.setPetType(savedCatPetType);
		fionaPet.setOwner(owner2);
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setName("Angelina");
		owner2.getPets().add(fionaPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners........");

		Vet vet1 = new Vet();
		vet1.setFirstName("Axel");
		vet1.setLastName("Rose");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Dr.");
		vet2.setLastName("Dolitllle");

		vetService.save(vet2);

		System.out.println("Loaded Vets........");

	}

}
