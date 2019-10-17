package com.paga.librarycatalogue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.paga.librarycatalogue.dao.InMemoryCatalogueDataAccess;
import com.paga.librarycatalogue.model.Catalogue;
import com.paga.librarycatalogue.service.CatalogueService;

import org.junit.Before;
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
	private InMemoryCatalogueDataAccess repository;

	private Catalogue catalogue1;
	private Catalogue catalogue2;
	private Catalogue catalogue3;
	private Catalogue catalogue4;

	@Before
	public void initializer() {
		// Create some dialogue objects
		catalogue1 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1", "Joys of Cooking",
				"Simon Clark", "1995", "Cookbook");
		catalogue2 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD2", "Black Gold",
				"Chima Adize", "2013", "Action Adventure");
		catalogue3 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD3",
				"Natural Consumption", "Isaac Network", "1899", "Science");
		catalogue4 = new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1", "I, Zombie",
				"Israel Izamov", "2011", "Science Fiction");

	}

	@Test
	public void getAllCatalogueTest() {
		// using Mockito method to Mock the data to be returned here
		when(repository.selectAllCatalogue())
				.thenReturn(Stream.of(catalogue1, catalogue2, catalogue3).collect(Collectors.toList()));

		assertEquals(3, service.getAllCatalogue().size());
	}

	@Test
	public void addNewCatalogueTest() {

		// using Mockito method to Mock the data to be returned here
		when(repository.addCatalogue(catalogue4)).thenReturn(catalogue4);

		assertEquals(catalogue4, service.addCatalogue(catalogue4));
	}

	@Test
	public void filterCatalogueTest() {

		repository.addCatalogue(catalogue1);
		repository.addCatalogue(catalogue2);
		repository.addCatalogue(catalogue3);
		repository.addCatalogue(catalogue4);

		// using Mockito method to Mock the data to be returned here
		when(repository.filterCatalogue("Action Adventure"))
				.thenReturn(Stream.of(catalogue2).collect(Collectors.toList()));

		assertEquals(1, service.filterCatalogue("Action Adventure").size());

		// using Mockito method to Mock another data to be returned
		when(repository.filterCatalogue("Science"))
				.thenReturn(Stream.of(catalogue2, catalogue4).collect(Collectors.toList()));

		assertEquals(2, service.filterCatalogue("Science").size());
	}

}
