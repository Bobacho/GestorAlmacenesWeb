import './Textboxes/TextboxLogin'
import TextboxLogin from './Textboxes/TextboxLogin';
import './Login.css';
import InputTextLogin from './InputText/InputTextLogin';
import { render } from 'react-dom';
import { useEffect, useState } from 'react';
import { Link, redirectDocument, useNavigate} from 'react-router-dom';

function Login() {
  const userInput = document.getElementsByClassName("userInput")[0];
  const passwordInput = document.getElementsByClassName("passwordInput")[0];
  const navigate=useNavigate();
  const HandleClick = async () => {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
      nombreUsuario: userInput.value,
      contraseña: passwordInput.value
    });

    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };

    let request=fetch("http://localhost:8080/auth/login", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
    navigate("/home");
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
      </div>
    </section>
  );
}

export default Login;