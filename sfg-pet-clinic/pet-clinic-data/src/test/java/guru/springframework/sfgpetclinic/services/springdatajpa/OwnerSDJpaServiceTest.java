package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	public static final String LAST_NAME = "Denzinger";

	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void findByLastNameTest() {
		Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner denzinger = service.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME, denzinger.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void FindAllTest() {
		Set<Owner> returnOwners = new HashSet<>();
		returnOwners.add(Owner.builder().id(1L).build());
		returnOwners.add(Owner.builder().id(2L).build());
		when(ownerRepository.findAll()).thenReturn(returnOwners);
		Set<Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void findByIdTest() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void saveTest() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner = service.save(ownerToSave);
		
		assertNotNull(savedOwner);

	}

	@Test
	void deleteTest() {
		service.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void deleteByIdTest() {
		service.deleteById(1L);
		
		verify(ownerRepository).deleteById(anyLong());

	}

}
