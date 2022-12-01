import { Link } from "react-router-dom";

export default function Navbar() {
  const logout = () => {
    document.cookie = "userId=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
    document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
  };

  return (
    <nav>
      <ul>
        <li>
          <h4>Navigation</h4>
        </li>
        <li>
          <Link to="/home">Home</Link>
        </li>
        <li>
          <Link to="/home/opportunities">Opportunities</Link>
        </li>
        <li>
          <Link to="/" onClick={logout}>
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  );
}
