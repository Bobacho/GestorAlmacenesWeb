import './TextboxLogin.css'

function TextboxLogin(props)
{
   const {Id,Text}=props;
    return(
    <div className="textboxlogin">
      <text className={Id}>
        {Text}
      </text>
    </div>
    );
}

export default TextboxLogin;