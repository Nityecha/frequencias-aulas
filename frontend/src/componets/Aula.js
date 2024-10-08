
import React, { useState, useEffect } from "react";
import "../global.css"

import api from "../services/api";

export default function Aula() {

  const [aula, setAula] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
 
  useEffect(
    () => {
      getAulas()
      
    }, []);

    async function getAulas() {
      try {
      // requisição para pegar os Alunos e setar no usestage aluno.
       // requisição para pegar os aulas e setar no usestage aula.
       api.get("/aula").then((response) => {
        setAula(response.data);
      });
      } catch (err) {
        alert('Erro ao buscar aula, tente novamente.')
      }
    }
  
  async function handleAula(e) {
    e.preventDefault();
    const data = { title, description }
    try {
         // requisição para passar os aulas e seus valores.
      await api.post('/aula', data)
      alert(`Aula ${title}, cadastrado com sucesso`)
      clean()
      getAulas()

    } catch (err) {
      alert('Erro ao cadastrar aula, tente novamente.')
      console.log(err)
    }
  }

  async function handleDeleteAula(id) {
    try {
      await api.delete(`/aula/${id}`);
      setAula(aula.filter(a => a.id !== id)); 
      alert("Aula deletada com sucesso!");
    } catch (err) {
      console.log("")
    }
  }
  

  //limpar campos do inputs depois do cadastro
  function clean() {
    setTitle("")
    setDescription("")
  }


  return (

    <div>
      <div class="brand-logo center ">
        <div>
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Cadastro de aulas</span></h4>
        </div>
      </div>
      <div class="container">
        <form onSubmit={handleAula}>

          <label>Materia Aula</label>
          <input
            type="text"
            placeholder="Partituras de violão"
            value={title}
            onChange={e => setTitle(e.target.value)}
          />
          <label>Descrição</label>
          <input
            type="text"
            placeholder="Aula referente a parte 1 de partitura de violão"
            value={description}
            onChange={e => setDescription(e.target.value)}
          />
          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead >
            {aula.map((aulas) => (
              <tr key={aulas.id}>

                <th>Materia aula: {aulas.title}</th>
                <th>Descrição: {aulas.description}</th>
                <td>
                <button class="waves-effect btn-small red darken-1"
                  onClick={() => handleDeleteAula(aulas.id)}
                  ><i class="material-icons" v>delete_sweep</i></button>
                </td>
              </tr>

            ))}
          </thead>


        </table>

      </div>

    </div>
  );
}





