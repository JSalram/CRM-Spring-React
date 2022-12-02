import APIService from "../../services/APIService";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Opportunities() {
  const navigate = useNavigate();
  const [opportunities, setOpportunities] = useState([]);

  useEffect(() => {
    APIService.getOpportunities()
      .then(({ data }) => {
        if (data) {
          setOpportunities(data);
        }
      })
      .catch(() => {
        navigate("/");
      });
  }, []);

  const removeOpportunity = (idOpportunity) => {
    APIService.removeOpportunity(idOpportunity)
      .then(({ status }) => {
        if (status === 200) {
          window.location.reload();
        }
      })
      .catch(() => {
        navigate("/");
      });
  };

  const addContact = () => {};

  const convertClient = (idOpportunity) => {
    APIService.convertClient(idOpportunity)
      .then(({ status }) => {
        if (status === 200) {
          navigate("/home/clients");
        }
      })
      .catch(() => {
        navigate("/");
      });
  };

  const parseDate = (strDate) => {
    const date = new Date(strDate);
    const [day, month, year, hours, minutes] = [
      date.getDay(),
      date.getMonth(),
      date.getFullYear(),
      date.getHours(),
      date.getMinutes(),
    ];
    return `${day}/${month}/${year} - ${hours}:${minutes}`;
  };

  if (!opportunities) return null;

  return (
    <div>
      <h2>Opportunities</h2>
      <Link to="new" className="newOpportunity">
        New Opportunity
      </Link>
      <ul className="list">
        {opportunities.map((opportunity) => (
          <li key={opportunity.id} className="list-item">
            <h3>
              {opportunity.name} {opportunity.lastName}
            </h3>
            {opportunity.contacts.length > 0 && (
              <>
                <b>Contacts:</b>
                <ul className="contactList">
                  {opportunity.contacts.map((contact) => (
                    <li key={contact.id} className="contact">
                      <b>{parseDate(contact.date)}:</b> {contact.description}
                    </li>
                  ))}
                </ul>
              </>
            )}
            <br />
            <div className="opButtons">
              <Link to={`/home/opportunities/${opportunity.id}/new`}>
                <button>New Contact</button>
              </Link>
              <button onClick={() => convertClient(opportunity.id)}>
                Convert to Client
              </button>
              <button onClick={() => removeOpportunity(opportunity.id)}>
                Remove Opportunity
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}
