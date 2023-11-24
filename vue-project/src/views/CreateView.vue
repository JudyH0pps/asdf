<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/util/http-common';

const inputForm = new FormData();
const router = useRouter();
const name = ref("");
const description = ref("");
const address = ref("");
const previewImage = ref("");

const appendData = () => {
  inputForm.append('name', name.value);
  inputForm.append('description', description.value);
  inputForm.append('address', address.value);
  inputForm.append('userKey', localStorage.getItem("userKey"));
}

const appendImage = (e) => {
  // form에 append
  const file = e.target.files[0];
  inputForm.append('campImage', file);

  // 미리보기 image
  const reader = new FileReader();

  reader.onload = (e) => {
    previewImage.value = e.target.result;
  }
  reader.readAsDataURL(file);
}

const submitCamp = () => {
  appendData();

  axios({
    method: 'post',
    url: '/camp',
    headers: { 'Content-Type': 'multipart/form-data' },
    data: inputForm,
  }).then((response) => {
    if (response.data === 1) {
      alert("등록 완료")
      router.push('/');
    } else {
      alert("등록 실패")
    }
  }).catch((err) => {
    console.log(err);
    alert("등록 요청 실패");
  });

}
</script>

<template>
  <div class="create">
    <h1>캠프장 등록</h1>
    <div class="inputDiv">
      <form>
        <div class="formDiv">
          <div>
            <label for="name">이름</label>
            <input id="name" name="name" v-model="name">
          </div>
          <div>
            <label for="address">주소</label>
            <input type="text" id="address" name="address" v-model="address">
          </div>
          <div>
            <label for="description">설명</label>
            <textarea id="description" name="description" v-model="description" />
          </div>

          <div>
            <label for="characterImage">이미지</label>
            <input type="file" accept="image/*" @change="appendImage" id="characterImage" name="characterImage">
          </div>
        </div>
        <div class="previewImage">
          <p>사진 미리보기</p>
          <img :src="previewImage">
        </div>
      </form>
      <button type="button" @click="submitCamp">전송</button>
    </div>
  </div>
</template>

<style scoped>
.create {
  display: flex;
  flex-direction: column;
  align-items: center;

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
  justify-content: space-between;
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
  height: 300px;
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
</style>
