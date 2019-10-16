import React, { useState, useEffect } from "react";
import axios from "axios";
import { Grid } from "semantic-ui-react";

//Components
import ListCatalogues from "./ListCatalogues";

function ManaCatalogue() {
  const [state, setState] = useState([]);

  //Fetch all catalogues
  useEffect(() => {
    axios.get("/catalogue").then(catalogueResp => {
      const catalogues = catalogueResp.data;
      setState(catalogues);
    });
  }, []);

  return (
    <Grid>
      <Grid.Row>
        <Grid.Column width={3} style={{ textAlign: "left" }}></Grid.Column>
        <Grid.Column width={10}>
          <div style={{ padding: "10px 20px 10px 0px" }}>
            <ListCatalogues catalogueList={state} />
          </div>
        </Grid.Column>
        <Grid.Column width={3}></Grid.Column>
      </Grid.Row>
    </Grid>
  );
}

export default ManaCatalogue;
