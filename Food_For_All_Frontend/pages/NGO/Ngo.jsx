import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import bg from "../../img/happykids.jpg";
import ngoprofile from "../../img/ngoprofile.jpg";
import Footer from '../../components/Footer';

export default function Ngo() {



  const { ngoid, ngoname, ngoemail, ngophone, ngoaddress, cityname } = useParams();


  const [request, setRequest] = useState([]);

  useEffect(() => {
    loadRequest();
  }, []);

  const loadRequest = async () => {
    const result = await axios.get(`http://localhost:8080/getRequestByNgo/${ngoid}`);
    setRequest(result.data);
  };

  const [rid, setRid] = useState(369);

  const req = {};

  req["ngo"] = { "ngoid": ngoid };
  req["donor"] = { "rid": rid };

  const sendRequest = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/sendRequest", req);
    loadRequest();
  };

  const removeRequest = async (reqid) => {
    await axios.delete(`http://localhost:8080/deleteRequest/${reqid}`);
    loadRequest();
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
                      <div className="col-4 rounded" style={{ backgroundImage: `url(${ngoprofile})`, height: "auto", backgroundRepeat: "no-repeat", backgroundSize: "cover" }}>

                      </div>
                      <div className="col-8">
                        <div className="card-body">
                          <strong><h4 className="card-title text-danger">NGO PROFILE</h4></strong>
                          <hr></hr>
                          <p className="card-text">Name: {ngoname}</p>
                          <p className="card-text">Email: {ngoemail}</p>
                          <p className="card-text">Contact: {ngophone}</p>
                          <p className="card-text">Address: {ngoaddress}</p>
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
            <table className="table table-light table-striped">
              <thead>
                <tr>
                  <th scope="col">Sr.No</th>
                  <th scope="col">NGO</th>
                  <th scope="col">Request Accepted By</th>
                  <th scope="col"></th>

                </tr>
              </thead>
              <tbody>
                {
                  request.map((request, index) =>
                  (
                    <tr>
                      <th scope="row" key={index}>
                        {index + 1}</th>
                      <td>{request.ngo.ngoname}</td>
                      <td>{request.donor.rname}</td>
                      <td>
                        <Link className="btn btn-warning mx-2" to={`/ngohotel/${request.donor.rname}/${request.donor.remail}/${request.donor.rphone}/${request.donor.raddr}/${ngoid}/${ngoname}/${ngoemail}/${ngophone}/${ngoaddress}/${cityname}`} ><b>View Hotel</b></Link>
                        <button onClick={() => { removeRequest(request.reqid) }} className="btn btn-danger mx-2"  ><b>Remove Request</b></button>
                      </td>
                    </tr>
                  ))
                }

              </tbody>
            </table>
            <div>
              <Link className="btn btn-danger" to="/ngologin">Log Out</Link>
              <button onClick={sendRequest} className="btn btn-warning mx-2 text-dark"  ><b>Send Request</b></button>
            </div>
          </div>

        </div>
      </div>
      <Footer></Footer>
    </div>
  )
}
