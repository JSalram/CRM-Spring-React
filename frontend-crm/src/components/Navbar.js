import { Link } from "react-router-dom";
import APIService from "../services/APIService";

export default function Navbar() {
  const logout = () => {
    APIService.logout();
  };

  return (
    <nav>
      <span><Link to="/home">CRM Application</Link></span>
      <span className="span-right">
        <Link to="/home/opportunities">Opportunities</Link>
        <Link to="/home/clients">Clients</Link>
        <Link to="/" onClick={logout}>
          Logout
        </Link>
      </span>
    </nav>
  );
}
