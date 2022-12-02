import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import APIService from "../../services/APIService";

export default function NewContact() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [contact, setContact] = useState({});

  const handleChange = ({ target }) => {
    const { name, value } = target;
    setContact((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!checkInputs()) {
      alert("ERROR");
      return;
    }
    APIService.addContact(id, contact)
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
    return contact.description;
  };

  return (
    <div>
      <h2>New Contact</h2>
      <form method="POST">
        <label>
          Description: <br />
          <input
            type="text"
            name="description"
            placeholder="Description"
            onChange={handleChange}
          />
        </label>
        <br />
        <input type="submit" onClick={handleSubmit} />
      </form>
    </div>
  );
}
