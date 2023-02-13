import "./QuestionImage.css";
function QuestionImage({ imgUrl }) {
  return (
    <div className="row">
      <img className="questionImage" height={400} src={imgUrl}></img>
    </div>
  );
}

export default QuestionImage;
