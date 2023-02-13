import Answer from "./Answer/Answer";
import QuestionImage from "./Question/QuestionImage";
import QuestionText from "./Question/QuestionText";
import Score from "../Utilities/Score";
import Timer from "../Utilities/Timer";
import { useState } from "react";

function Game({ initialData }) {
  const [data, setData] = useState(initialData);
  const [gameActive, setGameActive] = useState(true);

  const nextQuestion = (nextQuestionData) => {
    nextQuestionData.round > 0
      ? setData(nextQuestionData)
      : endGame(nextQuestionData.score);
  };

  const endGame = () => {
    setGameActive(false);
  };
  return (
    <div>
      {gameActive ? (
        <div>
          <QuestionText questionText={data.currentQuestion.question} />
          <div className="row">
            <div className="col-3 d-flex justify-content-center align-items-center">
              <Timer endGame={nextQuestion} />
            </div>
            <div className="col-6">
              <QuestionImage imgUrl={data.currentQuestion.imageUrl} />
            </div>
            <div className="col-3 d-flex justify-content-center align-items-center">
              <Score score={data.score} />
            </div>
          </div>
          <div className="row">
            <Answer
              colour="btn-primary"
              answerText={data.currentQuestion.answerOptions[0]}
              nextQuestion={nextQuestion}
            ></Answer>
            <Answer
              colour="btn-secondary"
              answerText={data.currentQuestion.answerOptions[1]}
              nextQuestion={nextQuestion}
            ></Answer>
            <Answer
              colour="btn-warning"
              answerText={data.currentQuestion.answerOptions[2]}
              nextQuestion={nextQuestion}
            ></Answer>
            <Answer
              colour="btn-danger"
              answerText={data.currentQuestion.answerOptions[3]}
              nextQuestion={nextQuestion}
            ></Answer>
          </div>
        </div>
      ) : (
        <Score score={data.score} final={true} />
      )}
    </div>
  );
}

export default Game;
