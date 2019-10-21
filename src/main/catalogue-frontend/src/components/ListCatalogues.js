import React, { useState, useEffect, useRef } from "react";
import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import {
  Table,
  Input,
  Card,
  Button,
  Icon,
  Modal,
  Header,
  Form
} from "semantic-ui-react";
import { toast } from "react-toastify";

function ListCatalogues({ catalogueList, loadCatalogues }) {
  const [openState, setOpenState] = useState(false);
  const [submitState, setSubmitState] = useState(false);
  const [state, setState] = useState({
    isLoading: false,
    filterText: "",
    list: []
  });

  const catalogueStateRef = useRef({});

  function toggleOpenState() {
    setOpenState(oldState => !oldState);
  }

  useEffect(() => {
    setState(oldState => {
      return { ...oldState, list: catalogueList };
    });
  }, [catalogueList]);

  //Filter catalogue
  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/v1/catalogue/${state.filterText}`)
      .then(catalogueResp => {
        const catalogues = catalogueResp.data;
        setState(oldState => {
          return { ...oldState, isLoading: false, list: catalogues };
        });
      })
      .catch(error => {
        setState(oldState => {
          return { ...oldState, isLoading: false };
        });
      });
  }, [state.filterText, state.isLoading]);

  function onChange(_e, { value }) {
    setState(oldState => {
      return { ...oldState, filterText: value };
    });
  }

  function onFilterCatalogue() {
    setState(oldState => {
      return { ...oldState, isLoading: true };
    });
  }

  function NewCatalogueForm() {
    const [state, setState] = useState({
      title: "",
      author: "",
      releaseYear: "",
      genre: ""
    });

    useEffect(() => {
      catalogueStateRef.current = state;
    }, [state]);

    function handleChange(e, { name, value }) {
      setState(oldState => {
        return { ...oldState, [name]: value };
      });
    }

    function DatePickerComponent() {
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
        <DatePickerComponent />
      </Form>
    );
  }

  //Create new catalogue
  function createCatalogue() {
    const { status, message } = doValidation(catalogueStateRef.current);
    if (status) {
      setSubmitState(true);

      axios
        .post(
          "http://localhost:8080/api/v1/catalogue",
          catalogueStateRef.current
        )
        .then(catalogueResp => {
          toast.success("Catalogue was created successfully");
          setSubmitState(false);
        })
        .catch(error => {
          setSubmitState(false);
        });
    } else {
      toast.error(message);
    }
  }

  return (
    <div style={{ paddingTop: 50 }}>
      <div style={{ float: "left", paddingBottom: 10 }}>
        <Modal
          trigger={
            <Button
              primary
              style={{ backgroundColor: "green" }}
              onClick={toggleOpenState}
            >
              <Icon name="plus" />
              Create New Catalogue
            </Button>
          }
          open={openState}
          onClose={toggleOpenState}
          basic
          size="small"
          closeIcon
        >
          <Header icon="plus" content="Please Enter The catalogue Details" />
          <Modal.Content>
            <NewCatalogueForm />
          </Modal.Content>

          <Modal.Actions>
            <Button
              primary
              style={{ backgroundColor: "green" }}
              onClick={() => createCatalogue(true)}
              loading={submitState}
            >
              <Icon name="check" /> Ok, Submit
            </Button>
          </Modal.Actions>
        </Modal>
      </div>

      <div style={{ float: "right", paddingBottom: 10 }}>
        <Button
          name="refresh"
          icon="refresh"
          primary
          style={{ backgroundColor: "green" }}
          onClick={() => {
            setState(oldState => {
              return { ...oldState, filterText: "" };
            });
            loadCatalogues();
          }}
          loading={submitState}
        />
      </div>
      <div
        style={{
          color: "#e94d1c",
          float: "right",
          paddingBottom: 10,
          paddingLeft: 300
        }}
      >
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
          {state.list.length > 0
            ? state.list.map(catalogue => {
                return (
                  <PopulateTable catalogue={catalogue} key={catalogue.id} />
                );
              })
            : null}
        </Table.Body>
      </Table>
      {state.list.length === 0 && (
        <Card style={{ color: "#e94d1c", fontWeight: "bold" }}>
          No data to display!
        </Card>
      )}
    </div>
  );

  function PopulateTable({ catalogue }) {
    const { serialNumber, title, author, releaseYear, genre } = catalogue;

    return (
      <Table.Row style={{ color: "grey" }}>
        <Table.Cell>{serialNumber}</Table.Cell>
        <Table.Cell>{title}</Table.Cell>
        <Table.Cell>{author}</Table.Cell>
        <Table.Cell>{new Date(releaseYear).getFullYear()}</Table.Cell>
        <Table.Cell>{genre}</Table.Cell>
      </Table.Row>
    );
  }
}

function doValidation(state) {
  const { title, author, releaseYear, genre } = state;

  if (!title) {
    return { message: "Please Enter Title.", status: false };
  }
  if (!author) {
    return { message: "Please Enter Author.", status: false };
  }
  if (!genre) {
    return { message: "Please Enter Genre.", status: false };
  }
  if (!releaseYear) {
    return { message: "Please Enter Release Year.", status: false };
  }

  return {
    status: true
  };
}
export default ListCatalogues;
