const { Component } = React;
const { Redirect } = ReactRouterDOM;

function ProductCreate() {
  async function AddProduct(e) {
    e.preventDefault();
    const { name, lastname, email, programming_language, vehicle3 } = e.target;

    const person = {
      name: name.value,
      lastname: lastname.value,
      email: email.value,
      programming_language: programming_language.value,
      vehicle3: vehicle3.value
      // programming_language: programming_language.value,
      // hobbies: hobbies.value      
    };

    console.log(person)
    return null;
    try {
      let res = await http_post('/jsp-servlets-react/product', product);
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
      <h2>Crear Producto</h2>
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
          <input type="checkbox" id="vehicle1" name="vehicle1"  /> I have a bike<br/><br/>
          <input type="checkbox" id="vehicle2" name="vehicle2" /> I have a car<br/>
          <input type="checkbox" id="vehicle3" name="vehicle3" /> I have a boat<br/>
        </p>


        <input type="submit" className="send-btn btn btn-primary" value="Send" />
      </form>

      <br />
      <Link id="return" to="/">
        Regresar al listado de productos
      </Link>
    </div>
  );
}
