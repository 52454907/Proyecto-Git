import { createContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
 const  [usuario, setUsuario] =  useState ('')
 const  [clave, setclave] =  useState ('')

 function cambiarUsuario(evento) {
   setUsuario(evento.target.value)
 }
 function cambiarClave(evento) {
   setclave(evento.target.value)
  }
 function ingresar() {
 //alert("Iniciando Sesiòn...")
  if (usuario == 'admin' && clave == 'admin') {
   alert('Ingresaste...')
  }else{  
     alert('No existe este usuario  o ingresaste mal contraseña...')
  }
  
 }
  return (
    <>
    <h1> LOGIN</h1>
    <input placeholder='Usuario' type="text" name="usuario" id="usuario" value={usuario} onChange={cambiarUsuario}/>
    <input  placeholder='Clave' type="password" name="clave" id="clave" value={clave} onChange={cambiarClave}/>
    <button onClick={ingresar}>Ingresar </button>
          </>
    )
}

export default App
