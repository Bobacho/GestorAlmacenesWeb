import './Textboxes/TextboxLogin'
import TextboxLogin from './Textboxes/TextboxLogin';
import './Login.css';
import InputTextLogin from './InputText/InputTextLogin';
import { render } from 'react-dom';
import { useEffect, useState } from 'react';
import { Link, json, redirectDocument, useNavigate} from 'react-router-dom';

function Login() {

  let [incorrect,setIncorrect]=useState(false);

  const navigate=useNavigate();

  const HandleClick = () => {

    let userInput = document.querySelectorAll(".userInput")[0];
    let passwordInput = document.querySelectorAll(".passwordInput")[0];

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
      "nombreUsuario": userInput.value,
      "contraseña": passwordInput.value
    });

    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    let credenciales={
      "nombreUsuario": userInput.value,
      "contraseña": passwordInput.value,
      "token": ""
    };
    let request=fetch("http://localhost:8080/auth/login", requestOptions)
      .then(response => response.text())
      .then(result => credenciales.token=JSON.parse(result).token)
      .then(() => navigate('/home', {state:credenciales}))
      .catch(() => setIncorrect(true));
  }
  const handleIncorrectCredentials=()=>{
    if(incorrect){
      return(
        <div>
          <h1 style={{color:'red'}}>Credenciales incorrectas</h1>
        </div>
      );
    }
  }
  return (
    <section className='Login'>
      <header>
        <h1 style={{
          color: 'white', fontSize: 'xx-large', fontFamily: 'Verdana', marginBottom: '50px',
          fontStyle: 'oblique'
        }}>
          GESTOR DE ALMACENES
        </h1>
      </header>
      <div className='body'>
        <TextboxLogin Id='userText' Text='Ingrese su nombre de usuario'></TextboxLogin>
        <InputTextLogin id='userInput' text='Nombre de usuario'></InputTextLogin>
        <TextboxLogin Id='passwordText' Text='Ingrese su contraseña'></TextboxLogin>
        <InputTextLogin id='passwordInput' type='password' text='Contraseña'></InputTextLogin>

          <button className='login' style={{
            textDecorationColor: 'darkgreen', borderRadius: '20px', color: 'green'
            , marginTop: '10px'
          }} onClick={HandleClick}>
            <img src={require('../resources/iniciar-sesion.png')} height='70' width='100'></img>
          </button>
        {handleIncorrectCredentials()}
      </div>
    </section>
  );
}

export default Login;