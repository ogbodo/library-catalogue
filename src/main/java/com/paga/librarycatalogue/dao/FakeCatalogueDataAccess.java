package com.paga.librarycatalogue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        int lastIndex = DB.size();
        lastIndex++;
        catalogue.setSerialNumber("LD" + lastIndex);
        DB.add(catalogue);
        return 1;
    }

    @Override
    public List<Catalogue> selectAllCatalogue() {
        return DB;
    }

    @Override
    public Optional<Catalogue> filterCatalogue(String criteria) {
        return DB.stream().filter(catalogue -> catalogue.isAMatch(criteria)).findAny();
    }

}