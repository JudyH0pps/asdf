<script setup>
import { RouterLink, RouterView } from "vue-router";
import { useUserStore } from "@/stores/user";
import { onMounted } from 'vue';

const userStore = useUserStore();

onMounted(() => {
  userStore.init();
});
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>

        <RouterLink to="/">캠프장목록</RouterLink>
        <RouterLink to="/create">캠프장등록</RouterLink>
        <div v-if="!userStore.loginUser">
          <RouterLink to="/login">로그인</RouterLink>
          <RouterLink to="/signup">회원가입</RouterLink>
        </div>
        <div v-else>
          <RouterLink to="/mypage">{{ userStore.loginUser }}님 ㅎㅇ</RouterLink>
          <a href="#" @click="userStore.logout()">로그아웃</a>
        </div>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap");

* {
  font-family: "Gowun Dodum", sans-serif;
  font-size: 18px;
}

body {
  height: 100vh;
  width: 100vw;
}

nav {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

nav div {
  display: flex;
}

nav a {
  margin: 20px;
}

h1, h2, h3, h4 {
  text-align: center;
  margin: 20px;
}
</style>
