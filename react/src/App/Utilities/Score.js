import "./Score.css";
function Score({ score, final }) {
  return (
    <div className={final ? "finalScore" : "gameActive"}>
      {final ? (
        <h1>Congratulations your final score was {score}/10!</h1>
      ) : (
        `${score} Answers`
      )}
    </div>
  );
}

export default Score;
