import axios from "axios";

const url = "http://localhost:8080/";
axios.defaults.withCredentials = true;

class APIService {
  getUrl(path) {
    return url + path;
  }

  login(user) {
    return axios.post(this.getUrl("login"), user);
  }

  logout() {
    return axios.get(this.getUrl("logout"));
  }

  checkUser() {
    return axios.get(this.getUrl("checkUser"));
  }

  getOpportunities() {
    return axios.get(this.getUrl("opportunities"));
  }

  newOpportunity(opportunity) {
    return axios.post(this.getUrl("opportunities/new"), opportunity);
  }

  removeOpportunity(idOpportunity) {
    return axios.delete(this.getUrl(`opportunities/remove/${idOpportunity}`));
  }

  addContact(idOpportunity, contact) {
    contact.date = new Date();
    return axios.post(this.getUrl(`opportunities/${idOpportunity}/new`), contact);
  }

  getClients() {
    return axios.get(this.getUrl("clients"));
  }

  convertClient(idOpportunity) {
    return axios.get(this.getUrl(`opportunities/client/${idOpportunity}`));
  }
}

export default new APIService();
