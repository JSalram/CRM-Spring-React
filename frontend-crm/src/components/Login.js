import { useState } from "react";
import { useNavigate } from "react-router-dom";
import APIService from "../services/APIService";
import CookiesService from "../services/CookiesService";

export default function Login() {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const handleChange = ({ target }) => {
    const { name, value } = target;
    setUser((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    APIService.login(user).then(({ data }) => {
      if (data) {
        CookiesService.setUserData(data);
        navigate("home");
      } else {
        alert("ERROR");
        setUser({ username: "", password: "" });
      }
    });
  };

  return (
    <div>
      <h1>Login</h1>
      <form method="POST">
        <label>
          Username: <br />
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={user.username}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Password: <br />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={user.password}
            onChange={handleChange}
          />
        </label>
        <br />
        <input type="submit" onClick={handleSubmit} />
      </form>
    </div>
  );
}
