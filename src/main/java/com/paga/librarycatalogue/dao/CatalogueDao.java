
package com.paga.librarycatalogue.dao;

import java.util.UUID;

import com.paga.librarycatalogue.model.Catalogue;

/**
 * CatalogueDao
 */
public interface CatalogueDao {

    // This allow us to insert a catalogue with a given id
    int insertCatalogue(UUID id, Catalogue catalogue);

    // This allow us to insert a catalogue without an id. instead we generate it
    // ourself
    default int insertCatalogue(Catalogue catalogue) {
        UUID id = UUID.randomUUID();
        return insertCatalogue(id, catalogue);
    }
}