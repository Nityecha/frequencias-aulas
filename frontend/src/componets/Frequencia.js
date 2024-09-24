import React, { useState, useEffect, useRef } from "react";
import "../global.css";
import api from "../services/api";

export default function Frequencia() {
  const [frequencias, setFrequencias] = useState([]);
  const [aula, setAula] = useState(0);
  const [dataAula, setDataAula] = useState("")

  const [options, setOptions] = useState([]);
  const [options2, setOptions2] = useState([]);

  useEffect(() => {
    getAlunos();
    getAulas();
    getFrequencias();
  }, []);

  async function getFrequencias() {
    try {
      const response = await api.get("/frequencia");
      setFrequencias(response.data);
    } catch (err) {
      alert('Erro ao buscar frequencia, tente novamente.');
    }
  }

  async function getAlunos() {
    try {
      api.get("/aluno").then((response) => {
        setOptions(response.data);
      });
      console.log("teste", options)
    } catch (err) {
      alert('Erro ao carregar alunos, tente novamente.')
    }
  }

  async function getAulas() {
    try {
    // requisição para pegar os Alunos e setar no usestage aluno.
     // requisição para pegar os aulas e setar no usestage aula.
     api.get("/aula").then((response) => {
      setOptions2(response.data);
    });
    } catch (err) {
      alert('Erro ao buscar aula, tente novamente.')
    }
  }

  async function handleAula(e) {
    e.preventDefault();
    
    const selected2Option = selectRef.current.options[selectRef.current.selectedIndex]
    const selectedId = selected2Option.getAttribute('data-id');
    const aluno = selectedId;

    const selectedOption = selectRef2.current.options[selectRef2.current.selectedIndex];
    const selectedId2 = selectedOption.getAttribute('data-aula');
    const aula = selectedId2;
    
    const frequenciaDTO = {
      aluno,    // ID do aluno (como int)
      aula,     // ID da aula (como int)
      dataAula  // Data da aula (string no formato correto, por ex.: "2023-09-22")
    };

    try {
      // Requisição para a API
      await api.post('/frequencia', frequenciaDTO);
      alert('Frequência cadastrada com sucesso');

      // Limpar os campos e chamar outras funções (como recarregar a lista)
      clean();
      getFrequencias();
    } catch (err) {
      alert('Erro ao cadastrar frequência, tente novamente.');
      console.log(err);
    }
  }

  async function handleDeleteAula(id) {
    try {
      await api.delete(`/frequencia/${id}`);
      getFrequencias()
      alert("Frequencia deletada com sucesso!");
    } catch (err) {
      console.log("")
    }
  }
  const selectRef = useRef(null); 
  const selectRef2 = useRef(null);

  function clean() {
    setAula("")
    setDataAula("")
  }

  return (
    <div>
      <div class="brand-logo center ">
        <div>
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Cadastro de frequencia</span></h4>
        </div>
      </div>
      <div class="container">
        <form onSubmit={handleAula}>

          <div>
            <label>Aluno</label>
            <div id="select1">
              <select id="select" ref={selectRef}>
                <option value="" disabled>Selecione...</option>
                {options.map((option) => (
                  <option key={option.id} value={option.name} data-id={option.id}>
                    {option.name}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <div>
            <label>Aula</label>
            <div id="select1">
              <select id="select" ref={selectRef2}>
                <option value="" disabled>Selecione...</option>
                {options2.map((option) => (
                  <option key={option.id} value={option.title} data-aula={option.id}>
                    {option.title}
                  </option>
                ))}
              </select>
            </div>
          </div>
         
          <label>Data da aula realizada</label>
          <input
            type="date"
            value={dataAula}
            onChange={e => setDataAula(e.target.value.toString())}
          />
          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead>
            {frequencias.map((frequencia) => 
            (
              <tr key={frequencia.id}>
                <th>Frequencia: {frequencia.aluno}</th>
                <th>Descrição: {frequencia.aula}</th>
                <th>Data da aula: {frequencia.dataAula}</th>
                <td>
                  <button class="waves-effect btn-small red darken-1"
                    onClick={() => handleDeleteAula(frequencia.id)}
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