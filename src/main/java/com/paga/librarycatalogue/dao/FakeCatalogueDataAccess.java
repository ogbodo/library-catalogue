package com.paga.librarycatalogue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.paga.librarycatalogue.model.Catalogue;

import org.springframework.stereotype.Repository;

/**
 * FakeCatalogueDataAccess
 */

@Repository("fakeDao")
public class FakeCatalogueDataAccess implements CatalogueDao {

    private static List<Catalogue> DB = new ArrayList<>();

    @Override
    public int insertCatalogue(UUID id, Catalogue catalogue) {
        DB.add(catalogue);
        return 1;
    }

}