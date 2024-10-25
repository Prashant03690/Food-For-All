import { useState } from "react";
import axios from 'axios';
import { Link, useNavigate } from "react-router-dom";

export let NgoSignInForm = () => {
  const [cpc, setCpc] = useState();
  let navigate = useNavigate();

  const [ngo, setNgo] = useState(
    {
      ngoname: "",
      ngoemail: "",
      ngopassword: "",
      ngoaddress: "",
      ngophone: "",
    }
  );

  const { ngoname, ngoemail, ngopassword, ngoaddress, ngophone } = ngo;

  const onInputChange = (e) => {
    setNgo({ ...ngo, [e.target.name]: e.target.value });
  };

  ngo["city"] = { "citypincode": cpc };


  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/ngoSignIn", ngo);
    navigate('/userlogin');
  };

  return (
    <div>
      <div className="container" style={{ textAlign: "left" }}>
        <div className="row">
          <div className="col-4">


          </div>

          <div className="col-4">

          </div>
          <div className="col-4">
            <form action="#" method="get" className="bg-light p-3 mt-3 border rounded shadow-5" onSubmit={(e) => onSubmit(e)}>
              <h2 className="text-dark">NGO Sign In</h2>
              <div className="mb-3">
                <label for="name" className="form-label text-dark" style={{ textAlign: "left" }}><strong>NGO Name</strong></label>
                <input type="text"
                  className="form-control" name="ngoname" id="name" aria-describedby="helpId" placeholder="Enter Your NGO Name Here" value={ngoname} onChange={(e) => onInputChange(e)} required />
              </div>
              <div className="mb-3">
                <label for="email" className="form-label"><strong>Email-Id</strong></label>
                <input type="email" className="form-control" name="ngoemail" id="email" aria-describedby="emailHelpId" placeholder="Enter Your Email-Id Here" value={ngoemail} onChange={(e) => onInputChange(e)} pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}" required />
              </div>
              <div className="mb-3">
                <label for="password" className="form-label text-dark"><strong>Password</strong></label>&nbsp;
                <small id="password" className="form-text text-danger">(Min 8 Characters, With Atleast One Number And a Special Character!)</small>
                <input type="password" className="form-control" name="ngopassword" id="password" placeholder="Example - foodforall@369" value={ngopassword} onChange={(e) => onInputChange(e)} pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$" required />
              </div>
              <div className="mb-3">
                <div className="mb-3">
                  <label for="address" className="form-label text-dark" style={{ textAlign: "left" }}><strong>Address</strong></label>
                  <input type="text"
                    className="form-control" name="ngoaddress" id="ngoaddress" aria-describedby="helpId" placeholder="Enter Your Address Here" value={ngoaddress} onChange={(e) => onInputChange(e)} required />
                </div>
                <div className="mb-3">
                  <label for="contactno" className="form-label text-dark" style={{ textAlign: "left" }}><strong>Contact No</strong></label>
                  <input type="text"
                    className="form-control" name="ngophone" id="ngophone" aria-describedby="helpId" placeholder="Enter Your Contact Details Here" value={ngophone} onChange={(e) => onInputChange(e)} pattern="[0-9]{10}" required />
                </div>
                <label for="citypincode" className="form-label text-dark"><strong>City-Pincode</strong></label>
                <input type="text"
                  className="form-control" name="citypincode" id="citypincode" aria-describedby="helpId" placeholder="Enter Your CityPincode Here" onChange={(e) => { setCpc(e.target.value) }} pattern="[0-9]{6}" required />

              </div>
              <button type="submit" className="btn btn-primary">Sign In</button>&emsp;
              <Link type="submit" className="btn btn-outline-danger" to="/ngologin">Cancel</Link>
            </form>

          </div>
        </div>
      </div>
    </div>

  );
}