import hotel from "../img/hotel.jpg";
import { HorecaSignInForm } from "./Donorsigninform";
import Footer from "./Footer";

export let HorecaSignIn = () => {
    return (
        <div>

            <div style={{ backgroundImage: `url(${hotel})`, height: "100vh", backgroundRepeat: "no-repeat", backgroundSize: "cover", opacity: 0.9 }}>
                <HorecaSignInForm></HorecaSignInForm>
            </div>
            <Footer></Footer>
        </div>
    );
} 