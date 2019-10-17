import React from "react";
import "./App.css";
import "semantic-ui-css/semantic.min.css"; //Import styles for semantic UI

//Components
import ManageCatalogue from "./components/ManageCatalogue";

function App() {
  return (
    <div className="App">
      <div>
        <ManageCatalogue />
      </div>
    </div>
  );
}

export default App;
