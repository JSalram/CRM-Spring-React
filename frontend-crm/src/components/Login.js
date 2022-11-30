import { useNavigate } from "react-router-dom";
import APIService from "../services/APIService";

export default function Login({ props }) {
  const [user, setUser] = props;

  const navigate = useNavigate()

  const handleChange = ({ target }) => {
    const { name, value } = target;
    setUser((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    APIService.login(user).then(({ data }) => {
      const {userId, token} = data;
      if (data) {
        document.cookie = `token=${token}`;
        setUser((values) => ({ ...values, [userId]: userId }));
        navigate("home")
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
