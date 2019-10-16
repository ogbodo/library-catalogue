import React, { useState, useEffect } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import { Form } from "semantic-ui-react";

function NewCatalogueForm({ onSubmitHandler }) {
  const [state, setState] = useState({
    title: "",
    author: "",
    releaseYear: "",
    genre: ""
  });

  function handleChange(e, { name, value }) {
    setState(oldState => {
      return { ...oldState, [name]: value };
    });
  }

  function PaymentDate() {
    return (
      <DatePicker
        dateFormat="dd/MM/yyyy"
        placeholderText="Year of Release"
        selected={state.releaseYear}
        onChange={date =>
          setState(oldState => {
            return { ...oldState, releaseYear: date };
          })
        }
      />
    );
  }
  return (
    <Form>
      <Form.Input
        fluid
        placeholder="Title"
        name="title"
        onChange={handleChange}
      />
      <Form.Input
        fluid
        placeholder="Author"
        name="author"
        onChange={handleChange}
      />
      <Form.Input
        fluid
        placeholder="Genre"
        name="genre"
        onChange={handleChange}
      />
      <PaymentDate />
    </Form>
  );
}

export default NewCatalogueForm;
