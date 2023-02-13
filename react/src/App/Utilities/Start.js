import axios from "axios";
function Start({ onNewGame }) {
  return (
    <div className="row">
      <button className="btn btn-primary" onClick={onNewGame}>
        Start
      </button>
    </div>
  );
}

export default Start;
