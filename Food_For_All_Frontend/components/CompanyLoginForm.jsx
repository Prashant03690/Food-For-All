import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";
import { useState } from 'react';
export let CompanyLoginForm = () => {
    let navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorMsg, setErrorMsg] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        axios
            .post("http://localhost:8080/checkCompanyLogin", {
                email,
                password
            })
            .then((response) => {
                if (response.data) {
                    console.log(response.data);
                    navigate(`/companypage/${response.data.coid}/${response.data.coname}/${response.data.coemail}/${response.data.cophone}/${response.data.coaddress}/${response.data.city.cityname}`);
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
                        <form className="bg-light p-3 mt-4 border rounded shadow-5" onSubmit={handleSubmit}>
                            <h2 className="text-dark">Company Login</h2>
                            <div className="mb-3">
                                <label for="email" className="form-label"><strong>Email</strong></label>
                                <input type="email" className="form-control" name="email" id="email" aria-describedby="emailHelpId" placeholder="Enter Your Email-Id Here" required onChange={(event) => setEmail(event.target.value)} />
                            </div>
                            <div className="mb-3">
                                <label for="password" className="form-label text-dark"><strong>Password</strong></label>
                                <input type="password" className="form-control" name="password" id="password" placeholder="Enter Your Password Here" required onChange={(event) => setPassword(event.target.value)} />
                            </div>
                            <div>
                                <button type="submit" className="btn btn-primary" style={{ textAlign: "center" }}>Login</button><br></br>
                            </div>
                            <div>
                                <br></br>
                                <em className="text-danger">{errorMsg}</em>

                                <br></br>
                                <label className="text-danger ">Don't Have an Account?</label>&nbsp;
                                <a href="companysignin">Create New Account</a>

                            </div>


                        </form>

                    </div>
                </div>
            </div>
        </div>

    );
}