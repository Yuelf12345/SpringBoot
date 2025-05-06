<script setup lang="ts">
import { getStudentList,getStudentInfo } from '@/api/student'
const handleGetList = () =>{
  getStudentList().then(res => {
    console.log('res', res)
  })
}
const handleGetInfo = (id: number) =>{
  getStudentInfo(id).then(res => {
    console.log('res', res)
  })
}
</script>

<template>
  <div>
    <h1>student</h1>
    <el-button @click="handleGetList">list</el-button>
    <el-button @click="handleGetInfo(2)">Info</el-button>
  </div>
</template>

<style scoped lang="scss">

</style>