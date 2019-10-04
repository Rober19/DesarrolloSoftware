const { Component } = React;
const { Redirect } = ReactRouterDOM;

function ProductCreate() {


  async function AddProduct(e) {
    e.preventDefault();
    const {
      name,
      lastname,
      email,
      programming_language,
      play,
      eat,
      playbike,
      run,
      work
    } = e.target;
    let arr1 = [
      {status: play.checked, value: 'JUGAR🎮'},
      {status: eat.checked, value: 'COMER🍲'},
      {status: programming.checked, value: 'PROGRAMAR💻'},
      {status: playbike.checked, value: 'MONTAR BICICLETA🚴'},
      {status: run.checked, value: 'CORRER🏃'},
      {status: work.checked, value: 'TRABAJAR🔨'},        
    ]
    let hobbs = [];

    arr1.forEach((item) => {
      if (item.status) hobbs.push(item.value)
    })

    const person = {
      name: name.value,
      lastname: lastname.value,
      email: email.value,
      programming_language: programming_language.value,
      hobbies: hobbs
      // programming_language: programming_language.value,
      // hobbies: hobbies.value      
    };

    console.log(person)
    
    try {
      let res = await http_post('/jsp-servlets-react/product', person);
      console.warn(res)
      //alert("OK");
      document.getElementById('return').click();
    } catch (err) {
      Swal.fire({
        type: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
        footer: '<a href>Why do I have this issue?</a>'
      })
    }

    //e.target.reset();
  }

  return (
    <div className="container mt-5">
      <h2>Formulario Persona</h2>
      <form className="form-group" method="POST" id="myform" name="contactForm" onSubmit={event => AddProduct(event)}>
        <p className="fs-13">
          Nombre
          <br />
          <input type="text" className="input-txt form-control" name="name" id="name" required />
        </p>

        <p className="fs-13">
          Apellido
          <br />
          <input type="text" className="input-txt form-control" name="lastname" id="lastname" required />
        </p>

        <p className="fs-13">
          Email
          <br />
          <input type="email" className="input-txt form-control" name="email" id="email" required />
        </p>

        <p className="fs-13">
          <select className="browser-default custom-select" id="myselect" name="programming_language" form="myform" className="row fs-13">
            <option value="JAVA">JAVA</option>
            <option value="JAVASCRIPT">JAVASCRIPT</option>
            <option value="C#">C#</option>
          </select>
        </p>
        <p>
          <input type="checkbox" id="play" name="play" /> JUGAR<br />
          <input type="checkbox" id="eat" name="eat" /> COMER<br />
          <input type="checkbox" id="programming" name="programming" /> PROGRAMAR<br />
          <input type="checkbox" id="run" name="run" /> CORRER<br />
          <input type="checkbox" id="work" name="work" /> TRABAJAR<br />
          <input type="checkbox" id="playbike" name="playbike" /> MOTAR BICICLETA<br />
        </p>


        <input type="submit" className="send-btn btn btn-primary" value="Enviar" />
      </form>

      <br />
      <Link id="return" to="/">
        Regresar al listado de personas
      </Link>
    </div>
  );
}
