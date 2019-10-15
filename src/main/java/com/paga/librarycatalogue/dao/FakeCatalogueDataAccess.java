package com.paga.librarycatalogue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.paga.librarycatalogue.model.Catalogue;

import org.springframework.stereotype.Repository;

/**
 * FakeCatalogueDataAccess
 */

@Repository("fakeDao")
public class FakeCatalogueDataAccess implements CatalogueDao {

    private static List<Catalogue> DB = new ArrayList<>();

    @Override
    public Catalogue addCatalogue(UUID id, Catalogue catalogue) {
        int lastIndex = DB.size();
        lastIndex++;
        catalogue.setSerialNumber("LD" + lastIndex);
        DB.add(catalogue);
        return catalogue;
    }

    @Override
    public List<Catalogue> selectAllCatalogue() {
        return DB;
    }

    @Override
    public List<Catalogue> filterCatalogue(String criteria) {
        return DB.stream().filter(catalogue -> catalogue.isAMatch(criteria)).collect(Collectors.toList());
    }

}