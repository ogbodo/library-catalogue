package com.paga.librarycatalogue.api;

import com.paga.librarycatalogue.model.Catalogue;
import com.paga.librarycatalogue.service.CatalogueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CatalogueControllers
 */
@RequestMapping("api/v1/catalogue")
@RestController
public class CatalogueControllers {

    // Get reference to the catalogue service object
    private final CatalogueService catalogueService;

    // Initialize catalogue service object inside the constructor.
    @Autowired
    public CatalogueControllers(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    // Method that adds a catalogue
    @PostMapping
    public void addCatalogue(@RequestBody Catalogue catalogue) {
        catalogueService.addCatalogue(catalogue);

    }

}