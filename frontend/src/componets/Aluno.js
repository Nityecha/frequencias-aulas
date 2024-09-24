
import React, { useState, useEffect } from "react";
import "../global.css"

import api from "../services/api";

export default function Aluno() {
  const [aluno, setAluno] = useState([]);
  const [name, setName] = useState("");
  const [cpf, setCpf] = useState("");
  const [tel, setTel] = useState("");

  useEffect(
    () => {
      getAlunos()
    }, []);

    async function getAlunos() {
      try {
      // requisição para pegar os Alunos e setar no usestage aluno.
      api.get("aluno").then((response) => {
        setAluno(response.data);
      });
      } catch (err) {
        alert('Erro ao cadastrar caso, tente novamente.')
      }
    }

  async function handleAluno(e) {
    e.preventDefault();
    const data = { name, cpf, tel }
    try {
      
     // requisição para passar os Alunos e seus valores.
      await api.post('aluno', data)
      alert(`Aluno ${name} cadastrado com sucesso`)
      clean()
      getAlunos()
    } catch (err) {
      alert('Erro ao cadastrar caso, tente novamente.')
    }
  }

  //limpar campos do inputs depois do cadastro
  function clean() {
    setName("")
    setCpf("")
    setTel("")
  }

  // Função para deletar o aluno
async function handleDeleteAluno(id) {
  try {
    await api.delete(`aluno/${id}`);
    setAluno(aluno.filter(a => a.id !== id)); // Remove o aluno do estado após a deleção
    alert("Aluno deletado com sucesso!");
  } catch (err) {
    alert("Erro ao deletar aluno, tente novamente.");
  }
}



  return (

    <div>
      <div class="brand-logo center ">
        <div>
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Cadastro de Alunos</span></h4>
        </div>
      </div>
      <div class="container">


        <form onSubmit={handleAluno}>

          <label>Nome</label>
          <input
            type="text"
            placeholder="Nome"
            value={name}
            onChange={e => setName(e.target.value)}
          />
          <label>CPF</label>
          <input
            placeholder="000.111.222-33"
            value={cpf}
            onChange={e => setCpf(e.target.value)}
          />
          <label>Telefone</label>
          <input
            type="text"
            placeholder="(83) 99911-2233"
            value={tel}
            onChange={e => setTel(e.target.value)}
          />

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead >
            {aluno.map((aluno) => (
              <tr key={aluno.id}>

                <th>Nome: {aluno.name}</th>
                <th>CPF: {aluno.cpf}</th>
                <th>Telefone: {aluno.tel}</th>
                <td>
                    
                  <button class="waves-effect btn-small red darken-1"
                  onClick={() => handleDeleteAluno(aluno.id)}
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





