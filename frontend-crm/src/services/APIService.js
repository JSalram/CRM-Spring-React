import axios from "axios";

const url = "http://localhost:8080/";

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

  getUrl(path) {
    return url + path;
  }
}

export default new APIService();
