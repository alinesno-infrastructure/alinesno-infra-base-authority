import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

// >>>>>>>>> saToken_start >>>>>>>>>>>>>>>>
export function setSaToken(saToken) {
	window.localStorage.setItem("satoken", saToken);
}
export function getSaToken() {
	window.localStorage.getItem("satoken") ; 
}
// >>>>>>>>> saToken_end >>>>>>>>>>>>>>>>

export function removeToken() {
  return Cookies.remove(TokenKey)
}
