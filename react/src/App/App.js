import { useState } from "react";
import Start from "./Utilities/Start";
import axios from "axios";
import Game from "./Game/Game";

function App() {
  const [gameActive, setGameActive] = useState(false);
  const [data, setData] = useState("");

  const startNewGame = async () => {
    const req = await axios.get("http://localhost:8080/new-game");
    setGameActive(true);
    setData(req.data);
  };

  return (
    <div>
      {gameActive ? (
        <Game initialData={data} />
      ) : (
        <Start onNewGame={startNewGame} />
      )}
    </div>
  );
}

export default App;
