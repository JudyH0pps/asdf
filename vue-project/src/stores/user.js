import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "@/util/http-common";

export const useUserStore = defineStore("user", () => {
  const userKey = ref("");
  const loginUser = ref("");

  function init() {
    const user = localStorage.getItem("loginUser");
    if (user) {
      loginUser.value = user;
      userKey.value = localStorage.getItem("userKey");
    }
  }

  function signup(signupData) {
    return axios({
      method: "post",
      url: "/user/signup",
      data: signupData,
    });
  }

  function login(loginData) {
    return axios({
      method: "post",
      url: "/user/login",
      data: loginData,
    })
      .then((response) => {
        if (response.data != "Fail") {
          localStorage.setItem("userKey", response.data.id);
          localStorage.setItem("loginUser", response.data.userId);
          loginUser.value = response.data.userId;
          userKey.value = response.data.id;
        } else {
          alert("로그인 실패");
        }
      })
      .catch((err) => {
        alert("로그인 실패");
      });
  }

  function logout() {
    localStorage.clear();
    loginUser.value = "";
    userKey.value = "";
  }

  const isLoggedIn = computed(() => {
    if (loginUser.value != "") return true;
    return false;
  });

  return { init, loginUser, login, logout, signup, isLoggedIn, userKey };
});
