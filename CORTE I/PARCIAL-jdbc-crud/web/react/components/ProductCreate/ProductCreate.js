const { Component } = React;
const { Redirect } = ReactRouterDOM;

function ProductCreate() {
  async function AddProduct(e) {
    e.preventDefault();
    const { Id, Name, ImageURL, Price } = e.target;

    const product = {
      Name: Name.value,
      ImageURL: ImageURL.value,
      Price: Price.value,
    };

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
      <form method="POST" name="contactForm" onSubmit={event => AddProduct(event)}>
        <p className="fs-13">
          Nombre
          <br />
          <input type="text" className="input-txt form-control" name="Name" id="Name" required/>
        </p>

        <p className="fs-13">
          Imagén URL
          <br />
          <input type="url" alt="Submit" className="input-txt form-control" name="ImageURL" id="ImageURL" required/>
        </p>

        <p className="fs-13">
          Precio
          <br />
          <input type="number" className="input-txt form-control" name="Price" id="Price" required/>
        </p>

        <input type="submit" className="send-btn btn btn-primary" value="Enviar" />
      </form>

      <br />
      <Link id="return" to="/">
        Regresar al listado de productos
      </Link>
    </div>
  );
}
