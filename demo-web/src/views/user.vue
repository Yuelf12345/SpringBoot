<template>
  <div>
    <el-input v-model="user.userName" placeholder="userName"></el-input>
    <el-input v-model="user.userPassword"  placeholder="userPassword"></el-input>
    <el-input v-model="user.email" placeholder="email"></el-input>
    <el-button @click="handleAdduer">addUser</el-button>
  </div>
</template>
<script setup lang="ts">
import { addUser } from "@/api/user";
import { reactive } from  "vue";
const user = reactive({
  userName: "",
  userPassword: "",
  email: "",
});
const handleAdduer = () => {
  addUser(user).then((res) => {
    console.log(res);
  });
};
</script>
