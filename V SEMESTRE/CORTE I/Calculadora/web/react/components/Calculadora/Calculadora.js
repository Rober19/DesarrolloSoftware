const { Component } = React;
const { Redirect } = ReactRouterDOM;

function Calculadora() {
  function AddProduct(e) {
    e.preventDefault();
    const { value1, value2, operacion } = e.target;

    const oper = {
      valor1: value1.value,
      valor2: value2.value,
      operacion: operacion.value,
    };

    console.log(oper);

    fetch('/Calculadora/CalcuServlet', {
      headers: {
        'Content-Type': 'application/json',
      },
      method: 'post',
      body: JSON.stringify(oper),
    })
      .then(res => res.json())
      .then(res => {
        swal(String(res));
        console.log(res)
        //    alert(JSON.stringify(res));
        //    document.getElementById('return').click();
      })
      .catch(err => alert(err));

    //e.target.reset();
  }

  return (
    <div className="container mt-5">
      <h2>Calcular operacion</h2>
      <form method="POST" name="contactForm" onSubmit={event => AddProduct(event)}>
        <p className="fs-13">
          Primer Valor
          <br />
          <input type="text" className="input-txt form-control" name="value1" id="value1" />
        </p>

        <p className="fs-13">
          Segundo Valor
          <br />
          <input type="text" className="input-txt form-control" name="value2" id="value2" />
        </p>

        <div className="row">
          <div className="col">
            <select name="operacion" id="operacion">
              <option value="sumar">Sumar</option>
              <option value="restar">Restar</option>
              <option value="multiplicar">Multiplicar</option>
              <option value="dividir">Dividir</option>
            </select>
          </div>
          <div className="col">
            {' '}
            <input type="submit" className="send-btn btn btn-primary" value="Calcular" />
          </div>
        </div>
      </form>

      <br />
    </div>
  );
}
/* <Link id="return" to="/">
 Regresar al listado de productos
 </Link>*/
