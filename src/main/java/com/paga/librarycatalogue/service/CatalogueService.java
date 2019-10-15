package com.paga.librarycatalogue.service;

import com.paga.librarycatalogue.dao.CatalogueDao;
import com.paga.librarycatalogue.model.Catalogue;

import org.springframework.stereotype.Service;

/**
 * CatalogueService
 */

@Service
public class CatalogueService {

    // get reference to the catalogue data access object
    private final CatalogueDao catalogueDao;

    public CatalogueService(CatalogueDao catalogueDao) {
        this.catalogueDao = catalogueDao;
    }

    // This is the method responsible for creating new catalogue
    public int addCatalogue(Catalogue catalogue) {
        return catalogueDao.insertCatalogue(catalogue);
    }

}