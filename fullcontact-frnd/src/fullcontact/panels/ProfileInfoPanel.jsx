import { personResponse } from "../recoil/atoms";
import { useRecoilValue } from "recoil";
import { Card, Row, Col, Table } from "react-bootstrap";
import { listOfEmails, phones } from "../healper/FullContactHealper";

const ProfileInfoPanel = () => {
  // The example i got from doc didnt have email and phone list
  // Hence using a static email and phone list
  const profileCard = () => {
    return (
      <Card style={{ width: "15rem" }}>
        {avatar && <Card.Img variant="top" src={avatar} />}
        <Card.Body>
          {details.name && <Card.Title>{details.name.full}</Card.Title>}
          {title && organization && (
            <Card.Subtitle className="mb-2 text-muted">
              {`${title},${organization}`}
            </Card.Subtitle>
          )}
        </Card.Body>
      </Card>
    );
  };
  const mailCard = () => {
    return (
      <Card style={{ width: "15rem" }}>
        <Card.Body>
          <Card.Title>List of mails</Card.Title>
          <Table striped bordered hover>
            <tbody>
              {listOfEmails.map((mails) => (
                <tr>
                  <td>{mails.mail}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Card.Body>
      </Card>
    );
  };

  const phoneCard = () => {
    return (
      <Card style={{ width: "15rem" }}>
        <Card.Body>
          <Card.Title>List of phone numbers</Card.Title>
          <Table striped bordered hover>
            <tbody>
              {phones.map((phone) => (
                <tr>
                  <td>{phone.phone}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Card.Body>
      </Card>
    );
  };
  const profileListCard = (details) => {
    const { profiles } = details;
    return (
      <Table hover>
        <tbody>
          {profiles && profiles.twitter && profiles.twitter.url && (
            <tr>
              <td>
                <a href={profiles.twitter.url} target="_blank">
                  {profiles.twitter.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.linkedin && profiles.linkedin.url && (
            <tr>
              <td>
                <a href={profiles.linkedin.url} target="_blank">
                  {profiles.linkedin.service}
                </a>
              </td>
            </tr>
          )}
          {profiles &&
            profiles.linkedincompany &&
            profiles.linkedincompany.url && (
              <tr>
                <td>
                  <a href={profiles.linkedincompany.url} target="_blank">
                    {profiles.linkedincompany.service}
                  </a>
                </td>
              </tr>
            )}
          {profiles && profiles.klout && profiles.klout.url && (
            <tr>
              <td>
                <a href={profiles.klout.url} target="_blank">
                  {profiles.klout.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.youtube && profiles.youtube.url && (
            <tr>
              <td>
                <a href={profiles.youtube.url} target="_blank">
                  {profiles.youtube.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.angellist && profiles.angellist.url && (
            <tr>
              <td>
                <a href={profiles.angellist.url} target="_blank">
                  {profiles.angellist.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.owler && profiles.owler.url && (
            <tr>
              <td>
                <a href={profiles.owler.url} target="_blank">
                  {profiles.owler.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.pinterest && profiles.pinterest.url && (
            <tr>
              <td>
                <a href={profiles.pinterest.url} target="_blank">
                  {profiles.pinterest.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.github && profiles.github.url && (
            <tr>
              <td>
                <a href={profiles.github.url} target="_blank">
                  {profiles.github.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.lastfm && profiles.lastfm.url && (
            <tr>
              <td>
                <a href={profiles.lastfm.url} target="_blank">
                  {profiles.lastfm.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.flickr && profiles.flickr.url && (
            <tr>
              <td>
                <a href={profiles.flickr.url} target="_blank">
                  {profiles.flickr.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.hackernews && profiles.hackernews.url && (
            <tr>
              <td>
                <a href={profiles.hackernews.url} target="_blank">
                  {profiles.hackernews.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.foursquare && profiles.foursquare.url && (
            <tr>
              <td>
                <a href={profiles.foursquare.url} target="_blank">
                  {profiles.foursquare.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.medium && profiles.medium.url && (
            <tr>
              <td>
                <a href={profiles.medium.url} target="_blank">
                  {profiles.medium.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.keybase && profiles.keybase.url && (
            <tr>
              <td>
                <a href={profiles.keybase.url} target="_blank">
                  {profiles.keybase.service}
                </a>
              </td>
            </tr>
          )}
          {profiles && profiles.aboutme && profiles.aboutme.url && (
            <tr>
              <td>
                <a href={profiles.aboutme.url} target="_blank">
                  {profiles.aboutme.service}
                </a>
              </td>
            </tr>
          )}
        </tbody>
      </Table>
    );
  };
  const person = useRecoilValue(personResponse);
  const { avatar, details, title, organization } = person;
  return (
    <>
      {details && (
        <Row>
          <Col>{profileCard()}</Col>
          <Col>{mailCard()}</Col>
          <Col>{phoneCard()}</Col>
          <Col>{profileListCard(details)}</Col>
        </Row>
      )}
    </>
  );
};
export default ProfileInfoPanel;
