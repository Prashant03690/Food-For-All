import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import bg from "../../img/sharefood.jpg";
import donorprofile from "../../img/donorprofile.jpg"
import Footer from '../../components/Footer';

export default function Donor() {

  const [request, setRequest] = useState([]);
  const [ngoid, setNgoid] = useState("");
  const [reqid, setReqid] = useState("");
  const { rid, rname, rphone, remail, raddr, cityname } = useParams()



  useEffect(() => {
    loadRequest();
  }, []);

  const loadRequest = async () => {
    const result = await axios.get("http://localhost:8080/getAllRequest");
    setRequest(result.data);
  };

  const req = { "reqid": reqid };
  req["ngo"] = { "ngoid": ngoid };
  req["donor"] = { "rid": rid };

  const acceptRequest = async () => {
    await axios.put(`http://localhost:8080/updateRequest/${reqid}`, req);
    loadRequest();
  };


  return (
    <div>
      <div style={{ backgroundImage: `url(${bg})`, height: "150vh", backgroundRepeat: "no-repeat", backgroundSize: "cover", opacity: 0.9 }}>\
        <div>
          <div className="container">
            <div className="row">
              <div className="col-3">

              </div>
              <div className="col-6">
                <div className="card mt-4 shadow">
                  <div className="container-fluid">
                    <div className="row">
                      <div className="col-4 rounded" style={{ backgroundImage: `url(${donorprofile})`, height: "230px", backgroundRepeat: "no-repeat", backgroundSize: "cover" }}>

                      </div>
                      <div className="col-8">
                        <div className="card-body">
                          <strong><h4 className="card-title text-danger">DONOR PROFILE</h4></strong>
                          <hr></hr>
                          <p className="card-text">Name: {rname}</p>
                          <p className="card-text">Email: {remail} </p>
                          <p className="card-text">Phone: {rphone} </p>
                          <p className="card-text">Address: {raddr} </p>
                          <p className="card-text">City: {cityname} </p>
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
            <h3 className="text-dark text-bg-warning">NGO REQUEST LIST</h3>
            <table className="table table-light table-striped">
              <thead>
                <tr>
                  <th scope="col">Sr.No</th>
                  <th scope="col">NGO</th>
                  <th scope="col">City</th>
                  <th scope="col">Request Accepted By</th>
                  <th scope="col">Double Click To Accept</th>

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
                      <td>{request.ngo.city.cityname}</td>
                      <td>{request.donor.rname}</td>
                      <td>
                        <button className="btn btn-warning mx-2" onClick={() => { acceptRequest(); setNgoid(request.ngo.ngoid); setReqid(request.reqid) }}>Acccept</button>

                      </td>
                    </tr>
                  ))
                }

              </tbody>
            </table>
            <div>

            </div>
            <Link className="btn btn-success mx-2 mb-2"
              to={`/donorcompany/${rid}/${rname}/${rphone}/${remail}/${raddr}/${cityname}`}>Check Requests From Companies</Link>
            <Link className="btn btn-danger mx-2 mb-2"
              to="/donorlogin">Log Out</Link>
          </div>

        </div>
      </div>
      <Footer></Footer>
    </div>
  )
}
