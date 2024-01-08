import streamlit as st
import os
import requests
import json

def handleButton(username:str,password:str):
    login_request_dict={
        "nombreUsuario":username,
        "contraseña":password
    }
    login_request_json=json.dumps(login_request_dict)
    headers={
        "Content-Type":"application/json"
    }
    request=requests.post("http://localhost:8080/auth/login",login_request_json,headers=headers)
    if request.status_code==200 and request.content!=b'':
        token=json.loads(request.content)["token"]
        st.write(token)
    else:
        st.write("<span style=\"color: red;\">CREDENCIALES INCORRECTAS.</span>",unsafe_allow_html=True)

def main():
    stApp_css=open(os.getcwd()+"\\css\\stApp.css","r")

    page_bg_img = f'''
    <style>
        {stApp_css.read()}
    </style>
    '''
    stApp_css.close()

    st.markdown(page_bg_img, unsafe_allow_html=True)
    login_tittle_css=open(os.getcwd()+"\\css\\LoginTitle.css","r")

    title= f"""
        <style>
        {login_tittle_css.read()}
        </style>
        """
    st.markdown(title,unsafe_allow_html=True)
    login_tittle_css.close()

    with st.container():
        st.title("Gestor de Almacenes")
        username=st.text_input("Ingrese su nombre de usuario")
        password=st.text_input("Ingrese su contraseña",type="password")
        if st.button("Iniciar Sesion"):
            handleButton(username,password)

if __name__=="__main__":
    main()