import { Row, Col, Container } from "react-bootstrap";
import HomeHeadder from "../panels/HomeHeadder";
import HomeFooter from "../panels/HomeFooter";
import NavBarPanel from "../panels/NavBarPanel";
import { useState } from "react";
import ProfilePanel from "../panels/ProfilePanel";
import HistoryPanel from "../panels/HistoryPanel";
import ModelPanel from "../panels/ModelPanel";
import { personResponse } from "../recoil/atoms";
import { useSetRecoilState } from "recoil";
import { Url } from "../healper/FullContactHealper";
const HomeContainer = (props) => {
  const [viewType, setViewType] = useState("profile");
  const [inputField, setInputField] = useState({
    service: "",
    phone: "",
    email: "",
    url: "",
  });
  const setPerson = useSetRecoilState(personResponse);
  const [showError, setShowError] = useState({ show: false, data: null });
  const onSubmitClickHandler = () => {
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        service: inputField.service,
        phone: inputField.phone,
        email: inputField.email,
        url: inputField.url,
      }),
    };
    fetch(Url.people, requestOptions).then((response) => {
      if (response.ok) {
        response.text().then((text) => {
          setPerson(JSON.parse(text));
        });
      } else {
        response.text().then((text) => {
          setShowError({ data: JSON.parse(text), show: true });
        });
      }
    });
  };
  const handleClose = () => {
    setShowError({ ...showError, show: false });
  };
  const onClearClick = () => {
    setInputField({ service: "", phone: "", email: "", url: "" });
    setPerson({});
  };
  return (
    <Container fluid className="vh-100 d-flex flex-column ">
      <Row className="justify-content-md-center headder primary-back-color">
        <Col sm={12}>
          <HomeHeadder />
        </Col>
      </Row>
      <Row className="justify-content-md-center h-100 ">
        <Col
          sm={2}
          className="d-flex justify-content-center primary-back-color"
        >
          <NavBarPanel viewType={viewType} setViewType={setViewType} />
        </Col>
        <Col sm={10}>
          {viewType === "profile" ? (
            <ProfilePanel
              inputField={inputField}
              setInputField={setInputField}
              onSubmitClickHandler={onSubmitClickHandler}
              onClearClick={onClearClick}
            />
          ) : (
            <HistoryPanel />
          )}
        </Col>
      </Row>
      <Row className="justify-content-md-center primary-back-color">
        <Col sm={4} className="d-flex justify-content-center">
          <HomeFooter />
        </Col>
      </Row>
      <ModelPanel show={showError} handleClose={handleClose} />
    </Container>
  );
};
export default HomeContainer;
