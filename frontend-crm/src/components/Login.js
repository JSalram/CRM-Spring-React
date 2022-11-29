import { useState } from "react";
import APIService from "../services/APIService";

export default function Login() {
  const [user, setUser] = useState({});

  const handleChange = ({ target }) => {
    const { name, value } = target;
    setUser((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    APIService.login(user).then(({ data }) => {
      if (data) {
        window.location.href = "/home";
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
            onChange={handleChange}
          />
        </label>
        <br />
        <input type="submit" onClick={handleSubmit} />
      </form>
    </div>
  );
}
