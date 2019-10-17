package com.paga.librarycatalogue.service;

import java.util.List;
import java.util.Optional;

import com.paga.librarycatalogue.dao.CatalogueDao;
import com.paga.librarycatalogue.model.Catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * CatalogueService
 */

@Service
public class CatalogueService {

    // get reference to the catalogue data access object
    private final CatalogueDao catalogueDao;

    @Autowired
    public CatalogueService(@Qualifier("arrayList") CatalogueDao catalogueDao) {
        this.catalogueDao = catalogueDao;
    }

    // This is the method responsible for creating new catalogue
    public Catalogue addCatalogue(Catalogue catalogue) {
        return catalogueDao.addCatalogue(catalogue);
    }

    public List<Catalogue> getAllCatalogue() {
        return catalogueDao.selectAllCatalogue();
    }

    public List<Catalogue> filterCatalogue(String criteria) {
        return catalogueDao.filterCatalogue(criteria);
    }
}