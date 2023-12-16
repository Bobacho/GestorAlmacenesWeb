import './InputTextLogin.css'

function InputTextLogin(props){
    const {id,type,text}=props;
    return (
        <div className="inputText">
            <input className={id} type={type} placeholder={text}>
            </input>
        </div>
    );
}

export default InputTextLogin;