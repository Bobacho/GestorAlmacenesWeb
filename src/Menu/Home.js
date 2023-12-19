import { useLocation } from "react-router-dom";
import { useState } from "react";


function Home() {
    const credenciales= useLocation().state;
    let [validation,setValidation] =useState(false);
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Cookie", "JSESSIONID=625EFDDEC2FE4210AEB5002E04581C1F");

    
    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(credenciales),
        redirect: 'follow'
    };
    console.log(JSON.stringify(credenciales));
    fetch("http://localhost:8080/auth/validate_token", requestOptions)
        .then(response => response.text())
        .then(result => setValidation(result))
        .then(() => console.log(validation))
        .catch(error => console.log('error', error));
    if (!validation) {
        return (
            <div>
                <a>
                    PAGINA NO DISPONIBLE, LO SIENTO PIPIPIPIPI
                </a>
            </div>
        );
    }
    return (
        <div>
            <h1>
                HOLA CASA
            </h1>
        </div>
    );
}

export default Home;