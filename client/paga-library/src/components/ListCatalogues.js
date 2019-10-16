import React, { useState, useEffect } from "react";
import axios from "axios";

import { Table, Input, Card, Button } from "semantic-ui-react";

function ListCatalogues({ catalogueList }) {
  const [state, setState] = useState({
    isLoading: false,
    filterText: "",
    catalogueList
  });

  useEffect(() => {
    if (state.isLoading) {
      //Filter catalogue
      axios.get(`/catalogue/${state.filterText}`).then(catalogueResp => {
        const catalogues = catalogueResp.data.data;
        console.log(catalogues);
        setState(oldState => {
          return { ...oldState, isLoading: false, catalogueList: catalogues };
        });
      });
    }
  }, [state.filterText, state.isLoading]);

  function onChange(_e, { value }) {
    setState(oldState => {
      return { ...oldState, filterText: value.trim() };
    });
  }

  function onFilterCatalogue(e, props) {
    if (e.key === "Enter") {
      setState(oldState => {
        return { ...oldState, isLoading: true };
      });
    } else if (props) {
      if (props.name === "searchButton") {
        setState(oldState => {
          return { ...oldState, isLoading: true };
        });
      }
    }
  }

  return (
    <>
      <div style={{ color: "#e94d1c", float: "right", paddingBottom: 10 }}>
        <Input
          placeholder={"Filter..."}
          style={{ color: "#e94d1c" }}
          onChange={onChange}
          value={state.filterText}
          onKeyDown={onFilterCatalogue}
          name="searchInput"
        />
        <Button
          name="searchButton"
          loading={state.isLoading}
          icon="search"
          primary
          onClick={onFilterCatalogue}
        />
      </div>
      <Table padded>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>SN</Table.HeaderCell>
            <Table.HeaderCell>Title</Table.HeaderCell>
            <Table.HeaderCell>Author</Table.HeaderCell>
            <Table.HeaderCell>Year of Release</Table.HeaderCell>
            <Table.HeaderCell>Genre</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {state.catalogueList.length > 0
            ? state.catalogueList.map(catalogue => {
                return (
                  <PopulateTable catalogue={catalogue} key={catalogue._id} />
                );
              })
            : null}
        </Table.Body>
      </Table>
      {state.catalogueList.length === 0 && (
        <Card style={{ color: "#e94d1c", fontWeight: "bold" }}>
          No data to display!
        </Card>
      )}
    </>
  );

  function PopulateTable({ catalogue }) {
    const { serialNumber, title, author, releaseYear, genre } = catalogue;

    return (
      <Table.Row style={{ color: "grey" }}>
        <Table.Cell>{serialNumber}</Table.Cell>
        <Table.Cell>{title}</Table.Cell>
        <Table.Cell>{author}</Table.Cell>
        <Table.Cell>{releaseYear}</Table.Cell>
        <Table.Cell>{genre}</Table.Cell>
      </Table.Row>
    );
  }
}

export default ListCatalogues;
