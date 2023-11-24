<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/user';

const router = useRouter();

const userId = ref("");
const password = ref("");

const userStore = useUserStore();

const submit = () => {
  const loginData = {
    userId: userId.value,
    password: password.value,
  };
  
  userStore.login(loginData).then(() => {
    router.push("/");
  });
}
</script>

<template>
  <div class="create">
    <h1>로그인</h1>
    <div class="inputDiv">
      <form>
        <div class="formDiv">
          <div>
            <label for="userId">id</label>
            <input id="userId" name="userId" v-model="userId">
          </div>
          <div>
            <label for="password">password</label>
            <input type="text" id="password" name="password" v-model="password">
          </div>
        </div>
      </form>
      <button type="button" @click="submit">전송</button>
    </div>
  </div>
</template>

<style scoped>
.create {
  display: flex;
  flex-direction: column;
  align-items: center;

}

label {
  width: 40%;
  text-align: left;
}

.inputDiv {
  border: 2px solid #ebc5c5;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 10px;
}

.formDiv {
  display: flex;
  flex-direction: column;
}

.formDiv>div {
  display: flex;
}


.create form {
  display: flex;
  flex-direction: row;
}

.formDiv {
  display: flex;
  flex-direction: column;
}

.create form {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.create form * {
  margin: 5px;
}

.create form>div {
  display: flex;
  width: 350px;
}

.previewImage {
  display: flex;
  flex-direction: column;
  height: 200px;
  align-items: center;
  justify-content: space-around;
  border: 1px solid #eee;
}

.previewImage img {
  max-height: 200px;
  max-width: 400px;

}

label {
  font-weight: bold;
}

input {
  width: 100%;
}
</style>
