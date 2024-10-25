import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";
export let NgoLoginForm = () => {
  let navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8080/checkNgoLogin", {
        email,
        password
      })
      .then((response) => {
        if (response.data) {
          console.log(response.data);
          navigate(`/ngo/${response.data.ngoid}/${response.data.ngoname}/${response.data.ngoemail}/${response.data.ngophone}/${response.data.ngoaddress}/${response.data.city.cityname}`);
        }
        else {
          setErrorMsg("Invalid username or password");
          console.log(errorMsg);
        }
      })
      .catch((error) => {
      });
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
            <form className="bg-light p-3 mt-4 border rounded shadow-5" onSubmit={handleSubmit} >
              <h2 className="text-dark">NGO Login</h2>
              <div className="mb-3">
                <label for="ngoemail" className="form-label">Email</label>
                <input type="email" className="form-control" name="ngoemail" id="email" aria-describedby="emailHelpId" placeholder="Enter Your Email-Id Here" required onChange={(event) => setEmail(event.target.value)} />
              </div>
              <div className="mb-3">
                <label for="ngopassword" className="form-label text-dark"><strong>Password</strong></label>
                <input type="password" className="form-control" name="ngopassword" id="password" placeholder="Enter Your Password Here" required onChange={(event) => setPassword(event.target.value)} />
              </div>
              <div>
                <button type="submit" className="btn btn-primary mx-2">Login</button>

              </div>
              <br></br>
              <em className="text-danger">{errorMsg}</em>
              <div>
                <label className="text-danger ">Don't Have an Account?</label>&nbsp;
                <a href="ngosignin">Create New Account</a>
              </div>


            </form>

          </div>
        </div>
      </div>
    </div>

  );
}