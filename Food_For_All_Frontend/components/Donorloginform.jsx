import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export let HorecaLoginForm = () => {
  let navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8080/checkDonorLogin", {
        email,
        password
      })
      .then((response) => {
        if (response.data) {
          console.log(response.data);
          navigate(`/donor/${response.data.rid}/${response.data.rname}/${response.data.rphone}/${response.data.remail}/${response.data.raddr}/${response.data.city.cityname}`);
        }
        else {
          setErrorMsg("Invalid username or password");
          // console.log(errorMsg);
        }
      })
      .catch((error) => {
      });
  };

  return (
    <div>
      <div className="container" style={{ textAlign: "left" }} >
        <div className="row">
          <div className="col-4">
            <form action="#" method="get" className="bg-light p-3 mt-4 border rounded shadow-5" onSubmit={handleSubmit}>
              <h2 className="text-dark">Donor Login</h2>
              <div className="mb-3">
                <label for="remail" className="form-label">Email</label>
                <input type="email" className="form-control" name="remail" id="remail" aria-describedby="emailHelpId" placeholder="Enter Your Email-Id Here" required onChange={(event) => setEmail(event.target.value)} />
              </div>
              <div className="mb-3">
                <label for="rpassword" className="form-label text-dark"><strong>Password</strong></label>
                <input type="password" className="form-control" name="rpassword" id="rpassword" placeholder="Enter Your Password Here" required onChange={(event) => setPassword(event.target.value)} />
              </div>
              <div>
                <button type="submit" className="btn btn-primary" style={{ textAlign: "center" }}>Login</button><br></br>
              </div>
              <div>
                <br></br>
                <em className="text-danger">{errorMsg}</em>
                <br></br>
                <label className="text-danger ">Don't Have an Account?</label>&nbsp;
                <a href="donorsignin">Create New Account</a>
              </div>


            </form>

          </div>

          <div className="col-4">


          </div>
          <div className="col-4">

          </div>
        </div>
      </div>
    </div>

  );
}