<script setup>
import { onMounted, ref } from 'vue';
import axios from '@/util/http-common';
import { useUserStore } from '@/stores/user';

const userStore = useUserStore();

const campList = ref([]);
let userLikeCampList = ref([]);

function isLiked(campKey) {
  return userLikeCampList.value.includes(campKey);
}

function userLikeCamp(campKey) {
  axios.post(`/user/${userStore.userKey}/like/${campKey}`)
    .then((response) => {
      fetchLikeList();
    });
};

function userDislikeCamp(campKey) {
  axios.delete(`/user/${userStore.userKey}/like/${campKey}`)
    .then((response) => {
      fetchLikeList();
    });
};

function fetchLikeList() {
  axios.get(`/user/${userStore.userKey}/like`)
    .then((response) => {
      userLikeCampList.value = response.data;
    });
}

onMounted(() => {
  axios.get('/camp').then((response) => {
    campList.value = response.data;
  });

  if (userStore.isLoggedIn) {
    fetchLikeList();
  }
})

</script>

<template>
  <div class="about">
    <h1>캠프장 목록</h1>
    <div class="camp-list">
      <div class="camp" v-for="(camp, index) in campList" :key="camp.id">
        <h4>{{ camp.name }}</h4>
        <!-- <img :src="`//localhost:9999/api/characterImage/${character.img}`"> -->
        <p>{{ camp.address }}</p>
        <img :src="`//localhost:8080/api/camp/image/${camp.img}`" />
        <p> {{ camp.description }}</p>
        <div v-if="userStore.isLoggedIn">
          <span v-if="isLiked(camp.id)" @click="userDislikeCamp(camp.id)">🧡</span>
          <span v-else @click="userLikeCamp(camp.id)">🤍</span>
        </div>
      </div>

    </div>
  </div>
</template>

<style>
h1 {
  text-align: center;
}

.about {
  display: flex;
  flex-direction: column;
}

.camp-list {
  display: flex;
  flex-flow: wrap;
}

.about {
  display: flex;
}

.camp {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 250px;
  margin: 20px;
  border: 2px solid #eee7f9;
  border-radius: 10px;
  padding: 10px;
  font-weight: bold;
  font-size: 20px;
  justify-content: space-around;
}

.camp img {
  width: 80%;
}
</style>
