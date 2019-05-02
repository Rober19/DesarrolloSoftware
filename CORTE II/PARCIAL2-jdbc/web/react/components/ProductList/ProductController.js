async function Product_Delete(id) {
  let res = await http_delete('/jsp-servlets-react/product', { id });
  console.log(res);
}

async function Product_Update(product) {
  let res = await http_put('/jsp-servlets-react/product', product);
  console.log(res);
}
