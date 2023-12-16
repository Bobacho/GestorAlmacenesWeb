function Home(credenciales = { nombreUsuario: "", contraseña: "", token: "" }) {
    const validation = true;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Cookie", "JSESSIONID=625EFDDEC2FE4210AEB5002E04581C1F");

    
    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: credenciales,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/auth/validate_token", requestOptions)
        .then(response => response.text())
        .then(result => validation=Boolean(result))
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