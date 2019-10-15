package com.paga.librarycatalogue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.paga.librarycatalogue.dao.FakeCatalogueDataAccess;
import com.paga.librarycatalogue.model.Catalogue;
import com.paga.librarycatalogue.service.CatalogueService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryCatalogueApplicationTests {

	@Autowired
	private CatalogueService service;

	@MockBean
	private FakeCatalogueDataAccess repository;

	@Test
	public void getAllCatalogueTest() {
		// Create some dialogue objects
		Catalogue catalogue1 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1",
				"Joys of Cooking", "Simon Clark", "1995", "Cookbook");
		Catalogue catalogue2 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD2",
				"Black Gold", "Chima Adize", "2013", "Action Adventure");
		Catalogue catalogue3 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD3",
				"Natural Consumption", "Isaac Network", "1899", "Science");

		when(repository.selectAllCatalogue())
				.thenReturn(Stream.of(catalogue1, catalogue2, catalogue3).collect(Collectors.toList()));

		assertEquals(3, service.getAllCatalogue().size());
	}

	@Test
	public void addNewCatalogueTest() {
		// Create some dialogue objects
		Catalogue newCatalogue = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1",
				"I, Zombie", "Israel Izamov", "2011", "Science Fiction");

		when(repository.insertCatalogue(newCatalogue)).thenReturn(newCatalogue);

		assertEquals(newCatalogue, service.addCatalogue(newCatalogue));
	}

	@Test
	public void filterCatalogueTest() {
		// Create some dialogue objects
		Catalogue catalogue1 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1",
				"Joys of Cooking", "Simon Clark", "1995", "Cookbook");
		Catalogue catalogue2 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD2",
				"Black Gold", "Chima Adize", "2013", "Action Adventure");
		Catalogue catalogue3 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD3",
				"Natural Consumption", "Isaac Network", "1899", "Science");

		when(repository.filterCatalogue("Action Adventure"))
				.thenReturn(Stream.of(catalogue2).collect(Collectors.toList()));

		assertEquals(3, service.getAllCatalogue().size());
	}

}
