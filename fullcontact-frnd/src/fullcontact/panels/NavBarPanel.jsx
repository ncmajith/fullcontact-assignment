const NavBarPanel = (props) => {
  const { viewType, setViewType } = props;
  const clickHandler = (type) => {
    setViewType(type);
  };
  return (
    <>
      <div>
        <ul>
          <li
            style={{
              color: viewType === "profile" ? "gray" : "white",
              cursor: "pointer",
              padding: 10,
            }}
            onClick={() => clickHandler("profile")}
          >
            Profile
          </li>
          <li
            style={{
              color: viewType === "history" ? "gray" : "white",
              cursor: "pointer",
              padding: 10,
            }}
            onClick={() => clickHandler("history")}
          >
            History
          </li>
        </ul>
      </div>
    </>
  );
};
export default NavBarPanel;
