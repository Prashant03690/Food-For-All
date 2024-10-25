import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import bg from "../../img/foodproduct.jpg";
import companyprofile from "../../img/petfoodlogo.jpg";
import Footer from '../../components/Footer';


export default function Company() {

  const { fpid, coid, coname, coemail, cophone, coaddress, cityname } = useParams();
  const rid = 369;
  const request = {};

  request["companies"] = { "coid": coid };
  request["donor"] = { "rid": rid };

  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    const result = await axios.get(`http://localhost:8080/getFoodproductByCompany/${coid}`);
    setProducts(result.data);
  };

  const deleteProducts = async (fpid) => {
    const result = await axios.delete(`http://localhost:8080/deleteFoodproduct/${fpid}`);
    loadProducts();
  };

  const sendRequest = async () => {
    await axios.post("http://localhost:8080/sendCompanyrequest", request);
    alert("Request Sent! Check Request Status To See Updates");
  };


  return (
    <div>

      <div style={{ backgroundImage: `url(${bg})`, height: "150vh", backgroundRepeat: "no-repeat", backgroundSize: "cover", opacity: 0.9 }}>
        <div>
          <div className="container">
            <div className="row">
              <div className="col-3">

              </div>
              <div className="col-6">
                <div className="card mt-4 shadow">
                  <div className="container-fluid">
                    <div className="row">
                      <div className="col-4 rounded" style={{ backgroundImage: `url(${companyprofile})`, height: "300px", backgroundRepeat: "no-repeat", backgroundSize: "contain" }}>

                      </div>
                      <div className="col-8">
                        <div className="card-body">
                          <strong><h4 className="card-title text-danger">COMPANY PROFILE</h4></strong>
                          <hr></hr>
                          <p className="card-text">Name: {coname}</p>
                          <p className="card-text">Email: {coemail}</p>
                          <p className="card-text">Contact: {cophone}</p>
                          <p className="card-text">Address: {coaddress}</p>
                          <p className="card-text">City: {cityname}</p>
                        </div>
                      </div>


                    </div>
                  </div>

                </div>
              </div>
              <div className="col-3">

              </div>

            </div>
          </div>
        </div>
        <div className="container">
          <div className="py-4">
            <Link className="btn btn-warning mx-2 mb-3" to={`/addfoodproduct/${coid}/${coname}/${coemail}/${cophone}/${coaddress}/${cityname}`} >Add Product</Link>
            <button className="btn btn-success mx-2 mb-3" onClick={sendRequest}>Send Request</button>
            <Link className="btn btn-primary mx-2 mb-3" to={`/companyrequesttable/${coid}/${coname}/${coemail}/${cophone}/${coaddress}/${cityname}`} >Check Request Status</Link>
            <table className="table table-light table-striped">
              <thead>
                <tr>
                  <th scope="col">Sr.No</th>
                  <th scope="col">Product Name</th>
                  <th scope="col">Price</th>
                  <th scope="col">Quantity</th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody>
                {
                  products.map((product, index) =>
                  (
                    <tr>
                      <th scope="row" key={index}>
                        {index + 1}</th>
                      <td>{product.fpname}</td>
                      <td>{product.fpprice}</td>
                      <td>{product.fpqty}</td>
                      <td>
                        <Link className="btn btn-warning mx-2"
                          to={`/editfoodproduct/${product.fpid}/${coid}/${coname}/${coemail}/${cophone}/${coaddress}/${cityname}`}>Edit</Link>
                        <button className="btn btn-danger mx-2" onClick={() => deleteProducts(product.fpid)}>Delete</button>
                      </td>
                    </tr>
                  ))

                }

              </tbody>
            </table>

          </div>
          <div>
            <Link type="submit" className="btn btn-danger" to="/companylogin">Logout</Link>
          </div>

        </div>
      </div>

      <Footer></Footer>
    </div>
  )
}
