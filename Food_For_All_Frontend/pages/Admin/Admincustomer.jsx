import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import bg from "../../img/Tech.jpg";

export default function Admincustomer() {

  const [customer, setCustomer] = useState([]);

  const { aid, fname, lname, aemail, aphone } = useParams();


  useEffect(() => {
    loadCustomer();
  }, []);

  const loadCustomer = async () => {
    const result = await axios.get("http://localhost:8080/getAllCustomer");
    setCustomer(result.data);
  };

  const deleteCustomer = async (cid) => {
    const result = await axios.delete(`http://localhost:8080/deleteCustomer/${cid}`);
    loadCustomer();
  };


  return (
    <div>
      <div style={{ backgroundImage: `url(${bg})`, height: "100vh", backgroundRepeat: "no-repeat", backgroundSize: "cover", opacity: 0.9 }}>
        <div className="container">
          <div className="py-4">
            <table className="table table-light table-striped">
              <thead>
                <tr>
                  <th scope="col">Sr.No</th>
                  <th scope="col">Customer Name</th>
                  <th scope="col">Contact Info</th>
                  <th scope="col">City</th>
                  <th scope="col"></th>

                </tr>
              </thead>
              <tbody>
                {
                  customer.map((customer, index) =>
                  (
                    <tr>
                      <th scope="row" key={index}>
                        {index + 1}</th>
                      <td>{customer.cname}</td>
                      <td>{customer.cphone}</td>
                      <td>{customer.city.cityname}</td>
                      <td> <button className="btn btn-danger mx-2" onClick={() => deleteCustomer(customer.cid)}>Delete</button></td>

                    </tr>
                  ))
                }

              </tbody>
            </table>
            <div>
              <Link className="btn btn-warning mx-2" to={`/adminpage/${aid}/${fname}/${lname}/${aemail}/${aphone}`}><b>Back</b></Link>
            </div>
          </div>

        </div>
      </div>
    </div>
  )
}
