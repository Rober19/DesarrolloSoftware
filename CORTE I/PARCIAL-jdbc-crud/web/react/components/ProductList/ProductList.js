'use strict';

const { Component, useState, useEffect } = React;
const { Link, Redirect } = ReactRouterDOM;

//const Home =  import('../../services/http');

function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getProducts();
  }, {});

  async function getProducts() {
    let res = await http_get('/jsp-servlets-react/product?type=getall');
    setProducts(res);
    console.log(res);
  }

  function DeleteProduct(id = '') {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then(async result => {
      if (result.value) {
        await Product_Delete(id);
        await getProducts();
        //Swal.fire('Deleted!', 'Your file has been deleted.', 'success');
      }
    });
  }

  function UpdateProduct(product) {
    const { Name, Price, Id, ImageURL } = product;

    Swal.fire({
      title: 'Formulario de Actualización',
      html: `
  <h4>Nuevo Nombre</h4>
  <input id="swal-input1" type="text" class="swal2-input" value=${Name}>
  <h4>Nueva Imagen</h4>
  <input id="swal-input2" type="url" class="swal2-input" value=${ImageURL}>     
  <h4>Nuevo Precio</h4>
  <input id="swal-input3" type="number" class="swal2-input" value=${Price}>  
      `,
      focusConfirm: false,
      preConfirm: () => {
        return [
          document.getElementById('swal-input1').value,
          document.getElementById('swal-input2').value,
          document.getElementById('swal-input3').value,
        ];
      },
    }).then(async result => {
      console.warn(result.value[0]);

      await Product_Update({
        Id: Id,
        Name: result.value[0],
        ImageURL: result.value[1],
        Price: result.value[2],
      });
      await getProducts();
    });
  }

  function getProviders() {
    fetch('/jsp-servlets-react/provider')
      .then(res => res.json())
      .then(res => {
        setProviders(res);
      })
      .catch(err => console.log(err));
  }

  return (
    <div>
      <nav className="navbar navbar-light bg-light">
        <h4 className="navbar-brand">Crud de Productos</h4>
        <form className="form-inline">
          <Link to="/createproduct">Crear nuevo producto</Link>
        </form>
      </nav>
      <div className="container">
        <h2 className="text-center mt-5">Listado de Productos</h2>
        <table className="table table-striped mt-3">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Image</th>
              <th>Price</th>
              <th>-</th>
              <th>-</th>
            </tr>
          </thead>
          <tbody>
            {products.map(product => (
              <tr>
                <td>{product.Id}</td>
                <td>{product.Name}</td>
                <td>
                  <img src={product.ImageURL} alt="" />
                </td>
                <td>{product.Price}</td>
                <td>
                  <button
                    type="button"
                    class="btn btn-primary btn-sm"
                    onClick={e => {
                      DeleteProduct(product.Id);
                    }}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    type="button"
                    onClick={e => {
                      UpdateProduct(product);
                    }}
                    class="btn btn-secondary btn-sm"
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
