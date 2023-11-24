<script setup>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';

const router = useRouter();
const userStore = useUserStore();

const userId = ref("");
const password = ref("");
const passwordCheck = ref("");
const email = ref("");


const checkText = computed(() => {
  if (passwordCheck.value === "") {
    return "비밀번호를 입력해주세요.";
  } else if (passwordCheck.value === password.value) {
    return "비밀번호가 일치합니다.";
  }
  return "비밀번호가 일치하지 않습니다!";
});



const signup = () => {
  if (checkText.value != "비밀번호가 일치합니다.") {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }

  const signupData = {
    userId: userId.value,
    password: password.value,
    email: email.value,
  }

  userStore.signup(signupData)
    .then((response) => {
      if (response.data === 1) {
        userStore.login({
          ...signupData,
        })
      } else {
        alert("회원가입 실패 ")
      }
    })
    .then(() => { router.push('/') })
    .catch((err) => {
      if (err.response.data.message.includes("Duplicate")) {
        alert("중복된 아이디가 존재합니다");
      } else {
        alert("회원가입 요청 오류");
      }
    });
}
</script>

<template>
  <div class="create">
    <h1>회원가입</h1>
    <div class="inputDiv">
      <form>
        <div class="formDiv">
          <div>
            <label for="userId">id</label>
            <input id="userId" name="userId" v-model="userId">
          </div>
          <div>
            <label for="password">pw</label>
            <input type="text" id="password" name="password" v-model="password">
          </div>
          <div>
            <label for="passwordCheck">pw 확인</label>
            <input type="text" id="passwordCheck" name="passwordCheck" v-model="passwordCheck">
          </div>
          <span>{{ checkText }}</span>
          <div>
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" v-model="email">
          </div>
        </div>
      </form>
      <button type="button" @click="signup">회원가입</button>
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

span {
  text-align: center;
}

.inputDiv {
  border: 2px solid #ebc5c5;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 10px;
}

.create form {
  display: flex;
  flex-direction: row;
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
