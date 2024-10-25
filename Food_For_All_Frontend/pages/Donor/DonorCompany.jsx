import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';
import bg from '../../img/sharefood.jpg';
import Footer from '../../components/Footer';

export default function DonorCompany() {

  const [request, setRequest] = useState([]);
  const [coid, setCoid] = useState("");
  const [reqid, setReqid] = useState("");
  const { rid, rname, rphone, remail, raddr, cityname } = useParams();

  useEffect(() => {
    loadRequest();
  }, []);

  const loadRequest = async () => {
    const result = await axios.get("http://localhost:8080/getAllCompanyrequest");
    setRequest(result.data);
  };

  const req = { "reqid": reqid };
  req["companies"] = { "coid": coid };
  req["donor"] = { "rid": rid };

  const acceptRequest = async () => {
    await axios.put(`http://localhost:8080/updateCompanyrequest/${reqid}`, req);
    loadRequest();
  };


  return (
    <div>
      <div style={{ backgroundImage: `url(${bg})`, height: "150vh", backgroundRepeat: "no-repeat", backgroundSize: "cover", opacity: 0.9 }}>
        <div className="container">
          <div className="py-4">
            <h3 className="text-warning">COMPANY REQUEST LIST</h3>
            <table className="table table-light table-striped">
              <thead>
                <tr>
                  <th scope="col">Sr.No</th>
                  <th scope="col">Company</th>
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
                      <td>{request.companies.coname}</td>
                      <td>{request.companies.city.cityname}</td>
                      <td>{request.donor.rname}</td>
                      <td>
                        <button className="btn btn-warning mx-2" onClick={() => { acceptRequest(); setCoid(request.companies.coid); setReqid(request.reqid) }}>Acccept</button>

                      </td>
                    </tr>
                  ))
                }

              </tbody>
            </table>
            <div>

            </div>
            <Link className="btn btn-primary mx-2 mb-2"
              to={`/donor/${rid}/${rname}/${rphone}/${remail}/${raddr}/${cityname}`}>Back</Link>
          </div>

        </div>
      </div>
      <Footer></Footer>
    </div>
  )
}

