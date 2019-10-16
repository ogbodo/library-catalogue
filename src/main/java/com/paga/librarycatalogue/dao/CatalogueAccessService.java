package com.paga.librarycatalogue.dao;

import java.util.List;
import java.util.UUID;

import com.paga.librarycatalogue.model.Catalogue;

import org.springframework.stereotype.Repository;

/**
 * CatalogueAccessService
 */
@Repository("postgres")
public class CatalogueAccessService implements CatalogueDao {

    @Override
    public Catalogue addCatalogue(UUID id, Catalogue catalogue) {
        return null;
    }

    @Override
    public List<Catalogue> selectAllCatalogue() {
        return null;
    }

    @Override
    public List<Catalogue> filterCatalogue(String criteria) {
        return null;
    }

}