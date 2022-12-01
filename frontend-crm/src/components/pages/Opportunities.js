import "../../styles/Opportunities.css";
import APIService from "../../services/APIService";
import CookiesService from "../../services/CookiesService";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Opportunities() {
  const [opportunities, setOpportunities] = useState([]);

  useEffect(() => {
    const userData = CookiesService.getUserData();
    APIService.getOpportunities().then(({ data }) => {
      if (data) {
        setOpportunities(data);
      }
    });
  }, []);

  const removeOpportunity = (idOpportunity) => {
    console.log(idOpportunity);
  };

  const addContact = () => {
    console.log("Add Contact");
  };

  if (!opportunities) return null;

  return (
    <div>
      <h2>Opportunities</h2>
      <Link to="new">New Opportunity</Link>
      <ul className="opportunityList">
        {opportunities.map((opportunity) => (
          <li key={opportunity} className="opportunity">
            <h3>{opportunity.name}</h3>
            <ul className="contactList">
              {opportunity.contacts.map((contact) => (
                <li key={contact} className="contact">
                  {contact.description}
                </li>
              ))}
            </ul>
            <br />
            <button onClick={() => removeOpportunity(opportunity.id)}>
              Remove Opportunity
            </button>
            <button onClick={addContact}>New Contact</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
