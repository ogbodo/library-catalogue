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
        return List.of(new Catalogue(UUID.fromString("f44af12e-322d-448a-8fd2-6fca1c3d6814"), "LD1", "Joys of Cooking",
                "Simon Clark", "1995", "Cookbook"));
    }

    @Override
    public List<Catalogue> filterCatalogue(String criteria) {
        return null;
    }

}