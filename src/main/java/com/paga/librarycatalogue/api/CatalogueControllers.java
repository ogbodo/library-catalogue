package com.paga.librarycatalogue.api;

import com.paga.librarycatalogue.model.Catalogue;
import com.paga.librarycatalogue.service.CatalogueService;

/**
 * CatalogueControllers
 */
public class CatalogueControllers {

    // Get reference to the catalogue service object
    private final CatalogueService catalogueService;

    // Initialize catalogue service object inside the constructor.
    public CatalogueControllers(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    // Method that adds a catalogue
    public void addCatalogue(Catalogue catalogue) {
        catalogueService.addCatalogue(catalogue);

    }

}