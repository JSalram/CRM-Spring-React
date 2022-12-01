class CookiesService {
  getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(";").shift();
  }

  getUserId() {
    return this.getCookie("userId");
  }

  getToken() {
    return this.getCookie("token");
  }

  getUserData() {
    return {
      id: this.getUserId(),
      token: this.getToken(),
    };
  }

  setUserData(data) {
    const { userId, token } = data;
    document.cookie = `userId=${userId};`;
    document.cookie = `token=${token};`;
  }
}

export default new CookiesService();
