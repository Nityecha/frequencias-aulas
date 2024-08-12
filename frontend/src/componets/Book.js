
import React, { useState, useEffect } from "react";
import "../global.css"

import api from "../services/api";

export default function Book() {

  const [book, setBook] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [author, seAuthor] = useState("");
  const [qtd, setQtd] = useState(0);


 
  useEffect(
    () => {
       // requisição para pegar os livros e setar no usestage book.
      api.get("book").then((response) => {
        setBook(response.data);
      });
    }, [book]);

  
  async function handleBook(e) {
    e.preventDefault();
    const data = { title, description, category, author, qtd }
    try {
         // requisição para passar os livros e seus valores.
      await api.post('book', data)
      alert(`Livro de ${title}, cadastrado com sucesso`)
      clean()



    } catch (err) {
      alert('Erro ao cadastrar livro, tente novamente.')
    }
  }

  //limpar campos do inputs depois do cadastro
  function clean() {
    setTitle("")
    setCategory("")
    setDescription("")
    seAuthor("")
    setQtd(0)

  }



  return (

    <div>


      <div class="brand-logo center ">
        <div>
          <h4 ><span className="  amber lighten-5 yellow accent-1 z-depth-3">Cadastro de livros</span></h4>
        </div>
      </div>
      <div class="container">


        <form onSubmit={handleBook}>

          <label>Nome do livro</label>
          <input
            type="text"
            placeholder="harry potter"
            value={title}
            onChange={e => setTitle(e.target.value)}
          />
          <label>Descrição</label>
          <input
            type="text"
            placeholder="Nascido em 31 de julho de 1980, Harry é um bruxo..."
            value={description}
            onChange={e => setDescription(e.target.value)}
          />
          <label>Categoria</label>
          <input
            type="text"
            placeholder="ficção"
            value={category}
            onChange={e => setCategory(e.target.value)}
          />
          <label>Autor</label>
          <input
            type="text"
            placeholder="J. K. Rowling"
            value={author}
            onChange={e => seAuthor(e.target.value)}
          />
          <label>Quantidade</label>
          <input
            type="number"
            value={qtd}
            onChange={e => setQtd(e.target.value)}
          />

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

        </form>
        <table>

          <thead >
            {book.map((books) => (
              <tr key={books.id}>

                <th>Nome: {books.title}</th>
                <th>Descrição: {books.books}</th>
                <th>Categoria: {books.category}</th>
                <th>Autor: {books.author}</th>
                <th>Quantidade: {books.qtd}</th>

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





