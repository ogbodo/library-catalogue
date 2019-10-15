
package com.paga.librarycatalogue.dao;

import java.util.List;
import java.util.UUID;

import com.paga.librarycatalogue.model.Catalogue;

/**
 * CatalogueDao
 */
public interface CatalogueDao {

    // This allow us to insert a catalogue with a given id
    Catalogue addCatalogue(UUID id, Catalogue catalogue);

    // This allow us to insert a catalogue without an id. instead we generate it
    // ourself
    default Catalogue addCatalogue(Catalogue catalogue) {
        UUID id = UUID.randomUUID();
        catalogue.setId(id);
        return addCatalogue(id, catalogue);
    }

    List<Catalogue> selectAllCatalogue();

    List<Catalogue> filterCatalogue(String criteria);
}