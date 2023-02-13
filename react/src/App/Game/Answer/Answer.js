import "./Answer.css";
import axios from "axios";
function Answer({ answerText, colour, nextQuestion }) {
  const handleClick = () => {
    submitAnswer();
  };

  const submitAnswer = async () => {
    const req = await axios.get(
      `http://localhost:8080/submit-answer?answer=${answerText}`
    );

    nextQuestion(req.data);
  };
  return (
    <div className="col-6">
      <button onClick={handleClick} className={`btn ${colour} answerButton`}>
        {answerText}
      </button>
    </div>
  );
}

export default Answer;
