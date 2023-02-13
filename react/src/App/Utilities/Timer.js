import "./Timer.css";
import { useState, useEffect } from "react";
import axios from "axios";
function Timer({ endGame }) {
  const [time, setTime] = useState(60);

  const timeEnded = async () => {
    const req = await axios.get(`http://localhost:8080/time-out`);
    endGame(req.data);
  };

  useEffect(() => {
    time > 0 && setTimeout(() => setTime(time - 1), 1000);
  }, [time]);

  if (time === 0) {
    timeEnded();
  }

  return (
    <div>
      <div className="timer">
        <span>{time}</span>
      </div>
    </div>
  );
}

export default Timer;
