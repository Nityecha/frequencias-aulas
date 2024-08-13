
import React, { useState, useEffect } from "react";
import "../global.css"

import api from "../services/api";

export default function Rent() {

  const [frequencia, setRent] = useState([]);
  const [client_id, setAluno_id] = useState("");
  const [book_id, setBook_id] = useState("");




  useEffect(
    () => {
       // requisição para pegar os livros e setar no usestage frequencia.
      api.get("frequencia").then((response) => {
        setRent(response.data);
      });
    }, [frequencia]);

  async function handleAluno(e) {
    e.preventDefault();
    const data = { client_id, book_id }
    try {
           // requisição para passar os alugueis e seus valores.
      await api.post('frequencia', data)
      alert(`Frequencia cadastrada com sucesso`)
      clean()


    } catch (err) {
      alert('Erro ao cadastrar alugel, tente novamente.')
    }
  }
  //limpar campos do inputs depois do cadastro
  function clean() {
     setAluno_id("")
    setBook_id("")
  }



  return (

    <div>


      <div className="brand-logo center ">
        <div>
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Registro de frequencia</span></h4>
        </div>
      </div>
      <div className="container">


        <form onSubmit={handleAluno}>


          <label>Aluno</label>
          <input
            placeholder=""
            value={client_id}
            onChange={e => setAluno_id(e.target.value)}
          />
          <label>Data</label>
          <input
            type="date"
            placeholder=""
            value={book_id}
            onChange={e => setBook_id(e.target.value)}
          />

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead >
            {frequencia.map((frequencias) => (
              <tr key={frequencias.id}>

                <th>Aluno: {frequencias.client_id}</th>
                <th>Aula: {frequencias.book_id}</th>
                <th>Data frequencia: {frequencias.frequencialoc}</th>

                <td>
                  <button class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
                  <button class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
                </td>
              </tr>

            ))}
          </thead>


        </table>

      </div>

    </div>





  );
}





