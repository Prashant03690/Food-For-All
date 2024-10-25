import { useState } from 'react';
import axios from "axios";
import { Link, useNavigate } from 'react-router-dom';
export let UserloginForm = () => {

    let navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errorMsg, setErrorMsg] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        axios
            .post("http://localhost:8080/checkCustomerLogin", {
                email,
                password
            })
            .then((response) => {
                if (response.data) {
                    console.log(response.data);
                    navigate(`/userpage/${response.data.cid}/${response.data.cname}/${response.data.cphone}/${response.data.cemail}/${response.data.city.cityname}`);
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
                        <form className="bg-light p-3 mt-4 border rounded shadow-5" onSubmit={handleSubmit}>
                            <h2 className="text-dark">Customer Login</h2>
                            <div className="mb-3">
                                <label for="cemail" className="form-label text-dark"><strong>Email</strong></label>
                                <input type="email"
                                    className="form-control" name="cemail" id="cemail" aria-describedby="helpId" placeholder="Enter Your Email Here" required onChange={(event) => setEmail(event.target.value)} />
                            </div>
                            <div className="mb-3">
                                <label for="cpassword" className="form-label text-dark"><strong>Password</strong></label>
                                <input type="password" className="form-control" name="cpassword" id="password" placeholder="Enter Your Password Here" required onChange={(event) => setPassword(event.target.value)} />
                            </div>
                            <div>
                                <button type="submit" className="btn btn-primary" style={{ textAlign: "center" }}>Login</button><br></br>
                            </div>
                            <div>
                                <br></br>
                                <em className="text-danger">{errorMsg}</em>
                                <br></br>
                                <label className="text-danger ">Don't Have an Account?</label>&nbsp;
                                <a href="usersignin">Create New Account</a>
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