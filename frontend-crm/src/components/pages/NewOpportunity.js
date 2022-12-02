import { useState } from "react";
import { useNavigate } from "react-router-dom";
import APIService from "../../services/APIService";

export default function NewOpportunity() {
  const navigate = useNavigate();
  const [opportunity, setOpportunity] = useState({});

  const handleChange = ({ target }) => {
    const { name, value } = target;
    setOpportunity((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!checkInputs()) {
      alert("ERROR");
      return;
    }
    APIService.newOpportunity(opportunity)
      .then(({ status }) => {
        if (status === 201) {
          navigate("/home/opportunities");
        }
      })
      .catch(() => {
        navigate("/");
      });
  };

  const checkInputs = () => {
    return opportunity.name && opportunity.lastName && opportunity.nif;
  };

  return (
    <div>
      <h2>New Opportunity</h2>
      <form method="POST">
        <label>
          Name: <br />
          <input
            type="text"
            name="name"
            placeholder="Name"
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Last Name: <br />
          <input
            type="text"
            name="lastName"
            placeholder="Last Name"
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          NIF: <br />
          <input
            type="text"
            name="nif"
            placeholder="NIF"
            onChange={handleChange}
          />
        </label>
        <br />
        <input type="submit" onClick={handleSubmit} />
      </form>
    </div>
  );
}
