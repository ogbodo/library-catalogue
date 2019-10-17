import React, { useState, useEffect } from "react";
import axios from "axios";
import { Grid } from "semantic-ui-react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

//Components
import ListCatalogues from "./ListCatalogues";

function ManaCatalogue() {
  const [state, setState] = useState([]);

  //Fetch all catalogues
  useEffect(() => {
    loadCatalogues();
  }, []);

  function loadCatalogues() {
    axios
      .get("/catalogue")
      .then(catalogueResp => {
        const catalogues = catalogueResp.data;
        setState(catalogues);
      })
      .catch(error => {
        setState([]);
      });
  }

  return (
    <>
      <ToastContainer />
      <Grid>
        <Grid.Row>
          <Grid.Column width={3} style={{ textAlign: "left" }}></Grid.Column>
          <Grid.Column width={10}>
            <div style={{ padding: "10px 20px 10px 0px" }}>
              <ListCatalogues
                catalogueList={state}
                loadCatalogues={loadCatalogues}
              />
            </div>
          </Grid.Column>
          <Grid.Column width={3}></Grid.Column>
        </Grid.Row>
      </Grid>
    </>
  );
}

export default ManaCatalogue;
