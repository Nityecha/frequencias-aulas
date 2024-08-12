
import React, { useState, useEffect } from "react";
import "../global.css"

import api from "../services/api";

export default function Rent() {

  const [rent, setRent] = useState([]);
  const [aluno_id, setAluno_id] = useState("");
  const [book_id, setBook_id] = useState("");




  useEffect(
    () => {
       // requisição para pegar os livros e setar no usestage rent.
      api.get("rent").then((response) => {
        setRent(response.data);
      });
    }, [rent]);

  async function handleAluno(e) {
    e.preventDefault();
    const data = { aluno_id, book_id }
    try {
           // requisição para passar os alugueis e seus valores.
      await api.post('rent', data)
      alert(`Aluguel cadastrado com sucesso`)
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
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Cadastro de aluguel</span></h4>
        </div>
      </div>
      <div className="container">


        <form onSubmit={handleAluno}>


          <label>Aluno</label>
          <input
            placeholder=""
            value={aluno_id}
            onChange={e => setAluno_id(e.target.value)}
          />
          <label>Livro</label>
          <input
            type="text"
            placeholder=""
            value={book_id}
            onChange={e => setBook_id(e.target.value)}
          />

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead >
            {rent.map((rents) => (
              <tr key={rents.id}>

                <th>Aluno: {rents.aluno_id}</th>
                <th>Livro: {rents.book_id}</th>
                <th>Data do alugel: {rents.rentloc}</th>

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





