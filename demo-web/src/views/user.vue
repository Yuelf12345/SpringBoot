<template>
  <div>
    <el-input v-model="user.userName" placeholder="userName"></el-input>
    <el-input v-model="user.userPassword"  placeholder="userPassword"></el-input>
    <el-input v-model="user.email" placeholder="email"></el-input>
    <el-button @click="handleAddUser">addUser</el-button>
    <el-button @click="handleGetUser">getUser</el-button>
    <el-button @click="handleUpdatedUser">updatedUser</el-button>
    <el-button @click="handleDeleteUser">deleteUser</el-button>
  </div>
</template>
<script setup lang="ts">
import { addUser,getUser,updatedUser,deleteUser } from "@/api/user";
import { reactive } from  "vue";
const user = reactive({
  userName: "",
  userPassword: "",
  email: "",
});
const handleAddUser = () => {
  addUser(user).then((res) => {
    console.log(res);
  });
};
const handleGetUser = () => {
  getUser(1).then((res) => {
    console.log(res);
  });
};
const handleDeleteUser = () => {
  deleteUser(1).then((res) => {
    console.log(res);
  });
};
const handleUpdatedUser = () => {
  updatedUser({
    userId: 1,
    userName: "admin",
    userPassword: "123456",
    email: "admin@qq.com",
  }).then((res) => {
    console.log(res);
  });
};
</script>
