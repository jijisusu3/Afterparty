const HOST = "http://localhost:8080/api/"
const ACCOUNTS = "users"

export default {
  accounts: {
    login: () => HOST + "auth/login",
    signup: () => HOST + ACCOUNTS ,
    currentUserInfo: () => HOST + ACCOUNTS + '/profile',
  }
}