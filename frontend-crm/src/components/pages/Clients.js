import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import APIService from "../../services/APIService";

export default function Clients() {
  const navigate = useNavigate();
  const [clients, setClients] = useState([]);

  useEffect(() => {
    APIService.getClients()
      .then(({ data }) => {
        setClients(data);
      })
      .catch(() => {
        navigate("/");
      });
  }, []);

  return (
    <div>
      <h2>Clients</h2>
      <ul className="list">
        {clients.map((client) => {
          const op = client.opportunities[client.opportunities.length - 1];
          return (
            <li key={client.id} className="list-item">
              ID: {client.id}<br />
              Full name: {op.name} {op.lastName}
              <br />
              Phone Number: {op.phoneNumber}
              <br />
              NIF: {op.nif}
            </li>
          );
        })}
      </ul>
    </div>
  );
}
