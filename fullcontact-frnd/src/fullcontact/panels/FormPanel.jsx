import { Button, Row, Col, Form } from "react-bootstrap";
const FormPanel = (props) => {
  const {
    onSubmitClickHandler,
    inputField,
    setInputField,
    onClearClick,
  } = props;
  const inputsHandler = (e) => {
    setInputField({ ...inputField, [e.target.name]: e.target.value });
  };
  return (
    <Form>
      <Row style={{ marginTop: "20px", marginLeft: "20px" }}>
        <Col sm={2}>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              name="email"
              placeholder="Enter email"
              value={inputField.email}
              onChange={inputsHandler}
            />
          </Form.Group>
        </Col>
        <Col sm={2}>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Phone Number</Form.Label>
            <Form.Control
              type="text"
              name="phone"
              placeholder="Phone Number"
              value={inputField.phone}
              onChange={inputsHandler}
            />
          </Form.Group>
        </Col>
        <Col sm={2}>
          <Form.Group className="mb-3" controlId="formBasicCheckbox">
            <Form.Label>Social Media Service</Form.Label>
            <Form.Control
              type="text"
              placeholder="Service"
              value={inputField.service}
              name="service"
              onChange={inputsHandler}
            />
            <Form.Text className="text-muted">Eg, linkedin</Form.Text>
          </Form.Group>
        </Col>
        <Col sm={2}>
          <Form.Group className="mb-3" controlId="formBasicCheckbox">
            <Form.Label>Service Url</Form.Label>
            <Form.Control
              type="text"
              placeholder="URL"
              value={inputField.url}
              name="url"
              onChange={inputsHandler}
            />
          </Form.Group>
        </Col>
        <Col sm={2} className="d-flex align-items-center ">
          <Button variant="primary" onClick={onSubmitClickHandler}>
            Search
          </Button>
          <Button
            variant="primary"
            style={{ marginLeft: "10px" }}
            onClick={onClearClick}
          >
            Clear
          </Button>
        </Col>
      </Row>
    </Form>
  );
};
export default FormPanel;
