import './App.css';
import { UserLogin } from './components/CustomerLogin';
import { UserSignin } from './components/CustomerSignIn';
import { HorecaSignIn } from './components/Donorsignin';
import { HorecaLogIn } from './components/Donorlogin';
import { CompanySignIn } from './components/CompanySignIn';
import { CompanyLogin } from './components/CompanyLogin';
import { NGOLogin } from './components/NgoLogin';
import { NgoSignIn } from './components/NgoSignIn';
import { Navig } from './components/Navig';
import { Home } from './components/Home';
import { Route, Routes} from 'react-router-dom';
import User from './pages/Customer/Customer';
import Company from './pages/Company/Company';
import AddFoodproduct from './CRUD/FoodProduct/AddFoodproduct';
import EditFoodproduct from './CRUD/FoodProduct/EditFoodproduct';
import Ngo from './pages/NGO/Ngo';
import Donor from './pages/Donor/Donor';
import UserPayment from './pages/Customer/CustomerPayment';
import CompanyRequestTable from './pages/Company/CompanyReqTable';
import DonorCompany from './pages/Donor/DonorCompany';
import AmdinLogin from './components/AmdinLogin';
import Adminpage from './pages/Admin/Adminpage';
import Admindonor from './pages/Admin/Admindonor';
import Adminngo from './pages/Admin/Adminngo';
import Admincustomer from './pages/Admin/Admincustomer';
import Admincompanies from './pages/Admin/Admincompanies';
import UserCard from './pages/Customer/CustomerCard';
import ViewCart from './CRUD/Cart/ViewCart';
import Aboutus from './components/Aboutus';
import MyOrders from './pages/Customer/CustomerOrders';
import NgoHotel from './pages/NGO/NgoHotel';
import CompanyHotel from './pages/Company/CompanyHotel';



function App() {
  return (
    <div className="App">
      <Navig></Navig>
      

      {/* <User></User> */}



    {/* <UserSignin></UserSignin> */}
    {/* <HorecaSignIn></HorecaSignIn> */}
    {/* <HorecaLogIn></HorecaLogIn> */}
    {/* <CompanySignIn></CompanySignIn> */}
    {/* <CompanyLogin></CompanyLogin> */}
    {/* <NGOLogin></NGOLogin> */}
    {/* <NgoSignIn></NgoSignIn> */}


    <Routes>
      <Route path='/' element={<Home></Home>}></Route>
      <Route path='home' element={<Home></Home>}></Route>
      <Route path='companylogin' element={<CompanyLogin></CompanyLogin>}></Route>
      <Route path='companysignin' element={<CompanySignIn></CompanySignIn>}></Route>
      <Route path='donorlogin' element={<HorecaLogIn></HorecaLogIn>}></Route>
      <Route path='donorsignin' element={<HorecaSignIn></HorecaSignIn>}></Route>
      <Route path='userlogin' element={<UserLogin></UserLogin>}></Route>
      <Route path='usersignin' element={<UserSignin></UserSignin>}></Route>
      <Route path='ngologin' element={<NGOLogin></NGOLogin>}></Route>
      <Route path='ngosignin' element={<NgoSignIn></NgoSignIn>}></Route>
      <Route path='addfoodproduct/:coid/:coname/:coemail/:cophone/:coaddress/:cityname' element={<AddFoodproduct></AddFoodproduct>}></Route>
      <Route path='/companypage/:coid/:coname/:coemail/:cophone/:coaddress/:cityname' element={<Company></Company>}></Route>
      <Route path='editfoodproduct/:fpid/:coid/:coname/:coemail/:cophone/:coaddress/:cityname' element={<EditFoodproduct></EditFoodproduct>}></Route>
      <Route path='userpage/:cid/:cname/:cphone/:cemail/:cityname' element={<User></User>}></Route>
      <Route path='ngo/:ngoid/:ngoname/:ngoemail/:ngophone/:ngoaddress/:cityname' element={<Ngo></Ngo>}></Route>
      <Route path='donor/:rid/:rname/:rphone/:remail/:raddr/:cityname' element={<Donor></Donor>}></Route>
      <Route path='userpayment/:fpid/:cid/:cname/:cphone/:cemail/:cityname' element={<UserPayment></UserPayment>}></Route>
      <Route path='companyrequesttable/:coid/:coname/:coemail/:cophone/:coaddress/:cityname' element={<CompanyRequestTable></CompanyRequestTable>}></Route>
      <Route path='donorcompany/:rid/:rname/:rphone/:remail/:raddr/:cityname' element={<DonorCompany></DonorCompany>}></Route>
      <Route path='adminlogin' element={<AmdinLogin></AmdinLogin>}></Route>
      <Route path='adminpage/:aid/:fname/:lname/:aemail/:aphone' element={<Adminpage></Adminpage>}></Route>
      <Route path='adminngo/:aid/:fname/:lname/:aemail/:aphone' element={<Adminngo></Adminngo>}></Route>
      <Route path='admindonor/:aid/:fname/:lname/:aemail/:aphone' element={<Admindonor></Admindonor>}></Route>
      <Route path='admincompany/:aid/:fname/:lname/:aemail/:aphone' element={<Admincompanies></Admincompanies>}></Route>
      <Route path='admincustomer/:aid/:fname/:lname/:aemail/:aphone' element={<Admincustomer></Admincustomer>}></Route>
      <Route path='usercard/:fpid/:cid/:cname/:cphone/:cemail/:cityname' element={<UserCard></UserCard>}></Route>
      <Route path='viewcart/:cid/:cname/:cphone/:cemail/:cityname' element={<ViewCart></ViewCart>}></Route>
      <Route path='aboutus' element={<Aboutus></Aboutus>}></Route>
      <Route path='myorders/:cid/:cname/:cphone/:cemail/:cityname' element={<MyOrders></MyOrders>}></Route>
      <Route path='ngohotel/:rname/:remail/:rphone/:raddr/:ngoid/:ngoname/:ngoemail/:ngophone/:ngoaddress/:cityname' element={<NgoHotel></NgoHotel>}></Route>
      <Route path='companyhotel/:rname/:remail/:rphone/:raddr/:coid/:coname/:coemail/:cophone/:coaddress/:cityname' element={<CompanyHotel></CompanyHotel>}></Route>
     


      


    </Routes>
    </div>
  );
}

export default App;
