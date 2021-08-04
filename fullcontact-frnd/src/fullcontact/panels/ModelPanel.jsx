import { Modal, Button } from "react-bootstrap";

const ModelPanel = (props) => {
  const { show, handleClose } = props;
  const errorData =
    show.data &&
    show.data
      .map((error) => error.errorDescription)
      .reduce((prv, current) => `${prv}, ${current}`);
  return (
    <Modal show={show.show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Error Occured</Modal.Title>
      </Modal.Header>
      <Modal.Body>{errorData}</Modal.Body>
      <Modal.Footer>
        <Button variant="primary" onClick={handleClose}>
          OK
        </Button>
      </Modal.Footer>
    </Modal>
  );
};
export default ModelPanel;
