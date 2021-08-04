import { useEffect, useState } from "react";
import { Url } from "../healper/FullContactHealper";
import { Row, Col, Table } from "react-bootstrap";

const HistoryPanel = () => {
  const [history, setHistory] = useState({});

  useEffect(() => {
    fetch(Url.history)
      .then((response) => response.json())
      .then((response) => {
        setHistory(response);
      });
  }, []);
  const searchHistory = () => {
    return (
      <Table striped bordered hover height={"20px"}>
        <thead>
          <tr>
            <th>Email</th>
            <th>Phone</th>
            <th>Service</th>
            <th>Url</th>
            <th>Time</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {history.map((his) => (
            <tr>
              <td>{his.email}</td>
              <td>{his.phone}</td>
              <td>{his.service}</td>
              <td>{his.url}</td>
              <td>{his.created}</td>
              <td>{his.success ? "True" : "False"}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    );
  };
  return (
    <>
      <Row>
        <Col>
          {history && history.length > 0 ? searchHistory() : "No History found"}
        </Col>
      </Row>
    </>
  );
};
export default HistoryPanel;
