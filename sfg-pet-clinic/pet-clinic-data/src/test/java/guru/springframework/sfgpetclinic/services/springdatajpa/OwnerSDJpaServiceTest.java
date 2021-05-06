package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	OwnerSDJpaService service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void sindByLastNameTest() {

	}

	@Test
	void FindAllTest() {

	}

	@Test
	void findByIdTest() {

	}

	@Test
	void saveTest() {

	}

	@Test
	void deleteTest() {

	}

	@Test
	void deleteByIdTest() {

	}

}
