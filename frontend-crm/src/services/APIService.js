import axios from "axios";
import CookiesService from "./CookiesService";

const url = "http://localhost:8080/";
axios.defaults.withCredentials = true;

class APIService {
  getTest() {
    return axios.get(this.getUrl("test"));
  }

  login(user) {
    return axios.post(this.getUrl("login"), user);
  }

  getOpportunities() {
    return axios.get(this.getUrl("opportunities"));
  }

  newOpportunity(opportunity) {
    return this.post(this.getUrl("opportunities/new"), opportunity);
  }

  getUrl(path) {
    return url + path;
  }

  post(url, data) {
    data.user = CookiesService.getUserId();
    return axios.post(url, data);
  }
}

export default new APIService();
