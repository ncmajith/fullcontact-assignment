import FormPanel from "./FormPanel";
import ProfileInfoPanel from "./ProfileInfoPanel";

const ProfilePanel = (props) => {
  const {
    onSubmitClickHandler,
    inputField,
    setInputField,
    onClearClick,
  } = props;
  return (
    <div>
      <FormPanel
        inputField={inputField}
        setInputField={setInputField}
        onSubmitClickHandler={onSubmitClickHandler}
        onClearClick={onClearClick}
      />
      <ProfileInfoPanel />
    </div>
  );
};
export default ProfilePanel;
